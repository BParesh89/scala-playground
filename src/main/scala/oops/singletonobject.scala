package oops

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
