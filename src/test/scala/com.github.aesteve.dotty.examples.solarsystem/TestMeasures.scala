package com.github.aesteve.dotty.examples.solarsystem

import com.github.aesteve.dotty.examples.physics._
import org.junit._
import org.junit.Assert._

class TestMeasures

  @Test
  def checkPlanetMasses(): Unit = 
    Planet.values.foreach { planet =>
      assertTrue(planet.mass.instanceOf[UnitOfMeasure[Mass])
    }
