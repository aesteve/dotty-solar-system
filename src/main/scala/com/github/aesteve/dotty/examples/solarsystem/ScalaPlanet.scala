package com.github.aesteve.dotty.examples.solarsystem

object ScalaPlanet extends Enumeration {
  protected case class PlanetVal(mass: Double, radius: Double) extends super.Val
  import scala.language.implicitConversions
  implicit def valueToPlanetVal(x: Value): PlanetVal = x.asInstanceOf[PlanetVal]

  val Mercury = PlanetVal(3.303e+23, 2.4397e6)
  val Venus   = PlanetVal(4.869e+24, 6.0518e6)
  val Earth   = PlanetVal(5.976e+24, 6.37814e6)
  val Mars    = PlanetVal(6.421e+23, 3.3972e6)
  val Jupiter = PlanetVal(1.9e+27, 7.1492e7)
  val Saturn  = PlanetVal(5.688e+26, 6.0268e7)
  val Uranus  = PlanetVal(8.686e+25, 2.5559e7)
  val Neptune = PlanetVal(1.024e+26, 2.4746e7)
}
