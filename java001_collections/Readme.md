1. 概述
上述类图中，实线边框的是实现类，比如ArrayList，LinkedList，HashMap等;
折线边框的是抽象类，比如AbstractCollection，AbstractList，AbstractMap等;
而点线边框的是接口，比如Collection，Iterator，List等。

所有的集合类，都实现了Iterator接口，这是一个用于遍历集合中元素的接口，主要包含hashNext(),next(),remove()三种方法。
它的一个子接口LinkedIterator在它的基础上又添加了三种方法，分别是add(),previous(),hasPrevious()。
无序集合实现的都是Iterator接口，在遍历集合中元素的时候，只能往后遍历，被遍历后的元素不会在遍历到,比如HashSet，HashMap；
而那些元素有序的集合，实现的一般都是LinkedIterator接口，实现这个接口的集合可以双向遍历，既可以通过next()访问下一个元素，又可以通过previous()访问前一个元素，比如ArrayList。

还有一个特点就是抽象类的使用。如果要自己实现一个集合类，去实现那些抽象的接口会非常麻烦，工作量很大。这个时候就可以使用抽象类，这些抽象类中给我们提供了许多现成的实现，我们只需要根据自己的需求重写一些方法或者添加一些方法就可以实现自己需要的集合类，工作流昂大大降低。

2. 详解

2.1 HashSet是Set接口的一个子类，主要的特点是：
  里面不能存放重复元素，
  采用散列的存储方法，所以没有顺序。
  这里所说的没有顺序是指：元素插入的顺序与输出的顺序不一致。

2.2 ArrayList是List的子类，
  允许存放重复元素，有序。
  集合中元素被访问的顺序取决于集合的类型。
  如果对ArrayList进行访问，迭代器将从索引0开始，每迭代一次，索引值加1。然而，如果访问HashSet中的元素，每个元素将会按照某种随机的次序出现。虽然可以确定在迭代过程中能够遍历到集合中的所有元素，但却无法预知元素被访问的次序。

2.3 LinkedList是一种可以在任何位置进行高效地插入和删除操作的有序序列。

2.4 TreeSet和TreeMap 	有序（用二叉排序树）; 

2.5 HashMap

2.5.1 解决hash冲突的办法: 

    开放定址法（线性探测再散列，二次探测再散列，伪随机探测再散列）
    再哈希法
    链地址法
    建立一个公共溢出区

Java中hashmap的解决办法就是采用的链地址法。

2.5.2 HashMap和HashTable有什么区别，一个比较简单的回答是：

1)、HashMap是非线程安全的，HashTable是线程安全的。

2)、HashMap的键和值都允许有null值存在，而HashTable则不行。

3)、因为线程安全的问题，HashMap效率比HashTable的要高。

2.5.3 一、HashMap的内部存储结构
Java中数据存储方式最底层的两种结构，一种是数组，另一种就是链表，数组的特点：连续空间，寻址迅速，但是在删除或者添加元素的时候需要有较大幅度的移动，所以查询速度快，增删较慢。而链表正好相反，由于空间不连续，寻址困难，增删元素只需修改指针，所以查询慢、增删快。有没有一种数据结构来综合一下数组和链表，以便发挥他们各自的优势？答案是肯定的！就是：哈希表。哈希表具有较快（常量级）的查询速度，及相对较快的增删速度，所以很适合在海量数据的环境中使用。一般实现哈希表的方法采用“拉链法”，我们可以理解为“链表的数组”


面试时时被集合类各种虐，现在就来总结一下Java的集合类及其区别。


Java集合框架的基本接口、类层级结果如下:

java.util.Collection[接口]

  --java.util.List[接口]

      --java.util.AarrayList

      --java.util.LinkedList

  --java.util.Vector

    --java.util.Stack

  --java.util.Set[接口]

    --java.util.HashSet

    --java.util.SortedSet[接口]

    --java.util.TreeSet

  --java.util.Queue

java.util.Map[接口]

  --java.util.SortedMap[接口]

    --java.util.TreeMap

  --java.util.HashMap

  --java.util.HashTable

  --java.util.LinkedHashMap

  --java.util.WeakHashMap


1.Collection

    是最基本的集合类型，所有实现Collection接口的类都必须提供两个标准的构造函数：无参数的构造函数用于创建一个共的Collection，有一个Collection参数的构造函数用于创建一个新的Collection，这个新的Collection与传入的Collection有相同的元素。

若要检查Collection中的元素，可以使用foreach进行遍历，也可以使用迭代器，Collection支持iterator()方法，通过该方法可以访问Collection中的每一个元素。用法如下：

[java] view plain copy
在CODE上查看代码片派生到我的代码片

    Iterator it=collection.iterator();  
    while(it.hasNext()){  
       Object obj=it.next();  
    }  

Set和List是由Collection派生的两个接口


1.1 List接口
List是有序的Collection，使用此接口能够精确的控制每个元素插入的位置。用户能够使用索引的位置来访问List中的元素，类似于Java数组。
List允许有相同的元素存在。
除了具有Collection接口必备的的iterator()方法外，还提供了listIterator()方法，放回一个 ListIterator接口。
实现List接口的常用类有LinkedList、ArrayList、Vector和Stack
1.1.1 LinkedList类
   LinkedList实现了List类接口，允许null元素。此外LinkedList提供额外的get、remove、insert方法在LinkedList的首部或尾部。这些操作使LinkedList可被用作堆栈（stack），队列（queue）或双向队列（deque）
LinkedList没有同步方法。如果多个线程想访问同一个List，则必须自己实现访问同步。一种解决办法是在创建List时构造一个同步的List：
List list=Collection。synchronizedList（new LinkedList（...））
1.1.2 AyyayList类
ArrayList实现了可变大小的数组。它允许所有元素，包括null。ArrayList没有同步。
size(),isEmpty(),get(),set()方法运行时间为常数。但是add()方法开销为分摊的常数，添加n个元素需要O(n)的时间。其他的方法运行时间为线性。
每个ArrayList实例都有一个容量（Capactity），即用于存储元素的数组的大小。这个容量可随着不断添加新元素而自动增加，但是增长算法并没有定义。当需要插入大量元素时，在插入之前可以调用ensureCapacity()方法来增加ArrayList容量已提高插入效率
1.2Vector类
Vector非常类似ArrayList，当时Vector是同步的。由Vector创建的iterator，虽然和ArrayLsit创建的iterator是同一接口，但是，因为Vector是同步的，当一个iterator被创建而且这在被使用，另一个线程改变了Vector状态，这时调用iterator的方法时将抛出ConcurrentModificationException，因此必须捕获该异常。
1.3 Stack类

    Stack继承自Vector，实现了一个后进先出的堆栈。Stack提供了5个额外的方法使得Vector得以被当做堆栈使用。基本的push和pop方法，还有peek方法得到栈顶的元素，empty方法测试堆栈是否为空，serach方法检测一个元素在堆栈中的位置。Stack刚创建后是空栈。


1.4 Set接口
   Set是一种不包含重复元素的Collection，即任意的两个元素e1和e2都有e1.equals(e2)=false,Set最多有一个null元素。
   很明显，Set的构造函数有一个约束条件，传入的Collection参数不能包含重复的元素。
    请注意：必须小心操作可变对象。如果一个Set中的可变元素改变了自身的状态导致Object.equals(Object)=true将导致一些问题

1.4.1 HashSet
   HashSet调用对象的hashCode(),获得哈希码，然后在集合中计算存放对象的位置。通过比较哈希码与equals()方法来判别是否重复。所以，重载了equals()方法同时也要重载hashCode();

1.4.2 TreeSet
TreeSet 继承SortedSet接口，能够对集合中对象排序。默认排序方式是自然排序，但该方式只能对实现了Comparable接口的对象排序，java中对Integer、Byte、Double、Character、String等数值型和字符型对象都实现了该接口。


2 Map接口
      Map没有继承Collection接口，Map提供key到value的映射。一个Map中不能包含相同的key，每个key只能映射一个value。Map接口提供了3中集合的视图，Map的内容可以被当作一组key集合，一组value集合，或者一组key--value映射。

2.1 HashTable类
   HashTable继承Map接口，实现了一个key--value映射的哈希表。任何非空的对象都可作为key或者value。
  添加数据使用put(key,value),取出数据使用get(key)，这两个基本操作的时间开销为常数。
  HashTable通过initial caoacity和load factor两个参数调整性能。通常缺省的load factor 0.75较好地实现了时间和空间的均衡。增大了load factor可以节省空间但相应的查找时间将增大，这回影响像get和put这样的操作
HashTable是同步的

2.2 HashMap类
   HashMap和HashTable类似，不同之处在于HashMap是非同步的，并且允许null，即null value和null key，但是将HashMap视为Collection时，其迭子操作时间开销和HahMap的容量成比例。因此，如果迭代操作的性能相当重要的话，不要将HashMap的初始化容量设的过高，或者load factor过低

2.3 WeakHashMap类
WeakHashMap是一种改进的HashMap，他对key实行弱引用，如果一个key不再被外部所引用，那么该key可以被GC回收

Reference:

http://www.cnblogs.com/xwdreamer/archive/2012/05/30/2526822.html

http://www.cnblogs.com/xwdreamer/archive/2012/05/14/2499339.html

http://blog.csdn.net/zhangerqing/article/details/8122075

http://blog.csdn.net/zhangerqing/article/details/8193118

http://blog.csdn.net/zhj870975587/article/details/50996811
