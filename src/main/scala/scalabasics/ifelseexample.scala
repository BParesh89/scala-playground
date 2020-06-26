package scalabasics

object ifelseexample {
  def main(args: Array[String]): Unit = {
    val a:Int = 100
    if (a <= 5){
      println("Number less than equal to 5")
    }else if(a >= 5 && a <= 10){
      println("Number between 5 and 10")
    }else
      println("Number greater than 10")
  }
}
