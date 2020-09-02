package chapter9

import scala.io.Source

object regEx extends App{

  val path = "/home/marek/tutorials/Scala-for-Impatient/src/chapter9/text.txt"

  val words = Source.fromFile(path).mkString.split("\\s+").mkString(" ")

  val reg = """^".*"$""".r

 for (elem <-reg.findAllIn(words) ) println(elem)





}
