

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



 [转]Java五个最常用的集合类之间的区别和联系

Map<String, ?>只能是只读模式，不能增加，因为增加的时候不知道该写入什么类型的值；
Map<String, Object>可以读和写，只要是所有Object类的子类都可以。

 

常用的集合类有一下几种：

List结构的集合类：ArrayList类，LinkedList类，Vector类，Stack类

Map结构的集合类：HashMap类，Hashtable类

Set结构的集合类：HashSet类，TreeSet类

Queue结构的集合：Queue接口

 

HashMap和Hashtable的区别：

HashMap和Hashtable都是java的集合类，都可以用来存放java对象，这是他们的相同点

以下是他们的区别：

1.历史原因：

Hashtable是基于陈旧的Dictionary类的，HashMap是java 1.2引进的Map接口的一个现实。

2.同步性：

Hashtable是同步的，这个类中的一些方法保证了Hashtable中的对象是线程安全的，而HashMap则是异步的，因此HashMap中的对象并不是线程安全的，因为同步的要求会影响执行的效率，所以如果你不需要线程安全的结合那么使用HashMap是一个很好的选择，这样可以避免由于同步带来的不必要的性能开销，从而提高效率，我们一般所编写的程序都是异步的，但如果是服务器端的代码除外。

3.值：

HashMap可以让你将空值作为一个表的条目的key或value

Hashtable是不能放入空值（null）的

 

ArrayList和Vector的区别：

ArrayList与Vector都是java的集合类，都是用来存放java对象，这是他们的相同点，

区别：

1.同步性：

Vector是同步的，这个类的一些方法保证了Vector中的对象的线程安全的，而ArrayList则是异步的，因此ArrayList中的对象并不 是线程安全的，因为同步要求会影响执行的效率，所以你不需要线程安全的集合那么使用ArrayList是一个很好的选择，这样可以避免由于同步带来的不必 要的性能开销。

2.数据增长：

从内部实现的机制来讲，ArrayList和Vector都是使用数组（Array）来控制集合中的对象，当你向两种类型中增加元素的时候，如果元素的数目超过了内部数组目前的长度他们都需要扩展内部数组的长度，Vector缺省情况下自动增长原来一倍的数组长度，ArrayList是原来的50%，所以最后你获得的这个集合所占的空间总是比你实际需要的要大，所以如果你要在集合中保存大量的数据，那么使用Vector有一些优势，因为你可以通过设置集合的初始大小来避免不必要的资源开销。

 

总结：

1）如果要求线程安全，使用Vector，Hashtable

2）如果不要求线程安全，使用ArrayList，LinkedList，HashMap

3)如果要求键值对，则使用HashMap，Hashtable

4）如果数据量很大，又要求线程安全考虑Vector

 

1．ArrayList: 元素单个，效率高，多用于查询

2．Vector:    元素单个，线程安全，多用于查询

3．LinkedList:元素单个，多用于插入和删除

4．HashMap:   元素成对，元素可为空

5．HashTable: 元素成对，线程安全，元素不可为空

 

ArrayList

底层是Object数组，所以ArrayList具有数组的查询速度快的优点以及增删速度慢的缺点。

而在LinkedList的底层是一种双向循环链表。在此链表上每一个数据节点都由三部分组成：前指针（指向前面的节点的位置），数据，后指针（指向后面的节点的位置）。最后一个节点的后指针指向第一个节点的前指针，形成一个循环。

双向循环链表的查询效率低但是增删效率高。

ArrayList和LinkedList在用法上没有区别，但是在功能上还是有区别的。

 

LinkedList

经常用在增删操作较多而查询操作很少的情况下：队列和堆栈。

队列：先进先出的数据结构。

栈：后进先出的数据结构。

注意：使用栈的时候一定不能提供方法让不是最后一个元素的元素获得出栈的机会。

 

Vector

（与ArrayList相似，区别是Vector是重量级的组件，使用使消耗的资源比较多。）

结论：在考虑并发的情况下用Vector（保证线程的安全）。

在不考虑并发的情况下用ArrayList（不能保证线程的安全）。

 

面试经验（知识点）：

java.util.stack（stack即为堆栈）的父类为Vector。可是stack的父类是最不应该为Vector的。因为Vector的底层是数组，且Vector有get方法（意味着它可能访问到并不属于最后一个位置元素的其他元素，很不安全）。

对于堆栈和队列只能用push类和get类。

Stack类以后不要轻易使用。

实现栈一定要用LinkedList。

（在JAVA1.5中，collection有queue来实现队列。）

 

Set-HashSet实现类：

遍历一个Set的方法只有一个：迭代器（interator）。

HashSet中元素是无序的（这个无序指的是数据的添加顺序和后来的排列顺序不同），而且元素不可重复。

在Object中除了有finalize()，toString()，equals()，还有hashCode()。

HashSet底层用的也是数组。

当向数组中利用add(Object o)添加对象的时候，系统先找对象的hashCode：

int hc=o.hashCode(); 返回的hashCode为整数值。

Int I=hc%n;（n为数组的长度），取得余数后，利用余数向数组中相应的位置添加数据，以n为6为例，如果I=0则放在数组a[0]位置，如果I=1,则 放在数组a[1]位置。如果equals()返回的值为true，则说明数据重复。如果equals()返回的值为false，则再找其他的位置进行比 较。这样的机制就导致两个相同的对象有可能重复地添加到数组中，因为他们的hashCode不同。

如果我们能够使两个相同的对象具有相同hashcode，才能在equals()返回为真。

在实例中，定义student对象时覆盖它的hashcode。

因为String类是自动覆盖的，所以当比较String类的对象的时候，就不会出现有两个相同的string对象的情况。

现在，在大部分的JDK中，都已经要求覆盖了hashCode。

结论：如将自定义类用hashSet来添加对象，一定要覆盖hashcode()和equals()，覆盖的原则是保证当两个对象hashcode返回相同的整数，而且equals()返回值为True。

如果偷懒，没有设定equals()，就会造成返回hashCode虽然结果相同，但在程序执行的过程中会多次地调用equals()，从而影响程序执行的效率。

 

我们要保证相同对象的返回的hashCode一定相同，也要保证不相同的对象的hashCode尽可能不同（因为数组的边界性，hashCode还是可能相同的）。

 

例子：

public int hashCode(){

return name.hashcode()+age;

}

这个例子保证了相同姓名和年龄的记录返回的hashCode是相同的。

 

使用hashSet的优点：

hashSet的底层是数组，其查询效率非常高。而且在增加和删除的时候由于运用的hashCode的比较开确定添加元素的位置，所以不存在元素的偏移，所以效率也非常高。因为hashSet查询和删除和增加元素的效率都非常高。

但是hashSet增删的高效率是通过花费大量的空间换来的：因为空间越大，取余数相同的情况就越小。HashSet这种算法会建立许多无用的空间。

使用hashSet类时要注意，如果发生冲突，就会出现遍历整个数组的情况，这样就使得效率非常的低。

http://blog.csdn.net/zhj870975587/article/details/50996811

http://www.cnblogs.com/ZhuRenWang/p/4773647.html
