## OOPS

### Classes & Objects
A class is a user defined blueprint or prototype from which objects are created.  It represents the set of properties or methods that are common to all objects of one type.

Example 1
Defining class

    class Person (n: String, a: Int){ 
        val name = n
        val age = a
        def print = println(s"Name is $name and Age is $age")
        }
        
Create an object of class

`val p1 = new Person("Paresh", 31)`

To access method and member of class

    scala> p1.print
    Name is Paresh and Age is 31
    
    scala> p1.age
    res6: Int = 31
    
### Companion Objects
A Companion Object is defined using the object keyword and the name of the object should be identical to the class name.

In addition, the companion object should define an apply() method which will be responsible for instantiating an 
instance of the given class.

Example

    class Person (n: String, a: Int){
      val name = n
      val age = a
      def print = println(s"Name is $name and Age is $age")
    }
    object Person{
    
      def apply(name:String, age:Int):Person = {
        new Person(name, age)
      }
    
      def main(args: Array[String]): Unit = {
        // creating instance of object Person without using new keyword
        val p1 = Person("Amit", 21)
        val p2 = Person("Rajesh", 24)
        p1.print
        p2.print
      }
    
    }

Companion object is also useful in implementing factory pattern in scala.
Check out link --> [https://blogs.ashrithgn.com/factory-pattern-in-scala/](https://blogs.ashrithgn.com/factory-pattern-in-scala/)

### Singleton Object

Singleton Pattern is a a fairly common design pattern when you need exactly one instance of an object.

    object Exampleofsingleton
    {
    
      // Varaibles of singleton object
      var str1 = "Welcome ! GeeksforGeeks";
      var str2 = "This is Scala language tutorial";
    
      // Method of singleton object
      def display()
      {
        println(str1);
        println(str2);
      }
    }
    
    // Singleton object with named as Main
    object Main
    {
      def main(args: Array[String])
      {
    
        // Calling method of singleton object
        Exampleofsingleton.display();
      }
    } 


### Case Class
Case class are just like regular class which are immutable by default(good for spark!). Case classes are scala's way of allowing pattern
matching on object without requiring a large amount of boilerplate code. It is also used to define schema of DataFrame 
and Datasets in spark.

We don't need to use the new keyword to create instance of case class as an apply method is created in the companion 
object of the class.

    scala> case class Person(name: String, relation: String)
    defined class Person
    
    // "new" not needed before Person
    scala> val christina = Person("Christina", "niece")
    christina: Person = Person(Christina,niece)

An unapply method is generated, which lets you use case classes in more ways in match expressions.

Example :

    trait Person {
        def name: String
    }
    
    case class Student(name: String, year: Int) extends Person
    case class Teacher(name: String, specialty: String) extends Person
    
    def getPrintableString(p: Person): String = p match {
        case Student(name, year) =>
            s"$name is a student in Year $year."
        case Teacher(name, whatTheyTeach) =>
            s"$name teaches $whatTheyTeach."
    }
    
    val s = Student("Al", 1)
    val t = Teacher("Bob Donnan", "Mathematics")
    
We can test getPrintableString function like below:

    scala> getPrintableString(s)
    res0: String = Al is a student in Year 1.
    
    scala> getPrintableString(t)
    res1: String = Bob Donnan teaches Mathematics.

Of all, **the biggest advantage of case class is pattern matching.**

### Implicit Class

Use Implicit Class to add methods to an object without modifying the source code of the object - also commonly known as
extension methods.

Using Implicit Class to extend functionality of an object can be quite handy especially when you do have have access to
modify the source object.

    case class Donut(name: String, price: Double, productCode: Option[Long] = None)
    
    val vanillaDonut: Donut = Donut("Vanilla", 1.50)
    
    object DonutImplicits {
     implicit class AugmentedDonut(donut: Donut) {
      def uuid: String = s"${donut.name} - ${donut.productCode.getOrElse(12345)}"
     }
    }
    
    import DonutImplicits._
    println(s"Vanilla donut uuid = ${vanillaDonut.uuid}")
    
Output of above code is 

    Step 4: How to import and use the implicit class AugmentedDonut from Step 3
    Vanilla donut uuid = Vanilla - 12345
    
### Abstract Class

Abstraction is one of the key concepts of object-oriented programming (OOP) languages. Its main goal is to handle 
complexity by hiding unnecessary details from the user. That enables the user to implement more complex logic on top of
the provided abstraction without understanding or even thinking about all the hidden complexity.

An abstract class in scala is declared with **abstract** keyword. It can have both abstarct and non-abstract method.

In fact, you only need to use an abstract class when:

1. You want to create a base class that requires constructor arguments
2. Your Scala code will be called from Java code

Example :

    abstract class Pet(name: String){
        def speak(): Unit = println("Yo")   // concrete implementation
        def comeToMaster(): Unit            // abstract method
    }

Given that abstract Pet class, you can define a Dog class like this:

    class Dog(name: String) extends Pet(name) {
        override def speak() = println("Woof")
        def comeToMaster() = println("Here I come!")
    }

The REPL shows that this all works as advertised:

    scala> val d = new Dog("Rover")
    d: Dog = Dog@51f1fe1c
    
    scala> d.speak
    Woof
    
    scala> d.comeToMaster
    Here I come!
    
A case class can also extend an abstract class like below

    case class Dog(name:String) extends Pet(name){
        def comeToMaster() = println("Here I come!")
    }

To create and check case class object, we can use below code :

    val dog: Pet = Dog("Dog")
    Dog.comeToMaster()
    
### Traits

Traits are fundamental unit of code reuse in scala. A trait encapsulates method and field definitions, 
which can then be reused by mixing them into classes.

A class can extend any number of traits.

**Trait can not have an constructor argument.**

For example:

`trait abc(name:String); // will throw error traits or objects may not have parameters`

A trait itself can extend multiple trait

    trait a;
    trait b;
    trait c;
    trait d extends a with b with c;

A class extending a trait having both abstract and non-abstract methods

    trait a {
        def myfunc  //abstract method
        def myfunc1() = println("Hello from non-abstract method of trait")  //non-abstract method
    }
    
    class b extends a{
        override def myfunc() = println("Hello from class extended my trait a")
    }

We can execute methods of trait and class like below :

    scala> val sample:b = new b()
    sample: b = b@a8dedda
    
    scala> sample.myfunc()
    Hello from class extended my trait a
    
    scala> sample.myfunc1()
    Hello from non-abstract method of trait


### References
1. [AllAboutScala](http://allaboutscala.com/)

2. [Alvin Alexander](https://alvinalexander.com/)







