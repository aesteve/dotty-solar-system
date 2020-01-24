package com.github.aesteve.dotty.examples.solarsystem

// For now, we'll probably add more in the future
type CelestialObject = Comet | Planet

// This compiles perfectly fine thanks to type inference, both comets and planets implement the traits Weights and HasVolume
def areYouHeavierOn(celestial: CelestialObject): Boolean =
  density(celestial) > density(Planet.Earth)

// We can also pattern match on the type
def hasTail(celestial: CelestialObject): Boolean = 
  celestial match 
    case Comet => true
    case _ => false