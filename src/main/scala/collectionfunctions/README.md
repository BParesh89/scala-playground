### Collection Functions

#### filter and filterNot 

filter and filterNot accepts a anonymous function which is used to filter records.

    scala> val arrf:Array[String] = Array("indiagate","tajmahal","colgate")
    arrf: Array[String] = Array(indiagate, tajmahal, colgate)
    
    scala> val arrf1 = arrf.filter{w => w.contains("gate")}
    arrf1: Array[String] = Array(indiagate, colgate)
    
    scala> val arrf1 = arrf.filterNot{w => w.contains("gate")}
    arrf1: Array[String] = Array(tajmahal)
 
Both filter and filterNot returns an empty iterable if no element is found as result

   
#### find

find is similar to filter except it returns Option value if some value satisfies the condition and 
returns only first value satisfying the condition.

Example:

    scala> val arrf1 = arrf.find{w => w.contains("gatc")}
    arrf1: Option[String] = None
    
    scala> val arrf1 = arrf.find{w => w.contains("gate")}
    arrf1: Option[String] = Some(indiagate)
    
#### map

map takes a predicate function , applies it on every element of an collection and returns a new collection.

Example:

    scala> val arrf2:Array[String] = arrf.map( _+ "1")
    arrf2: Array[String] = Array(indiagate1, tajmahal1, colgate1)
    
### flatten

flatten will collapse the elements of an collection and create a single collection by combining them all.

    scala> arrf2.flatten
    res27: Array[Char] = Array(i, n, d, i, a, g, a, t, e, 1, t, a, j, m, a, h, a, l, 1, c, o, l, g, a, t, e, 1)

Like above, every element was a String. So flatten collapsed each string into chraractes and combined them together as 
an array of characters.

#### flatMap

flatMap also takes a predicate function, applies it on every element of collection and returns a new collection.
It essentially runs map function first with predicate functions supplied followed by flatten.

    scala> val arrf3:Array[Seq[String]] = Array(arrf, arrf2)
    arrf3: Array[scala.collection.mutable.Seq[String]] = Array(WrappedArray(indiagate, tajmahal, colgate), WrappedArray(indiagate1, tajmahal1, colgate1))
    
    scala> arrf3.flatMap(w => w)
    res29: Array[String] = Array(indiagate, tajmahal, colgate, indiagate1, tajmahal1, colgate1)
    
Here, above flatMap creates a single array of all elements from arrf3 which is itself combination of 
two arrays of string.

#### fold

fold method takes an associative binary operator function as a parameter and will use it to collapse elements
from the collection. The fold method also allows you to specify an initial value.

    scala> val p:Seq[Double] = Seq(90.8, 40, 1)
    p: scala.collection.mutable.Seq[Double] = ArrayBuffer(90.8, 40.0, 1.0)
    
    scala> p.fold(0.0)(_ + _)
    res30: Double = 131.8
    
#### foreach

foreach takes a function as an argument and applies it to each element of the collection.

    scala> p.foreach(println(_))
    90.8
    40.0
    1.0 
 
#### reduce

reduce is similar to __fold__ except it doesn't allow to specify initial value.

    scala> q.reduce(_ + _)
    res44: Double = -0.5
    
#### partition

partition is similar to filter except it returns two collection, one which satisfies the function
and one which doesn't.

    scala> arrf.partition(w => w.contains("gate"))
    res46: (Array[String], Array[String]) = (Array(indiagate, colgate),Array(tajmahal)
    
#### size

size returns the number of elements in collection.

    scala> q.size
    res47: Int = 2
    
#### reverse

reverse function returns the collection which contains elements in reverse order.

    scala> q.reverse
    res49: scala.collection.mutable.Seq[Double] = ArrayBuffer(9.5, -10.0)
    
#### zip

zip takes another collection as a parameter and merges its elements with elements of current collection so that
it forms a pair or tuple.

    scala> val r = p zip q
    r: scala.collection.mutable.Seq[(Double, Double)] = ArrayBuffer((90.8,-10.0), (40.0,9.5))
    
#### unzip

unzip returns all connections in a paired collection separately.

    scala> r.unzip
    res52: (scala.collection.mutable.Seq[Double], scala.collection.mutable.Seq[Double]) = (ArrayBuffer(90.8, 40.0),ArrayBuffer(-10.0, 9.5))
    

### References
1. [AllAboutScala](http://allaboutscala.com/)

2. [Alvin Alexander](https://alvinalexander.com/)

3. [Geeksforgeeks](https://geeksforgeeks.org)
