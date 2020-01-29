package com.github.aesteve.dotty.examples.solarsystem

import com.github.aesteve.dotty.examples.physics._

case class Comet(override val mass: Quantity[Mass], val volumicMass: Quantity[VolumicMass]) extends Weights with HasVolume
  override def volume: Quantity[Volume] = 
    (mass.unit, volumicMass.unit) match
      case (MassUnit.Kg, VolumicMassUnit.KgPerKm3) => Quantity(mass.value / volumicMass.value, VolumeUnit.Km3)
      case _ => throw RuntimeException("Noooooooooooo 🙈🙈🙈") 


val tchourioumovGuerassimenko = Comet(Quantity(1e11, MassUnit.Kg), Quantity(450, VolumicMassUnit.KgPerKm3))