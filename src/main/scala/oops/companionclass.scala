package oops

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
