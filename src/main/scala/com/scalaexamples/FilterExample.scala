package com.scalaexamples

/**
  * Examples of filter
  */
object FilterExample {

  def main(args: Array[String]) {

    val elements = Seq(1, 2, 3, 4)

    val preFilteredList = elements.filter(_ % 2 == 0).map(_ + 1)

    val postFilteredList = elements.map(i => i + 1).filter(_ % 2 == 0)

    println(preFilteredList)
    println(postFilteredList)

  }

}
