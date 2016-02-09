package com.scalaexamples

/**
  * Examples of zip operation
  */
object ZipExample {

  def main(args: Array[String]) {

    val indices = 0 to 4
    val namesSorted = Seq("Davor", "Erik", "James", "Ludvig", "Simon")

    val namesUnsorted = Seq("Simon", "James", "Davor", "Erik", "Ludvig")

    println(namesSorted zip indices mkString(" "))
    println(namesUnsorted.sorted.zipWithIndex mkString(" "))

    println(namesSorted zip (indices take 4) mkString(" "))

  }

}
