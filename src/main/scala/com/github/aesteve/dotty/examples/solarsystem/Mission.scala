package com.github.aesteve.dotty.examples.solarsystem

trait Mission(val code: String) // <-- this is a trait with parameter

trait ProgramMission(val program: String, val number: Int) extends Mission // <-- this trait also has parameters
  override val code = s"$program $number" // overriding val from the base

case class AppoloMission(override val number: Int) extends ProgramMission("Appolo", number)
