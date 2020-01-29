package com.github.aesteve.dotty.examples.solarsystem

import com.github.aesteve.dotty.examples.physics._



def fromLength(length: UnitOfMeasure[Length]): VolumeUnit =
  length match
    case DistanceUnit.M => VolumeUnit.M3
    case DistanceUnit.Km => VolumeUnit.Km3


enum Planet(override val mass: Quantity[Mass], val radius: Quantity[Length]) extends Weights with HasVolume
  case Mercury extends Planet(Quantity(3.303e+23, MassUnit.Kg), Quantity(2.4397e6, DistanceUnit.Km))
  case Venus   extends Planet(Quantity(4.869e+24, MassUnit.Kg), Quantity(6.0518e6, DistanceUnit.Km))
  case Earth   extends Planet(Quantity(5.976e+24, MassUnit.Kg), Quantity(6.37814e6, DistanceUnit.Km))
  case Mars    extends Planet(Quantity(6.421e+23, MassUnit.Kg), Quantity(3.3972e6, DistanceUnit.Km))
  case Jupiter extends Planet(Quantity(1.9e+27, MassUnit.Kg), Quantity(7.1492e7, DistanceUnit.Km))
  case Saturn  extends Planet(Quantity(5.688e+26, MassUnit.Kg), Quantity(6.0268e7, DistanceUnit.Km))
  case Uranus  extends Planet(Quantity(8.686e+25, MassUnit.Kg), Quantity(2.5559e7, DistanceUnit.Km))
  case Neptune extends Planet(Quantity(1.024e+26, MassUnit.Kg), Quantity(2.4746e7, DistanceUnit.Km))

  override def volume: Quantity[Volume] = 
    Quantity(
      Math.PI * radius.value * radius.value * radius.value,
      fromLength(radius.unit)
    )
