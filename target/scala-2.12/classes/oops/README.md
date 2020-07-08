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



