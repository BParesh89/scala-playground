package scalabasics

object whileexamples {
  def main(args: Array[String]): Unit = {
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
  }
}
