package scalabasics

object forloopexample {
  def main(args: Array[String]): Unit = {
    println("Demo for loop using to")
    for(a <- 1 to 5)
      println(s"Number is $a")
    println("Demo for lo0p using until")
    for( b<- 1 until 5)
      println(s"Number is $b")
  }
}
