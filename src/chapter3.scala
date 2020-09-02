import java.awt.datatransfer.SystemFlavorMap

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

object chapter3 extends App {

  //1 return array of n random integers between 0 and n
  def randomArray(n: Int): Array[Int] = {
    var a = new Array[Int](n)
    for(i <- a.indices)
      a(i) = Random.nextInt(n)
    a
  }

//  println(randomArray(10).mkString(", "))

  //2 swap adjecent elements in array
  val arr = Array(1, 2, 3, 4, 5)

  def swapAdj(a: Array[Int]) = {
    for(i <- 1 until a.length by 2) {
      var temp = a(i)
      a(i) = a(i-1)
      a(i-1) = temp
    }
    a
  }

  def swapAdj2(a: Array[Int]) = a.grouped(2).flatMap(_.reverse).toArray

  def swapAdj3(a: Array[Int]) = {
    for {
      i <- 1 to a.length by 2
      j <- (i to i-1 by -1) if j < a.length
    }
      yield j
  }

//  println(swapAdj(arr).mkString(", "))
//println(swapAdj2(arr).mkString(", "))
//println(swapAdj3(arr).mkString(", "))

//* replace negative by 0
  val lista = Array(0, -1, 2, -3, 4, -5)

  def replace(a:Array[Int]) = {
    val negative = for(i <- a.indices if a(i) < 0) yield i
    for(j <- negative.indices) a(negative(j)) = 0
    a
  }
//  println(replace(lista).mkString(", "))

  //4 positive followed by negative
  def posNegConcat(a: Array[Int]) = {
    val positive = for( p <- a if p > 0) yield p
    val negative = for(n <- a if n<=0) yield n
    positive ++ negative
  }
//  println(posNegConcat(lista).mkString(", "))

  //8 remove all but first negative number
  def dropNegButFirst(a: Array[Int]) = {
    var negativeIdx = (for(i <- a.indices if a(i) < 0) yield i).tail
    //negativeIdx = negativeIdx.drop(1)
    println(negativeIdx)
    var ab = a.toBuffer
    for(j <- negativeIdx.reverse) ab.remove(j)
    ab.toArray
  }
//  println(dropNegButFirst(lista).mkString(", "))

  val timeZones = java.util.TimeZone.getAvailableIDs()
  println(timeZones.length)

  val americaZones = for (id <- timeZones if id.startsWith("America/")) yield id.drop(8)
  println(americaZones.sorted.mkString(", "))

//  val flavors = SystemFlavorMap.getDefaultFlavorMap.asInstanceOf[SystemFlavorMap]

}
