package chapter9

import java.io.{File, PrintWriter}

import scala.io.Source

object replaceTab extends App{

  val path = "/home/marek/tutorials/Scala-for-Impatient/src/chapter9/tab1.txt"

  val lines = Source.fromFile(path).mkString("").replaceAll(" ", ",")
  println(lines)

  val newFile = "/home/marek/tutorials/Scala-for-Impatient/src/chapter9/tab2.txt"
  val writeFile = new PrintWriter(path)
  writeFile.println(lines)
  writeFile.close()

}
