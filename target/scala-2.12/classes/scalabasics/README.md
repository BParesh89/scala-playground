### Variables
A variable is reserved memory location or container to store values. There are two types of variables in scala :

####1. Immutable variables

Immutability is a first class citizen in the Scala programming language. Their values cannot be changed once assigned. To define immutable variable, we use the keyword _**val**_ with the following syntax:

`val <Name of our variable>: <Scala type> = <Some literal>`

If we try to change value of immutable variable declared with **val** , it gives error like below:

    scala> val a:Int = 5
    a: Int = 5
    
    scala> a = 6
    <console>:12: error: reassignment to val
           a = 6
             ^

####2. Mutable variables

Mutables variable's value can changed after assigning it once. We need such variables in cases like for-loop where we might need to change a variable with every iteration. We declare mutable variables with keyword _**var**_ like below :

    scala> var a:Int = 6
    a: Int = 6
    
    scala> a = 5
    a: Int = 5

####3. Lazy initialization
 Sometimes you may wish to delay the initialization of some variable until at the point where it is consumed by your application. This is usually referred to as lazy initialization and we need to make use of the lazy keyword
 
 
` lazy val donutService = "initialize some donut service"`
####4. Scala supported types
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
 
####5. Declare a variable with default type initialization
We can also declare a variable with default type initialization and assign it a value later like below :

    scala> var a:Int = _
    a: Int = 0
    
    scala> a = 5
    a: Int = 5

Above kind of initialization is ofcourse not possible with variables declared as **val**.

###String Interpolation
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
    
####If Else If
Below is one example:
