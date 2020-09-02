package chapter9

import scala.io.Source

object reverseLines extends App{

  def revLin(path: String) = {
    val lines = Source.fromFile(path).getLines().toArray
    for(i <- lines.indices.reverse) yield lines(i)
  }

  val path = "/home/marek/tutorials/Scala-for-Impatient/src/chapter9/text.txt"
  println(revLin(path).mkString("\n"))

  val lines = Source.fromFile(path).getLines().toArray.reverse.mkString(", ")
  println(lines)
}
