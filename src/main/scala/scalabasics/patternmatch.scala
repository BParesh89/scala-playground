package scalabasics

object patternmatch {
  def main(args: Array[String]): Unit = {
    val donutType = "Glazed Donut"
    println("Pattern matching simple example")
    val tastelevel = donutType match {
      case "Glazed Donut" => "It's a match!"
      case _ => "No match!"
    }
    println(s"The result of above match is $tastelevel")
    println("\nStep 5; Pattern matching and using if expressions in the case clause")

    val tasteLevel4 = donutType match {
      case donut if (donut.contains("Glazed") ||
        donut.contains("Strawberry")) => "Very tasty"
      case "Plain Donut"  => "Tasty"
      case _  => "Tasty"
    }
    println(s"Taste level of $donutType = $tasteLevel4")
  }

}
