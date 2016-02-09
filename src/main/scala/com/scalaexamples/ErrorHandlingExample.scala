package com.scalaexamples

import scala.util.{Success, Try}

/**
  * Examples of different kinds of error handling in Scala
  */
object ErrorHandlingExample {

  def getStringOrOption(string: String): Option[String] = string match {
    case null | "" => None
    case str if(str.matches("\\s+")) => None
    case _ => Some(string)
  }

  def getEitherStringOrErrorCode(string: String): Either[Int, String] = string match {
    case null => Left(1)
    case "" => Left(2)
    case str if(str.matches("\\s+")) => Left(3)
    case _ => Right(string)
  }

  def main(args: Array[String]) {

    println("### Option ###")
    println(getStringOrOption("Hello World!").getOrElse("Default String"))
    println(getStringOrOption(null).getOrElse("Default String"))
    println(getStringOrOption("").getOrElse("Default String"))
    println(getStringOrOption("     ").getOrElse("Default String"))

    val nameAndColour1 = for {
      name <- getStringOrOption("Simon")
      colour <- getStringOrOption("")
    } yield (name, colour)

    val nameAndColour2 = for {
      name <- getStringOrOption("Simon")
      colour <- getStringOrOption("Blue")
    } yield (name, colour)

    println(nameAndColour1)
    println(nameAndColour2)


    println("### Either ###")
    println(getEitherStringOrErrorCode(""))
    println(getEitherStringOrErrorCode("Simon"))

    println(getEitherStringOrErrorCode("Simon").right.map("Hello " + _))
    println(getEitherStringOrErrorCode("").right.map("Hello " + _))


    getEitherStringOrErrorCode("").right.map("Hello " + _) match {
      case Right(str) => println(str)
      case Left(_) => println("LEFT!")
    }

    println("### Try ###")

    val userInput = List("one", "2", "three", "4", "five", "6")
    val parsedInts: List[Try[Int]] = userInput.map(str => Try(str.toInt))
    println(parsedInts)
    println(parsedInts.flatMap(_.toOption))
    val incrementedNumbers = for (i <- parsedInts.flatMap(_.toOption)) yield (i+1)

    println(incrementedNumbers.mkString(", "))




  }




}
