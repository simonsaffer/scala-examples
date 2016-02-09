package com.scalaexamples

/**
  * Examples of partition and groupBy
  */

sealed trait OS
object Mac extends OS { override def toString = "Mac"}
object Windows extends OS { override def toString = "Windows"}
object Ubuntu extends OS { override def toString = "Ubuntu"}

case class RichPerson(val name: String, val os: OS)

object PartitionAndGroupByExample {

  def main(args: Array[String]) {

    val people = Seq(
      RichPerson("Davor", Mac),
      RichPerson("Erik", Windows),
      RichPerson("James", Ubuntu),
      RichPerson("Ludvig", Mac),
      RichPerson("Simon", Mac)
    )

    val peopleWithFiveLetterNames = people.partition(_.name.size == 5)

    val peopleByOS = people.groupBy(_.os)

    println(peopleWithFiveLetterNames)

    println(peopleByOS mkString("\n"))

  }

}
