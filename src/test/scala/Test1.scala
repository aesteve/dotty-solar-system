import org.junit.Test
import org.junit.Assert._
import com.github.aesteve.dotty.examples.solarsystem.Main

class Test1

  @Test def t1(): Unit =
    assertEquals("I was compiled by dotty :)", Main.msg)
