package com.github.aesteve.dotty.examples.solarsystem

import com.github.aesteve.dotty.examples.physics._

trait Weights
  def mass: Quantity[Mass]

trait HasVolume
  def volume: Quantity[Volume]

// If any object has a weight and a volume, we're able to calculate its density
// (Weights & HasVolume) is an intersection type of both traits defined above
def density(theObject: Weights & HasVolume): Double =
  theObject.mass.value / theObject.volume.value // let's forget about it's unit for now, we'll go on that later