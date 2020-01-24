## Dotty Solar System

### Goal

Demonstrating Dotty new features through a simple example: modeling a very basic version of our solar system.
The main idea is to follow Dotty's release cycle when new features are introduced and make example evolve.

### Current Progress (=> Walkthrough)

1. [Enumerations](https://dotty.epfl.ch/docs/reference/enums/enums.html)
  1.1. Start with [implementation 1](tree/enumerations-1) 
  1.2. Then [implementation 2](tree/enumerations-2)
2. Opaque types: 
3. No more package-objects
4. Intersection types
5. Union types

### Todo

Find an example:
* Conversions: this is the most easy one to show, since here we'll have true Conversions between units
* TypeClasses: we need to find a very crystal clear example where type clases would bring value. For it to really shine, the best would be to define some useful `trait` in the application (the typeclass), and "making types of the standard library implement this trait". Wondering if `Units` (as in measurement units, not the  `Unit` type) would work? An other idea would be to separate two modules: StellarSystem and Physics and emulate working with "another library". Or calculating the distances between a list of objects, maybe? Or definng a type class for a "celestial object" or even a system of objects (SolarSytem) wich is basically a Monoid (but find a good example of combination?). Or adding a new type of planets (gas giant / ice giant, etc.). Another example would be `CanExplore[A, B]` where `A` is a `CelestialObject` and `B` is something we can send in space (satellite, lunar module, robot, astronaut).
* Typeclass: this should lead us to a good example of typeclass derivation?? 
* Dependent function types: the return type of the function is dependent on the type of some parameter (example: `def xxx(a: A): a.SomeInnerType = ???` )
* Given parameters: See the example of M. Odersky when introducing dotty (`Configured[...]`, an example could be the metric system or the imperial system, that's something that's needed to express calculation results, but once and for all. `UnitSystem` is a candidate
* Implicit function types: the type of a function that has given parameters. Just show the type of some function that has `UnitSystem` as given parameter, define an HoF using it
* 

To review/re-read (not fully understood, so no use-case):
* Type lambdas
* Match types

