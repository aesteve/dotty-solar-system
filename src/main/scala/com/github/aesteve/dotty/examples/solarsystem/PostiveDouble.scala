package com.github.aesteve.dotty.examples.solarsystem

/*
 * We're defining PositiveDouble type, that can only be constructed safely, but completely acts as a Double
 * note the `<:` bound, that allows us to add PositiveDouble with a Double, order PositiveDouble, etc.
 * there are tradeoffs though, like: (PositiveDouble.safe(2.0).get - 3.0d).getClass == double
 * in fact, any arithmetic operation will "lose" the PositiveDouble type
 */ 
opaque type PositiveDouble <: Double = Double
object PositiveDouble:
  def safe(double: Double): Option[PositiveDouble] =
    if (double > 0.0d) then Some(double)
    else None
