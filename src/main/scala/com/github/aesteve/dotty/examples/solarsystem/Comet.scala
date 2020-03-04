package com.github.aesteve.dotty.examples.solarsystem

case class Comet(override val mass: PositiveDouble, val volumicMass: PositiveDouble) extends Weights with HasVolume:
  override def volume: PositiveDouble = PositiveDouble.safe(mass / volumicMass).get


val tchourioumovGuerassimenko = Comet(PositiveDouble.safe(1e11).get, PositiveDouble.safe(450).get)