package com.github.aesteve.dotty.examples.solarsystem

private def fromPos(double: Double): PositiveDouble = 
  PositiveDouble.safe(double).get

enum DottyPlanet(val mass: PositiveDouble, val radius: PositiveDouble)
  case Mercury extends DottyPlanet(fromPos(3.303e+23), fromPos(2.4397e6))
  case Venus   extends DottyPlanet(fromPos(4.869e+24), fromPos(6.0518e6))
  case Earth   extends DottyPlanet(fromPos(5.976e+24), fromPos(6.37814e6))
  case Mars    extends DottyPlanet(fromPos(6.421e+23), fromPos(3.3972e6))
  case Jupiter extends DottyPlanet(fromPos(1.9e+27), fromPos(7.1492e7))
  case Saturn  extends DottyPlanet(fromPos(5.688e+26), fromPos(6.0268e7))
  case Uranus  extends DottyPlanet(fromPos(8.686e+25), fromPos(2.5559e7))
  case Neptune extends DottyPlanet(fromPos(1.024e+26), fromPos(2.4746e7))
