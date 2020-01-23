package com.github.aesteve.dotty.examples.solarsystem

val G: PositiveDouble = PositiveDouble.safe(6.67300E-11).get

/*
Scala 2 version for ref.
package object Constants {
  val G: PositiveDouble = PositiveDouble.safe(6.67300E-11).get
}
*/