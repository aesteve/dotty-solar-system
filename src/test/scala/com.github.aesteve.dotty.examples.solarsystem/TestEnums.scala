package com.github.aesteve.dotty.examples.solarsystem

import org.junit._
import org.junit.Assert._

class TestPlanets:

  @Test
  def weShouldBeSomewhere(): Unit = 
    assertNotNull(ScalaPlanet.Earth)
    assertNotNull(DottyPlanet.Earth)

  @Test 
  def testPlanetNumber(): Unit =
    assertEquals(8, ScalaPlanet.values.size)
    assertEquals(8, DottyPlanet.values.size)
  
  @Test
  def jupiterIsTheHeaviestPlanet(): Unit = 
    assertEquals(ScalaPlanet.Jupiter, ScalaPlanet.values.maxBy(_.mass))
    assertEquals(DottyPlanet.Jupiter, DottyPlanet.values.maxBy(_.mass))