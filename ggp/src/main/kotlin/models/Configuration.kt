package models

data class Configuration(
  val crossoverRate : Double = 50.0,
  val mutationRate: Double = 25.0,
  val population: Int = 100,
  val generations: Int = 100,
  val selectionSize: Int = 5
)