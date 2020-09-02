package chapter5
import scala.beans.BeanProperty

class Student(@BeanProperty var id: Long, @BeanProperty var name: String) {
  id = id max 0
}

object Main3{
  def main(args: Array[String]): Unit = {
    var s1 = new Student(1, "Marek")
    println(s1.id)
    var s2 = new Student(-1, "Jarek")
    println(s2.id)


    println(s1.id == s1.getId)
    println(s1.name == s1.getName)

    s1.name = "Beata"
    println(s1.name)
  }
}
