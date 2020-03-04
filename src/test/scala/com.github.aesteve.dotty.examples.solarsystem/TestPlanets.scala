package com.github.aesteve.dotty.examples.solarsystem

import org.junit._
import org.junit.Assert._

class TestPlanets:

  @Test
  def weShouldBeSomewhere(): Unit = 
    assertNotNull(Planet.Earth)

  @Test 
  def testPlanetNumber(): Unit =
    assertEquals(8, Planet.values.size)
  
  @Test
  def jupiterIsTheHeaviestPlanet(): Unit = 
    assertEquals(Planet.Jupiter, Planet.values.maxBy(_.mass))

  @Test
  def earthIsTheMostDensePlanet(): Unit =
    assertEquals(Planet.Earth, Planet.values.maxBy(density))