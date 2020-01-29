## Dotty Solar System

### Goal

Demonstrating Dotty new features through a simple example: modeling a very basic version of our solar system.
The main idea is to follow Dotty's release cycle when new features are introduced and make example evolve.

### Current Progress (=> Walkthrough)

1. [Enumerations](https://dotty.epfl.ch/docs/reference/enums/enums.html)
  * Start with [implementation 1](tree/enumerations-1) 
  * Then [implementation 2](tree/enumerations-2)
2. [Opaque types](https://dotty.epfl.ch/docs/reference/other-new-features/opaques.html): [implementation](tree/opaque-types)
3. [No more package-objects](https://dotty.epfl.ch/docs/reference/dropped-features/package-objects.html): [implementation](tree/no-more-package-objects)
4. [Intersection types](https://dotty.epfl.ch/docs/reference/new-types/intersection-types.html) [implementation](tree/intersection-types)
5. [Union types](https://dotty.epfl.ch/docs/reference/new-types/union-types.html) [implementation](tree/union-types)
6. [ADT]
7. [Trait Parameters](https://dotty.epfl.ch/docs/reference/other-new-features/trait-parameters.html)(tree.trait-parameters-mission)


### Todo

6. ADT: As an example, we could introduce a "generalized, parametric enumeration" as follows:
```scala
enum SolarSystemObject[P <: Planet] 
  case DwarfPlanet(mass: PositiveDouble)
  case Satellite(mass: PosiveDouble, planet: P)
  case Comet(mass: PositiveDouble, nucleusRadius: PositiveDouble) 
```
Or even better: an `ExplorationResult[T]`
```scala
enum ExplorationResult[T] 
  case Picture(raw: Array[Byte]) extends ExplorationResult[Array[Byte]]
  case Litterature(text: String) extends ExplorationResult[String]
  case ScientificResult(worked: Boolean) extends ExplorationResult[Boolean]
  case Nothing
```


And say it's an ADT "enum on steroids basically"

----

Here we're missing something to introduce measurement units, let's dig in the dotty docs some new features to replace `PositiveDouble` with something better (that will be used in 7. Extensions for instance: 1.0.kg)
Tried with trait parameters, but that goes a bit too far, better getting off "units of measurement", this could be a talk on its own. Let's stick to spatial exploration with doubles and no units. Handling units like in Libra or squants is a fantastic topic for an other talk.

----

7. Trait with parameters: Here the goal would be to replace `PositiveDouble` with something carrying a bit more information. We can introduce a `Measure` and a `MeasurementUnit`, `MeasurementUnit` will have a parameter named "symbol" (like `"kg"`), or simply a `Mission` that must have a code, no matter what the mission is.
7. Extensions
8. Given Parameters
9. Implicit function types
10. Type Classes
11. Conversions
12. TypeClass derivation / Multiversal equality

Find an example:
* Conversions: this is the most easy one to show, since here we'll have true Conversions between units
* TypeClasses: we need to find a very crystal clear example where type clases would bring value. For it to really shine, the best would be to define some useful `trait` in the application (the typeclass), and "making types of the standard library implement this trait". Wondering if `Units` (as in measurement units, not the  `Unit` type) would work? An other idea would be to separate two modules: StellarSystem and Physics and emulate working with "another library". Or calculating the distances between a list of objects, maybe? Or definng a type class for a "celestial object" or even a system of objects (SolarSytem) wich is basically a Monoid (but find a good example of combination?). Or adding a new type of planets (gas giant / ice giant, etc.). Another example would be `CanExplore[A, B]` where `A` is a `CelestialObject` and `B` is something we can send in space (satellite, lunar module, robot, astronaut).
* Typeclass derivation: this should lead us to a good example of typeclass derivation?? (if not, equality between `1.kg` and `1000.g` would be totally ok)
* Dependent function types: the return type of the function is dependent on the type of some parameter (example: `def xxx(a: A): a.SomeInnerType = ???` ). The most difficult part is to find a dependent type. Maybe `MeasurementUnit` would do the trick.
* Given parameters: See the example of M. Odersky when introducing dotty (`Configured[...]`, an example could be the metric system or the imperial system, that's something that's needed to express calculation results, but once and for all. `UnitSystem` is a candidate
* Implicit function types: the type of a function that has given parameters. Just show the type of some function that has `UnitSystem` as given parameter, define an HoF using it
* 

To review/re-read (not fully understood, so no use-case):
* Type lambdas
* Match types

