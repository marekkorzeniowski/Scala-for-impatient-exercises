package chapter5

class Counter {
  // private var - filed is private but getters and setters are private
  private var value = 0

  def increment() = if (value < Int.MaxValue) value += 1 else -1
  def current() = value
}
