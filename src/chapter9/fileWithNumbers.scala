package chapter9

import java.io.PrintWriter

import scala.io.Source

object fileWithNumbers extends App{

  val path = "/home/marek/tutorials/Scala-for-Impatient/src/chapter9/numbers.txt"

  val numbers = Source.fromFile(path).mkString.split("\\n").map(_.toInt)
  println(numbers)
  var sum = 0
  var count = 0
  var min = Int.MaxValue
  var max = Int.MinValue

  for(i <- numbers){
    sum += i
    count +=1
    if(i < min) min = i
    if(i > max) max = i
  }
  val results = "/home/marek/tutorials/Scala-for-Impatient/src/chapter9/numbersRes.txt"

  val res = new PrintWriter(results)
  res.println(f"min = ${min}, \nmax = ${max}, \nsum = ${sum}\n avg = ${sum/count}")
  res.close()

  println(sum)
  println(count)
  println(min)
  println(max)

}
