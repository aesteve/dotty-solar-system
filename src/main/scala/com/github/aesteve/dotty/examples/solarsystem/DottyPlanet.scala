package com.github.aesteve.dotty.examples.solarsystem

enum DottyPlanet(val mass: Double, val radius: Double):
  case Mercury extends DottyPlanet(3.303e+23, 2.4397e6)
  case Venus   extends DottyPlanet(4.869e+24, 6.0518e6)
  case Earth   extends DottyPlanet(5.976e+24, 6.37814e6)
  case Mars    extends DottyPlanet(6.421e+23, 3.3972e6)
  case Jupiter extends DottyPlanet(1.9e+27, 7.1492e7)
  case Saturn  extends DottyPlanet(5.688e+26, 6.0268e7)
  case Uranus  extends DottyPlanet(8.686e+25, 2.5559e7)
  case Neptune extends DottyPlanet(1.024e+26, 2.4746e7)

