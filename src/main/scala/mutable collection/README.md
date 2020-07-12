### Mutable collection

#### Array

An Array is a mutable data structure of fixed length. It also allows you to access and modify elements at specific 
index.

We can initialize an array with fixed length like below:

    scala> val arr:Array[String] = new Array[String](3)
    arr: Array[String] = Array(null, null, null)

and later add values to it like `arr(0) = "A"`

We can also directly create an array like below

    scala> val arr1:Array[String] = Array("A","B","C")
    arr1: Array[String] = Array(A, B, C)
    
We can access elements with index like `arr1(1)`

We can also modify elements like `arr1(1) = "D"`

We can also mutli-dim array in scala. To create a 2D array, we can use :

    scala> val arr2:Array[Array[Int]] = Array.ofDim[Int](2,2)
    arr2: Array[Array[Int]] = Array(Array(0, 0), Array(0, 0))
    
    scala> arr2(0)(0) = 1
    
    scala> arr2(0)(1) = 2
    
    scala> arr2(1)(0) = 3
    
    scala> arr2(1)(1) = 4
    
    scala> arr2
    res20: Array[Array[Int]] = Array(Array(1, 2), Array(3, 4))

We can merge two arrays using concat like below :

    scala> val arr3:Array[String] = Array("E","F")
    arr3: Array[String] = Array(E, F)
    
    scala> val arr4:Array[String] = Array.concat(arr1, arr3)
    arr4: Array[String] = Array(A, D, C, E, F)
    
We can check whether two arrays are equal or not using == operator.

    scala> arr1 == arr3
    res21: Boolean = false
    
#### Array Buffer

Array buffer is similar to array but its size is not fixed. We can declare an ArrayBuffer like below:

`val arrb:ArrayBuffer[String] = ArrayBuffer("A","B")`

We can add elements to it using += like below

    scala> arrb += "C"
    res22: arrb.type = ArrayBuffer(A, B, C)

We can remove an element using -+ like below

    scala> arrb -= "C"
    res23: arrb.type = ArrayBuffer(A, B)
    
#### ListBuffer

As per the Scala Documentation, a ListBuffer is resizable similar to an ArrayBuffer, except that it uses a Linked List
as its internal data structure.

We can define ListBuffer 

`val listb:ListBuffer[String] = ListBuffer("A","B")`

We can add elements using += and -= operators similar to ArrayBuffer.


**Other data structure like Map, Queue & Set have mutable version also. We can use them similar to as in
immutable version but without assigning to new instance.**

### References
1. [AllAboutScala](http://allaboutscala.com/)

2. [Alvin Alexander](https://alvinalexander.com/)

3. [Geeksforgeeks](https://geeksforgeeks.org)



    
 