package object random {

  val a = 1664525
  val b = 1013904223
  val n = 32

  private var current = 1

  def nextDouble(): Double = {
    current = (current * a + b) % math.pow(2, 32).toInt
    current
  }

  def nextInt(): Int = nextDouble().toInt

  def setSeed(n: Int) = current = n
}

package random {

  object randomTest extends App {

    random.setSeed(42)
    val seed1 = (0 to 5).map(_ => nextDouble())

    random.setSeed(42)
    val seed2 = (0 to 5).map(_ => nextDouble())
    println(seed1 == seed2)
  }
}
