package com.scalaexamples

/**
  * Examples of fold and reduce
  */
object FoldReduceExample {

  def main(args: Array[String]) {

    val numbers = for (i <- 0 to 20 if(i % 2 == 0)) yield i // even numbers from 0 to 20

    val sum = numbers.foldLeft(0)(_+_)

    val product = numbers.foldLeft(1)(_*_)

    println(sum)
    println(product)

  }

}
