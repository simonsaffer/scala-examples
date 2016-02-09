package com.scalaexamples

/**
  * Examples of map and flatMap
  */
object MapFlatMapExample {

  def main(args: Array[String]) {

    val elements = Seq(1, 2, 3, 4)

    val transformedList = elements.map(i => i + 1)

    println(transformedList)

    val map: Seq[List[Int]] = elements.map(i => List(i - 1, i, i + 1))
    println(map)

    val map1: Seq[Int] = elements.flatMap(i => List(i - 1, i, i + 1))
    println(map1)

  }

}
