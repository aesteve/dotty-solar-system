package com.github.aesteve.dotty.examples.physics

trait Dimension
trait Length extends Dimension
trait Mass extends Dimension
trait Volume extends Dimension
trait VolumicMass extends Dimension ///mmmh, not that great, but let's 🙈

trait UnitOfMeasure[D <: Dimension](symbol: String) // <-- trait has a parameter

case class Quantity[D <: Dimension](val value: Double, val unit: UnitOfMeasure[D])
  override def toString(): String = "$value${unit.symbol}"

enum MassUnit(val symbol: String) extends UnitOfMeasure[Mass](symbol)
  case Kg extends MassUnit("kg")

enum DistanceUnit(val symbol: String) extends UnitOfMeasure[Length](symbol)
  case M  extends DistanceUnit("m")
  case Km extends DistanceUnit("km")

enum VolumeUnit(val length: DistanceUnit) extends UnitOfMeasure[Volume]("${symbol}^3")
  case M3 extends VolumeUnit(DistanceUnit.M)  
  case Km3 extends VolumeUnit(DistanceUnit.Km)

enum VolumicMassUnit(massUnit: MassUnit, volumeUnit: VolumeUnit) extends UnitOfMeasure[VolumicMass]("${massUnit.symbol}/${volumeUnit.symbol}")
  case KgPerKm3 extends VolumicMassUnit(MassUnit.Kg, VolumeUnit.Km3)
