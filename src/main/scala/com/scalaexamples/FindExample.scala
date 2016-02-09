package com.scalaexamples

import scala.util.{Failure, Success, Try}

/**
  * Examples of find
  */
object FindExample {

  def printFirstParsableNumber(input: Seq[String]): Unit = {

    val firstParsableNumber: Option[String] = input.find(s => {
      Try(s.toInt) match {
        case Success(i) => {
          true
        }
        case _ => false
      }
    })

    println(firstParsableNumber.getOrElse("No parsable number found"))
  }

  def main(args: Array[String]) {

    val allGoodNumbers = Seq("1", "2", "3", "4")
    val someGoodNumbers = Seq("one", "two", "3", "4")
    val noGoodNumbers = Seq("one", "two", "three", "four")

    printFirstParsableNumber(allGoodNumbers)
    printFirstParsableNumber(someGoodNumbers)
    printFirstParsableNumber(noGoodNumbers)

  }

}
