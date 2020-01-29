package com.github.aesteve.dotty.examples.solarsystem

import com.github.aesteve.dotty.examples.solarsystem.AppoloMission

import org.junit._
import org.junit.Assert._

class TestMissions

  @Test
  def  lastTimeWeWentOnTheMoon(): Unit =
    val lastMission = AppoloMission(17)
    assertEquals("Appolo 17", lastMission.code)
