package chapter5

class Person(name: String) {
  val firstName = name.split(" ")(0)
  val lastName =name.split(" ")(1)

  def display() = s"The name is: $firstName and surename is : $lastName"
}

object Main5 {
  def main(args: Array[String]): Unit = {
    val p = new Person("Marek Korzeniowski")

    println(p.display())
  }
}
