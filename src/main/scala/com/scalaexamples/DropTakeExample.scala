package com.scalaexamples

/**
  * Examples of drop and take operations
  */
object DropTakeExample {

  def main(args: Array[String]) {

    val numbers = Seq(4, 7, 9, 0, -3, 6)

    println(numbers take 2)
    println(numbers takeWhile(_ >= 0))

    println(numbers drop 3)
    println(numbers dropWhile(_ >= 0))

  }

}
