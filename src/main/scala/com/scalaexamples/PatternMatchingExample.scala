package com.scalaexamples

/**
  * Examples of pattern matching in Scala
  */

class Person
class NormalPerson extends Person
class CrazyPerson extends Person

abstract case class Plane(val seatsLeft: Int, val passedStructuralInspection: Boolean, val legSpace: Int, val pilot: Person)
class Boeing(val x: String, seatsLeft: Int, passedStructuralInspection: Boolean, legSpace: Int, pilot: Person)
  extends Plane(seatsLeft, passedStructuralInspection, legSpace, pilot)
class Airbus(val y: Int, seatsLeft: Int, passedStructuralInspection: Boolean, legSpace: Int, pilot: Person)
  extends Plane(seatsLeft, passedStructuralInspection, legSpace, pilot)
class SaabGripen(val z: Boolean, seatsLeft: Int, passedStructuralInspection: Boolean, legSpace: Int, pilot: Person)
  extends Plane(seatsLeft, passedStructuralInspection, legSpace, pilot)


object PatternMatchingExample {

  def isSuitableFlight(plane: Plane): Boolean = plane match {
    case Plane(_, passed, _, _) if(passed) => false // Don't fly if the plane is broken
    case Plane(_, _, _, pilot: CrazyPerson) => false // Don't fly if the pilot is crazy
    case Plane(seatsLeft, _, _, _) if(seatsLeft < 1) => false // Are there any seats left?
    case Plane(_, _, legSpace, _) if(legSpace < 50) => false // Enough leg room?
    case p: Boeing => false // Not a fan of Boeings
    case s: SaabGripen => false // Afraid of Jas Gripen
    case _ => true
  }

  def main(args: Array[String]) {

    val sanePilot = new NormalPerson
    val crazyPilot = new CrazyPerson

    val brokenPlane = new Airbus(123, 45, false, 67, sanePilot)
    val planeWithCrazyPilot = new Airbus(123, 45, true, 76, crazyPilot)
    val fullPlane = new Airbus(123, 0, true, 45, sanePilot)
    val tooLittleLegSpace = new Airbus(123, 45, true, 45, sanePilot)
    val boeing = new Boeing("ABC", 123, true, 456, sanePilot)
    val jasGripen = new SaabGripen(true, 123, true, 456, sanePilot)

    val okPlane1 = new Airbus(123, 45, true, 67, sanePilot)
    val okPlane2 = new Airbus(89, 10, true, 1112, sanePilot)

    val allPlanes = Seq(brokenPlane, planeWithCrazyPilot, fullPlane, tooLittleLegSpace, boeing, jasGripen, okPlane1, okPlane2)

    println(allPlanes map (isSuitableFlight) mkString(", "))
  }

}
