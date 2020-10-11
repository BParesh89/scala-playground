### Functions

Functions in scala are declared with def keyword. 

#### Difference between Scala Functions & Methods: 
Function is a object which can be stored in a variable. But a method always belongs to a class which has a name, signature bytecode etc. Basically, you can say a method is a function which is a member of some object.

Syntax for declaring a function in scala:

    def function_name ([parameter_list]) : [return_type] = {
       
      // function body
    
    }

#### Example 1. 
Function with no parameters

    scala> def myBank():String = {"ICICI"}
    myBank: ()String
    
    scala> println("My bank name is "+ myBank())
    My bank name is ICICI

##### Note - last line of function is by defualt considered the value return by function.

Above simple function which doesn't do any complex processing can also be defined without parenthesis like below :

    scala> def myBank():String = "ICICI"
    myBank: ()String
    
    scala> println("My bank name is "+ myBank())
    My bank name is ICICI
    
#### Example 2.
Function with no return type i.e. Unit

    scala> def simplePrint():Unit={println("This is simple print")}
    simplePrint: ()Unit
    
    scala> simplePrint()
    This is simple print

Useful in cases where we dont want to return anything from function like in functions which simply writes data to some file.

#### Example 3.
Function with parameters, default value of parameters

    scala> def sum(a:Int, b:Int,c:Int=3 ):Int={ a+b+c }
    sum: (a: Int, b: Int, c: Int)Int
    
    scala> sum(3,2)
    res7: Int = 8
    
#### Example 4
Function having optional parameters defined with Option keyword

    def calculateDonutCostWithDefaultOptionValue(donutName: String, quantity: Int, couponCode: Option[String] = None): Double = {
      println(s"Calculating cost for $donutName, quantity = $quantity")
    
      couponCode match{
        case Some(coupon) =>
          val discount = 0.1 // Let's simulate a 10% discount
          val totalCost = 2.50 * quantity * (1 - discount)
          totalCost
    
        case _ => 2.50 * quantity
      }
    }
    println(\n"Step 4: How to call a function which has an Option parameter with a default value")
    println(s"""Total cost = ${calculateDonutCostWithDefaultOptionValue("Glazed Donut", 5)}""")
    println(s"""Total cost with discount = ${calculateDonutCostWithDefaultOptionValue("Glazed Donut", 5, Some("COUPON_1234"))}""")

Output of above code is:

    Step 4: How to call a function which has an Option parameter with a default value
    Calculating cost for Glazed Donut, quantity = 5
    Total cost = 12.5
    Calculating cost for Glazed Donut, quantity = 5
    Total cost with discount = 11.25
    
#### Example 5
Function that return Option type value    

    def dailyCouponCode(): Option[String] = {
      // look up in database if we will provide our customers with a coupon today
      val couponFromDb = "COUPON_1234"
      Option(couponFromDb).filter(_.nonEmpty)
    }
    val todayCoupon: Option[String] = dailyCouponCode()
    println(s"Today's coupon code = ${todayCoupon.getOrElse("No Coupon's Today")}")
    
To get return value of function having Option type return, we can use **getOrElse()** method. Output of above is :

`Today's coupon code = COUPON_1234`

#### Example 6
Functions with implicit parameters.

Implicit parameters are the parameters that are passed to a function with **implicit** keyword in Scala, which means the values will be taken from the context in which they are called. In simpler terms, if no value or parameter is passed to a method or function, then the compiler will look for implicit value and pass it further as the parameter. 

    def totalCost(donutType: String, quantity: Int)(implicit discount: Double): Double = {
      println(s"Calculating the price for $quantity $donutType")
      val totalCost = 2.50 * quantity * (1 - discount)
      totalCost
    }
    implicit val discount: Double = 0.1
    println(s"""Total cost with discount of 5 Glazed Donuts = ${totalCost("Glazed Donut", 5)}""")

Output of above code is

    Calculating the price for 5 Glazed Donut
    Total cost with discount of 5 Glazed Donuts = 11.25
   
We can also manually pass the parameter if needed for implicit parameters like below:

    def totalCost2(donutType: String, quantity: Int)(implicit discount: Double, storeName: String): Double = {
      println(s"[$storeName] Calculating the price for $quantity $donutType")
      val totalCost = 2.50 * quantity * (1 - discount)
      totalCost
    }
    println(s"""Total cost with discount of 5 Glazed Donuts, manually passed-through = ${totalCost2("Glazed Donut", 5)(0.1, "Scala Donut Store")}""")

Output of above code is

    [Scala Donut Store] Calculating the price for 5 Glazed Donut
    Total cost with discount of 5 Glazed Donuts, manually passed-through = 11.25
    
### Example 7
Implicit functions - Implicit functions allow us to define conversions between types.

Reference --> https://medium.com/@olxc/https-medium-com-olxc-implicits-in-scala-b2dcfccaa9e8

    implicit def intToStr(num: Int): String = s"The value is $num"
    
    42.toUpperCase() // evaluates to "THE VALUE IS 42"
    
    def functionTakingString(str: String) = str
    
    // note that we're passing int
    functionTakingString(42) // evaluates to "The value is 42"
  
When a compiler sees a type that is not expected in the evaluation context then it will try to find an implicit function in the current scope that can produce the expected type. In our example such contexts are expression 42.toUpperCase() and a function call functionTakingString(42). FunctiontoUpperCase() is not a defined on integers so intToStr is considered as a conversion and code compiles. The implicit function name is not that important — only the function type signature, in our case its (Int) => (String).

#### Example 8
Typed function - Functions which can accept data of multiple type for same argument. We can use pattern matching to 
handle this.

    def applyDiscount[T](discount: T) {
      discount match {
        case d: String =>
          println(s"Lookup percentage discount in database for $d")
    
        case d: Double =>
          println(s"$d discount will be applied")
    
        case _ => 
          println("Unsupported discount type")
      }
    }
    
    applyDiscount[String]("COUPON_123")
    applyDiscount[Double](10)    
   
Output of above code is:

    Lookup percentage discount in database for COUPON_123
    10.0 discount will be applied
    

#### Example 9
Polymorphic typed function with generic return type


    def applyDiscountWithReturnType[T](discount: T): Seq[T] = {
      discount match {
        case d: String =>
          println(s"Lookup percentage discount in database for $d")
          Seq[T](discount)
    
      case d: Double =>
          println(s"$d discount will be applied")
          Seq[T](discount)
    
      case d @ _ =>
          println("Unsupported discount type")
          Seq[T](discount)
      }
    }
    println("\nStep 4: How to call a generic typed function which also has a generic return type")
    println(s"Result of applyDiscountWithReturnType with String parameter = ${applyDiscountWithReturnType[String]("COUPON_123")}")
    
    println()
    println(s"Result of applyDiscountWithReturnType with Double parameter = ${applyDiscountWithReturnType[Double](10.5)}")
    
    println()
    println(s"Result of applyDiscountWithReturnType with Char parameter = ${applyDiscountWithReturnType[Char]('U')}") 

Output of above code is

    Step 4: How to call a generic typed function which also has a generic return type
    Lookup percentage discount in database for COUPON_123
    Result of applyDiscountWithReturnType with String parameter = List(COUPON_123)
    
    10.5 discount will be applied
    Result of applyDiscountWithReturnType with Double parameter = List(10.5)
    
    Unsupported discount type
    Result of applyDiscountWithReturnType with Char parameter = List(U)
    
**Note - For each of the specified types used when calling the polymorphic function applyDiscountWithReturnType(), the function also returns the Sequence of the same type.**

#### Example 10
Function with variable args 

    scala> def printReport(names: String*) {println(s"""Donut report = ${names.mkString(" - ")}""")}
    printReport: (names: String*)Unit
    
    scala> printReport("Chocolate Donut")
    Donut report = Chocolate Donut
    
    scala> printReport("Chocolate Donut", "Plain Donut")
    Donut report = Chocolate Donut - Plain Donut
    
If we want to pass any collection like List[String], Seq(String) or Array[String], then we can use type ascription like below :

    scala> val donutList:List[String] = List("Chocolate Donut", "Plain Donut")
    donutList: List[String] = List(Chocolate Donut, Plain Donut)
    
    scala> printReport(donutList: _*)
    Donut report = Chocolate Donut - Plain Donut
    
#### Example 11
Higher order functions which take another function as parameter

    def totalCost(donutType: String)(quantity: Int)(discount: Double): Double = {
      println(s"Calculating total cost for $quantity $donutType with ${discount * 100}% discount")
      val totalCost = 2.50 * quantity
      totalCost - (totalCost * discount)
    }
    
Now we can call this function using anonymous function(lambda) or simple function

With Anonymous function as parameter

    println("\nStep 3: How to call higher order function and pass an anonymous function as parameter")
      val totalCostOf5Donuts = totalCostWithDiscountFunctionParameter("Glazed Donut")(5){totalCost =>
      val discount = 2 // assume you fetch discount from database
      totalCost - discount
    }
    println(s"Total cost of 5 Glazed Donuts with anonymous discount function = $totalCostOf5Donuts")
    
 Output of above is 
 
     Step 3: How to call higher order function and pass an anonymous function as parameter
      Calculating total cost for 5 Glazed Donut
      Total cost of 5 Glazed Donuts with anonymous discount function = 10.5

Using simple function with def 

    println("\nStep 4: How to define and pass a function to a higher order function")
    def applyDiscount(totalCost: Double): Double = {
      val discount = 2 // assume you fetch discount from database
      totalCost - discount
    }
    println(s"Total cost of 5 Glazed Donuts with discount function = ${totalCostWithDiscountFunctionParameter("Glazed Donut")(5)(applyDiscount(_))}")

#### Example 12
Define function with **val** keyword

    val f: (Any) => String = {
        case i: Int => "Int"
        case d: Double => "Double"
        case _ => "Other"
    }
    
Output for calls

    f(1)     // Int
    f(1d)    // Double
    f(1f)    // Other
    f("a")   // Other
    
#### Example 13
Nested Functions

    println("\nStep 3: How to define a Nested Function")
    def checkDonutAvailabilityWithNestedFunction(donutName: String): Boolean = {
      // retrieve donut list that is currently in stock
      val listDonutsFromStock = List[String]("Vanilla Donut", "Strawberry Donut", "Plain Donut", "Glazed Donut")
    
      // validate the donutName parameter by some business logic
      val validate = (name: String) => {
        name.nonEmpty && name.length > 0
      }
    
      // first run validate and then check if we have a matching donut from our list
      val isDonutInStock = validate(donutName) && (listDonutsFromStock contains donutName)
    
      isDonutInStock
    }
    println("\nStep 4: How to call a Nested Function")
    println(s"Calling checkDonutAvailabilityWithNestedFunction with Vanilla Donut = ${checkDonutAvailabilityWithNestedFunction("Vanilla Donut")}")

Output of above code is:

    Step 4: How to call a Nested Function
    Calling checkDonutAvailabilityWithNestedFunction with Vanilla Donut = true

### References
1. [AllAboutScala](http://allaboutscala.com/)

2. [Alvin Alexander](https://alvinalexander.com/)
