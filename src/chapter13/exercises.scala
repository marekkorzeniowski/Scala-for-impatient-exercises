package chapter13

object exercises extends App{

  //1
  val str = "Mississippi"
  val zippedStr = str.zipWithIndex.groupBy(_._1).mapValues(v => v.map(_._2)).force.toMap.mkString("\n")
//   println(zippedStr)

  def indexes(str: String) = {
    import scala.collection.mutable
    var map = mutable.SortedMap[Char, mutable.Set[Int]]()

    for (c <- str.zipWithIndex)
      map.getOrElseUpdate(c._1, mutable.SortedSet[Int]()) += c._2
    map
  }
//  println(indexes(str).mkString("\n"))

  //2
  def indexes2(s: String) = s.zipWithIndex.foldLeft(Map.empty[Char, Set[Int]]) {
    (m,v) => m + (v._1 -> (m.getOrElse(v._1, Set[Int](v._2)) + v._2))
  }

//  println(indexes2(str).mkString("\n"))

  //3
  def remEvrScd(l: List[Int]): IndexedSeq[Int] = {
//    var lb = l.toBuffer
    val newList = for(i <- l.indices.reverse if i%2 ==0) yield l(i)
    newList.reverse
  }
  val lst = List(1,2,3,4,5,6,7)
//  println(remEvrScd(lst))

  //4
  val names = Array("Tom", "Fred", "Harry")
  val mapName = names.map(x => x -> x.length).toMap

  def returnValue(arr: Array[String], map: Map[String, Int]) = arr.flatMap(key => map.get(key))

  println(returnValue(names, mapName).mkString(", "))

//5
  val arr = Array(1,2,3,4,5)
  def myMkString( array: Array[String], sep: String):String = array.reduceLeft(_ + sep + _)

//  println(myMkString(names, " | "))

  //6
//  println(arr.foldRight(List[Int]())((a,b) => b :+ a))
//  println(arr.foldLeft(List[Int]())((a,b) => b :: a))

  //7
  def tupled(f: (Int, Int) => Int) = (tuple: Tuple2[Int, Int]) => f(tuple._1, tuple._2)

  val price = Array(1,2,3,4)
  val quantities = price.map(_*10)

//  println(price.zip(quantities).map(tupled( _ * _)).mkString(", "))

  //10
  val zones = java.util.TimeZone.getAvailableIDs().map(_.split('/'))
    .groupBy(_.head).mapValues(_.length).force.sortWith(_._2 > _._2).mkString("\n")

  //.map(_.mkString(", ")).mkString("\n")

//    groupBy(_(1)).mkString("\n")
  println(zones)




}
