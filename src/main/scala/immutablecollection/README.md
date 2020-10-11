## Collections in Scala

Collections are the container of things that contains a random number of elements. All collection classes are found in the package scala.collection. Collections are of two types –

1. Mutable Collections
2. Immutable Collections

__Mutable Collection__ – This type of collection is changed after it is created. All Mutable collection classes are found in the package scala.collection.mutable.

__Immutable Collection__ – This type of collection will never change after it is created. All Immutable collection classes are found in the package scala.collection.immutable.

### Immutable collection

#### List
List is an immutable ordered collection of elements of a particular type.

Example 

`val list1:List[String] = List("A","B")`

To declare an empty list without type of elements

`val list3 = List.empty`

**Index in scala list starts from 0.**

To get nth element , we can use <listname>(n-1). For example to get first element from list1,

`list1(0)`

To append an element to a list1, we need to create another list and assign addition of list1 and new element
like below:

    scala> val list2:List[String] = list1 :+ "C"
    list2: List[String] = List(A, B, C)

To prepend an element

    scala> val list4:List[String] = "C" +: list1
    list4: List[String] = List(C, A, B)


To add two lists together, we use :::

    scala> val list5:List[String] = List("D")
    list5: List[String] = List(D)
    
    scala> val list6:List[String] = list2 ::: list5
    list6: List[String] = List(A, B, C, D)
    
We can also declare list containing elements of multiple types using type `Any` like below:

    scala> val list9:List[Any] = List("A","B",9,true)
    list9: List[Any] = List(A, B, 9, true)
    
There are 3 important functions to work with list.

1. head - it returns first element of list.
2. tail - it returns all elements except first in list.
3. isEmpty - which tells whether list is empty or not.

    scala> list9.head
    res1: Any = A
    
    scala> list9.tail
    res2: List[Any] = List(B, 9, true)
    
    scala> list9.isEmpty
    res3: Boolean = false

**List can have duplicate elements.**

ListSet is another data structure based on Set similar to List with a difference it cannot have duplicate elements.

#### Map

Map is an collection of key-value pairs in scala. 

We can declare a map using either of two notations below:

    scala> val map1:Map[Int,String] = Map((1,"A"),(2,"B"))
    map1: Map[Int,String] = Map(1 -> A, 2 -> B)

    scala> val map2:Map[Int,String] = Map(1 -> "A",2 -> "B")
    map2: Map[Int,String] = Map(1 -> A, 2 -> B)
    
To print value for any key we can use like `map1(1)` .

**Map can not have elements with duplicate keys.**

To add two maps together, we can use ++ like below

    scala> val map4:Map[Int, String] = Map(3 -> "C", 4 -> "D")
    map4: Map[Int,String] = Map(3 -> C, 4 -> D)
    
    scala> val map5 = map1 ++ map4
    map5: scala.collection.immutable.Map[Int,String] = Map(1 -> A, 2 -> B, 3 -> C, 4 -> D)
    
An empty map can be initialized like below:

    scala> val emptyMap:Map[Int, String] = Map.empty[Int, String]
    emptyMap: Map[Int,String] = Map()
    
To add an element to Map, we can use + operator like below

    scala> val map8:Map[Int,String] = emptyMap + (1 ->"AB")
    map8: Map[Int,String] = Map(1 -> AB)

    
To remove any element, we need to use - operator with elements key like below

    scala> val map6:Map[Int, String] = map5 - (4)
    map6: Map[Int,String] = Map(1 -> A, 2 -> B, 3 -> C)
    
[Difference between Map and Hashmap](https://stackoverflow.com/questions/31685236/scala-map-vs-hashmap)

**Hashing is a technique of converting a large String to small String that represents same String. A shorter value helps
 in indexing and faster searches.** 
 
We can use TreeMap as well instead of Map when we want keys to be sorted for better performance.
We can create a TreeMap using similar notation as map like below:

    val treemap:TreeMap[Int, String] = TreeMap(1 -> "A", 2 -> "B")

[https://stackoverflow.com/questions/28326766/when-to-use-scala-treemap](https://stackoverflow.com/questions/28326766/when-to-use-scala-treemap)

#### Queue

Queue is an first-in, first-out data structure in scala. It can be both mutable and immutable.

The two most basic operations of Queue are __Enqueue__(adding element at the end) and __Dequeue__(removing element from
the beginning).

We can define a queue like below:

`val queue:Queue[String] = Queue("A","B","C")`

Enqueue and Dequeue works like below:
 
`val queue1:Queue[String]= queue.enqueue("D")`

`val queue3:(String,Queue[String])= queue1.dequeue`

__Methods in Queue__:

1. +=: This method is used to add a single element in the end of the queue.

2. ++=: This method is used to Insert more than one the element in the end of the queue.

3. clear: Remove all elements from the queue.

4. dequeue: Returns the first element in the queue

5. enqueue: Adds all the elements to the queue.

6. equals: Checks if two queues are structurally identical.

7. front: Returns the first element in the queue.

8. isEmpty: Check if the queue is empty or not.

#### Sequence

Sequence is an iterable collection of elements having a defined order. Its elements can be accessed using 
their indices.

We can declare a simple Sequence like below;

    scala> val seq:Seq[String] = Seq("A","B","C")
    seq: scala.collection.immutable.Seq[String] = List(A, B, C)

__NOTE:-__ Sequence is a trait and if you look carefully in the console window above, the elements of the
 Sequence were rendered into a concrete Immutable List.
 
__Some of the Predefined Methods used in Sequence__

1. def apply(index: Int): A -> To slect an element from the sequence

2. def contains[A1 >: A](elem: A1): Boolean -> To check whether a sequence contains the given element

3. def count(p: (A)=> Boolean): Int-> To count the number of elements that satisfies a predicate

4. def length: Int -> gives the length of the Sequence

5. def copyToArray(xs: Array[A], start: Int, len: Int): Unit -> For copying the elements of Sequence to array

6. def endsWith[B](that: GenSeq[B]): Boolean-> to check whether a sequence terminates with a given sequence or not

7. def head: A ->It selects the first element of the sequence.

8. def indexOf(elem: A): Int-> To find the index of first occurrence of a value in the sequence

9. def isEmpty: Boolean ->To test the emptiness of the sequence.

10. def lastIndexOf(elem: A): Int-> To find the index of last occurrence of a value in the sequence

11. def reverse: Seq[A]-> To return a new sequence with elements in reverse order.
 
#### Set

Set is an unordered collection of unique elements in scala.

We can create a set like below:

`val set1:Set[String] = Set("A", "B")`

We cannot get elements of Set by indexes as it is unordered.

To check an element exists in Set or not, we can use __contains__ method:

`set1.contains("A")`

To add an element to an existing set, we can use + operator

`val set2:Set[String] = set1 + "D"`

We can add two sets using ++ like below

    scala> val set3:Set[String] = Set("C","D")
    set3: scala.collection.immutable.Set[String] = Set(C, D)
    
    scala> val set4:Set[String] = set1 ++ set3
    set4: scala.collection.immutable.Set[String] = Set(A, B, C, D)
    
To remove an element, we can use - operator

`val set5:Set[String] = set4 - "D"`

To find intersection of two sets, we use __&__ and to find difference of two sets, we use __&~__

`val set6:Set[String] = set4 & set1`

`val set7:Set[String] = set4 &~ set5`


### References
1. [AllAboutScala](http://allaboutscala.com/)

2. [Alvin Alexander](https://alvinalexander.com/)

3. [Geeksforgeeks](https://geeksforgeeks.org)











