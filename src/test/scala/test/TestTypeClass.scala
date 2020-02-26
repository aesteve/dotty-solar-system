package test

import org.junit._
import org.junit.Assert._
import scala.annotation.infix

trait SemiGroup[T] {
  @infix def (x: T) combine (y: T): T
}

trait Monoid[T] extends SemiGroup[T] {
  def unit: T
}

object Monoid {
  def apply[T](using m: Monoid[T]) = m
}

given Monoid[String] {
  def (x: String) combine (y: String): String = x.concat(y)
  def unit: String = ""
}

given Monoid[Int] {
  def (x: Int) combine (y: Int): Int = x + y
  def unit: Int = 0
}

def [T: Monoid](xs: List[T]).combineAll: T =
  xs.foldLeft(Monoid[T].unit)(_ combine _)  

trait Functor[F[_]] {
  def [A, B](original: F[A]).map(mapper: A => B): F[B]
}

given Functor[List] {
  def [A, B](original: List[A]).map(mapper: A => B): List[B] =
    original.map(mapper) // List already has a `map` method
}
trait Monad[F[_]] extends Functor[F] { // "A `Monad` for type `F[_]` is a `Functor[F]`" => thus has the `map` ability
  def pure[A](x: A): F[A] // `pure` can construct F[A] from a single value A
  def [A, B](x: F[A]).flatMap(f: A => F[B]): F[B] // the flattening ability is named `flatMap`, using extension methods as previous examples
  def [A, B](x: F[A]).map(f: A => B) = x.flatMap(f `andThen` pure) // the `map(f)` ability is simply a combination of applying `f` then turning the result into an `F[A]` then applying `flatMap` to it
}
given readerMonad[Ctx] as Monad[[X] =>> Ctx => X] {
  def [A, B](r: Ctx => A).flatMap(f: A => Ctx => B): Ctx => B =
    ctx => f(r(ctx))(ctx)
  def pure[A](x: A): Ctx => A =
    ctx => x
}

trait Config

type ConfigDependent = [Result] =>> Config => Result

def compute(i: Int)(config: Config): String = ???
def show(str: String)(config: Config): Unit = ???

val computeWithoutConfig: ConfigDependent[String] = compute(42)
given listMonad: Monad[List] {
  def pure[A](x: A): List[A] =
    List(x)
  def [A, B](xs: List[A]).flatMap(f: A => List[B]): List[B] =
    xs.flatMap(f) // let's rely on the existing `flatMap` method of `List`
}
def computeAndShow(i: Int): Config => Unit = compute(i).flatMap(show)

given ConfigReaderMonad as Monad[[Result] =>> Config => Result] {
  def [A, B](r: Config => A).flatMap(f: A => Config => B): Config => B =
    config => f(r(config))(config)
  def pure[A](x: A): Config => A =
    config => x
}

class TestTypeClass:
  @Test
  def testTypeClassStr(): Unit = 
    assert("ab" == List("a", "b").combineAll)
    assert(3 == List(1, 2).combineAll)

  @Test
  def testFunctor(): Unit = 
    assertTransformation(List("a1", "b1"), List("a", "b"), elt => s"${elt}1")

  def assertTransformation[F[_]: Functor, A, B](expected: F[B], original: F[A], mapping: A => B): Unit =
    assert(expected == original.map(mapping))

  @Test
  def combineConfigFunctions(): Unit = 
    // compute.flatMap(show)