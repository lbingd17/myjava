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



Reference:

http://www.cnblogs.com/xwdreamer/archive/2012/05/30/2526822.html

http://www.cnblogs.com/xwdreamer/archive/2012/05/14/2499339.html

http://blog.csdn.net/zhangerqing/article/details/8122075

http://blog.csdn.net/zhangerqing/article/details/8193118
