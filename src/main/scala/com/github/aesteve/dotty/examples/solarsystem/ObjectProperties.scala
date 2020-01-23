package com.github.aesteve.dotty.examples.solarsystem

trait Weights
  def mass: PositiveDouble

trait HasVolume
  def volume: PositiveDouble

// If any object has a weight and a volume, we're able to calculate its density
// (Weights & HasVolume) is an intersection type of both traits defined above
def density(theObject: Weights & HasVolume): Double =
  theObject.mass / theObject.volume