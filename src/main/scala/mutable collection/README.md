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
    
 