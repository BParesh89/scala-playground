### Variables
A variable is reserved memory location or container to store values. There are two types of variables in scala :

#### 1. Immutable variables

Immutability is a first class citizen in the Scala programming language. Their values cannot be changed once assigned. To define immutable variable, we use the keyword _**val**_ with the following syntax:

`val <Name of our variable>: <Scala type> = <Some literal>`

If we try to change value of immutable variable declared with **val** , it gives error like below:

    scala> val a:Int = 5
    a: Int = 5
    
    scala> a = 6
    <console>:12: error: reassignment to val
           a = 6
             ^

#### 2. Mutable variables

Mutables variable's value can changed after assigning it once. We need such variables in cases like for-loop where we might need to change a variable with every iteration. We declare mutable variables with keyword _**var**_ like below :

    scala> var a:Int = 6
    a: Int = 6
    
    scala> a = 5
    a: Int = 5

#### 3. Lazy initialization
 Sometimes you may wish to delay the initialization of some variable until at the point where it is consumed by your application. This is usually referred to as lazy initialization and we need to make use of the lazy keyword
 
 
` lazy val donutService = "initialize some donut service"`
#### 4. Scala supported types
Scala doesn't have supported types built-in like Java but it has its owne classes to support types as shown below:

    val donutsBought: Int = 5
    val bigNumberOfDonuts: Long = 100000000L
    val smallNumberOfDonuts: Short = 1
    val priceOfDonut: Double = 2.50
    val donutPrice: Float = 2.50f
    val donutStoreName: String = "allaboutscala Donut Store"
    val donutByte: Byte = 0xa
    val donutFirstLetter: Char = 'D'
    val nothing: Unit = () 
    val bool: Boolean = true 
 
#### 5. Declare a variable with default type initialization
We can also declare a variable with default type initialization and assign it a value later like below :

    scala> var a:Int = _
    a: Int = 0
    
    scala> a = 5
    a: Int = 5

Above kind of initialization is ofcourse not possible with variables declared as **val**.

### String Interpolation
We use **$** symbol for string interpolation in Scala.

Example 1: Formatting string

    scala> val name:String = "Paresh"
    name: String = Paresh
    scala> print(s"My name is $name")
    My name is Paresh
 
Example 2: Formatting numbers:

    scala> println(s"The number is $a")
    The number is 5.2224
    scala> println(f"The number is $a%.2f")
    The number is 5.22
    
### If Else If
Below is one example:

    val a:Int = 100
    if (a <= 5){
      println("Number less than equal to 5")
    }else if(a >= 5 && a <= 10){
      println("Number between 5 and 10")
    }else
      println("Number greater than 10")
      
### For loop
Below is example of using **to** and **until**:

    println("Demo for loop using to")
    for(a <- 1 to 5)
      println(s"Number is $a")
    println("Demo for lo0p using until")
    for( b<- 1 until 5)
      println(s"Number is $b")

Here above, this 1 until 5 creates a scala range (1,2,3,4). Alphabetical range can also be created with below syntax:    
`'a' to 'z'`


With **to**, forloop prints upto number. With **until**, forloop prints upto 1 less than number limit. Output for above code is :

    Demo for loop using to
    Number is 1
    Number is 2
    Number is 3
    Number is 4
    Number is 5
    Demo for lo0p using until
    Number is 1
    Number is 2
    Number is 3
    Number is 4
    
#### **yield** keyword
As a quick summary of the yield keyword:

1. For each iteration of your for loop, yield generates a value which is remembered by the for loop (behind the scenes, like a buffer).
2. When your for loop finishes running, it returns a collection of all these yielded values.
3. The type of the collection that is returned is the same type that you were iterating over.                             
Example :   
                                                                                                               
        scala> val v = for (i <- 1 to 5) yield i
        v: scala.collection.immutable.IndexedSeq[Int] = Vector(1, 2, 3, 4, 5)
        
        scala> for (j <- v) println(j)
        1
        2
        3
        4
        5
        
For more details please check here, https://alvinalexander.com/scala/scala-for-loop-yield-examples-yield-tutorial/

### While and Do-While
Below is an example of while and do-while.    
                                          
    println("Demo of while loop")
    var a = 10
    while (a > 5) {
      println(s"Number is $a")
      a -= 1
    }
    println("Demo of do-while")
    println(s"Present value of a is  $a")
    do{
      a +=1
      println(s"Number is $a")
    }while(a < 10)

Output of above code is:

    Demo of while loop
    Number is 10
    Number is 9
    Number is 8
    Number is 7
    Number is 6
    Demo of do-while
    Present value of a is  5
    Number is 6
    Number is 7
    Number is 8
    Number is 9
    Number is 10
    
### Pattern matching using **match**
Example1.

    println("Step 1: Pattern matching 101 - a very basic example")
    val donutType = "Glazed Donut"
    donutType match {
      case "Glazed Donut" => println("Very tasty")
      case "Plain Donut" => println("Tasty")
    }

Output of above is :

    Step 1: Pattern matching 101 - a very basic example
    Very tasty

Example2.                                           

    val tasteLevel4 = donutType match {
      case donut if (donut.contains("Glazed") || 
            donut.contains("Strawberry")) => "Very tasty"
      case "Plain Donut"  => "Tasty"
      case _  => "Tasty"
    }
    println(s"Taste level of $donutType = $tasteLevel4")
    
Output for above code is:

`Taste level of Glazed Donut = Very tasty`

### Tuple
Scala tuple combines a fixed number of items together so that they can be passed around as a whole. Unlike an array or list, a tuple can hold objects with different types but they are also immutable.

We can declare TupleN class variable to hold N values like below                        

    scala> val t = Tuple2(1,2)
    t: (Int, Int) = (1,2)
We can declare tuple with element of different types      
                              
    scala> val t1 = Tuple2(3, 't')
    t1: (Int, Char) = (3,t)
   
We can access individual element of above tuple with syntax : `t._1`

We can also iterate over tuple using method productIterator like below :

    scala> val t2 = (3,4,'t', true)
    t2: (Int, Int, Char, Boolean) = (3,4,t,true)
    
    scala> t2.productIterator.foreach(i => println(i))
    3
    4
    t

### Option keyword
When you are not sure whether a variable can be null or hold a value, we can declare it using **Option** class with keyword **Some**.

    scala> val glazedDonutTaste: Option[String] = Some("Very Tasty")
    glazedDonutTaste: Option[String] = Some(Very Tasty)

We can also assign None to Option class variable. If we later want to assign it some value, we can define it like below:

    scala> var glazedDonutTaste: Option[String] = None
    glazedDonutTaste: Option[String] = None
    
    scala> glazedDonutTaste = Some("Tasty")
    glazedDonutTaste: Option[String] = Some(Tasty)

### Class and Type hierarchy in scala

Any is the root type and it has two sub-classes namely AnyVal and AnyRef as per the above diagram.

![](https://github.com/BParesh89/scala-playground/tree/master/src/resources//class-hierarchy-of-scala.png)

### Enumerations

An enumerations serve the purpose of representing a group of named constants in a programming language. We dont have
enum keyword in scala, instead we can create enumeration by extending Enumeration class in scala.



 
