import java.io
import java.util.Scanner

import scala.collection.mutable
import scala.io.Source
import scala.reflect.io.File

object chapter4 extends App {

  //1
  val prices = Map("house" -> 1000, "mouse" -> 5, "key board" -> 6, "pen" -> 3)
  val higherPrices = for ((k, v) <- prices) yield k -> v * 1.1
  //  println(higherPrices)

  //2
  val words = Source.fromFile("src/text.txt").getLines().flatMap(_.strip().split("\\s+")).map(_.toLowerCase)

  var wordMap = collection.mutable.Map[String, Int]().withDefault(_ => 0)
  for (word <- words) {
    if (wordMap.contains(word)) wordMap(word) += 1
    else wordMap(word) = 1
  }
  //  println(wordMap)

  //version with mutable Map
  words.foldLeft {
    collection.mutable.Map[String, Int]().withDefault(_ => 0)
  } { (m, w) => m += (w -> (m(w) + 1)) }

  //version with immutable Map
  words.foldLeft {
    Map[String, Int]()
  } {
    (map, word) => map + (word -> (map.getOrElse(word, 0) + 1))


  }

  words.foldLeft {
    collection.mutable.SortedMap[String, Int]().withDefault(_ => 0)
  } {
    (map, word) => map += (word -> (map(word) + 1))
  }

  //6

  import java.util.Calendar._

  val weekdays = collection.mutable.LinkedHashMap[Int, String]()
  weekdays += MONDAY -> "Monday"
  weekdays += TUESDAY -> "Tuesday"
  weekdays += WEDNESDAY -> "Wednesday"
  weekdays += THURSDAY -> "Thursday"
  weekdays += FRIDAY -> "Friday"
  weekdays += SATURDAY -> "Saturday"
  weekdays += SUNDAY -> "Sunday"

  //  println(weekdays)

  // find the longest value in weekdays

  val LongestDay = weekdays.values.foldLeft(("", 0)) {
    (tup, day) => if (tup._2 < day.length) (day, day.length) else tup }

  println(LongestDay)

//8 minmax
  val arr = Array(1,2,3, -4, 2, 9, 0)

  def minmax(arr: Array[Int]): Tuple2[Int, Int] ={
    var min = arr(0)
    var max = arr(0)
    for ( elem <- arr){
      if(min > elem)
        min = elem
      if(max < elem)
        max = elem
      }
    (max, min)
  }
//  println(minmax(arr))
//8
  val minMax: Tuple2[Int, Int] = arr.foldLeft{(Int.MinValue, Int.MaxValue)} {
    (tuple, elem) => (tuple._1 max elem, tuple._2 min elem)
  }

  val minMax2: Tuple2[Int, Int] = arr.foldLeft{(Int.MinValue, Int.MaxValue)} {
    (tuple, elem) => (if(tuple._1 < elem) elem else tuple._1, if(tuple._2 > elem) elem else tuple._2 )
  }
//  println(minMax2)

  //7
  import scala.collection.JavaConverters._

  val props = System.getProperties().asScala

  val longestKey = props.keys.foldLeft(0) {(current, key) => current max key.length}
  println(longestKey)

  for( (k,v) <- props) {
    println(s" %-${longestKey+1}s| %s".format(k,v))
  }

  //9
  def lteqgt(arr: Array[Int], n: Int) = {
    arr.foldLeft((0, 0, 0)) {
      (tup, elem) =>
        (
          tup._1 + (if(elem < n) +1 else 0),
          tup._2 +( if(elem == n) + 1 else 0) ,
          tup._3 + (if(elem > n)  +1 else 0))
    }
  }
  val lteqgtTest = Array(1,1,1,2,2,3,3,3,3)

//  println(lteqgt(lteqgtTest, 2))

  for ((c1,c2) <- "Hello" zip "World") {
    println(c1 + " " + c2)
  }

}

