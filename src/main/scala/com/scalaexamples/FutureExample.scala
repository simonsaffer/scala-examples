package com.scalaexamples

import scala.annotation.tailrec
import scala.collection.parallel.immutable.ParSet
import scala.collection.parallel.mutable
import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

// the following is equivalent to `implicit val ec = ExecutionContext.global`
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Example of using Scala Futures
  */
object FutureExample {

  def f(maxNumber: Int): Future[ParSet[Int]] = Future {

    // Calculate all primes < maxNumber
    def sieveOfEratosthenes(limit: Int): mutable.ParSet[Int] = {
      val (primes: mutable.ParSet[Int], sqrtLimit) = (mutable.ParSet.empty ++ (2 to limit), math.sqrt(limit).toInt)
      @tailrec
      def prim(candidate: Int): Unit = {
        if (candidate <= sqrtLimit) {
          if (primes contains candidate) primes --= candidate * candidate to limit by candidate
          prim(candidate + 1)
        }
      }
      prim(2)
      primes
    }

    sieveOfEratosthenes(maxNumber).toSet
  }

  def main(args: Array[String]) {

    val myPrimesFuture = f(10000)

    val f2 = myPrimesFuture.flatMap(s => Future{s.map(_+"p")})

    f2.onComplete {
      case Success(x) => println(x take 100)
      case _ => println("Fail")
    }

    myPrimesFuture.onComplete {
      case Success(x) => println(x take 100)
      case Failure(x) => println(x)
    }

    val t: Long = 40
    println("A ..."); Thread.sleep(t)
    println("B ..."); Thread.sleep(t)
    println("C ..."); Thread.sleep(t)
    println("D ..."); Thread.sleep(t)
    println("E ..."); Thread.sleep(t)
    println("F ..."); Thread.sleep(t)

  }

}
