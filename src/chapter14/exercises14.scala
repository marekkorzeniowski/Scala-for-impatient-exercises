package chapter14

import java.io.File

object exercises14 extends App{

  //2
  def swapPair(x: Int, y: Int): Tuple2[Int, Int] = (x, y) match {
    case (x, y) => (y, x)
  }

//  println(swapPair(1,3))

  //3
  def swapArray(arr: Array[Int]) = arr match {
    case Array(x, y, res@_*) => Array(y, x) ++ res
  }
//  println(swapArray(Array(1,2)).mkString(", "))
//  println(swapArray(Array(1,2,3,4)).mkString(", "))

  //4
  abstract class Item{
    def thePrice(): Double = this match {
      case Article(_, price) => price
      case Bundle(_, disc, its@_*) => its.map(_.thePrice).sum - disc
      case Multiple(amount, its@_*) => its.map(_.thePrice).sum * amount
    }

  }
  case class Article(description: String, price: Double) extends Item
  case class Bundle(description: String, price: Double, items: Item*) extends Item

  case class Multiple(amount: Int, items: Item*) extends Item

  val bundle = Bundle("Father's day special", 20.0,
    Article("Scala for the Impatient", 39.95),
    Bundle("Anchor Distillery Sampler", 10.0,
      Article("Old Potrero Straight Rye Whiskey", 79.95),
      Article("Junípero Gin", 32.95)))

  val multiple = Bundle("another bundle", 10.0, Multiple(4, Article("Rubber band", 20)))
  val multibundle = Multiple( 2, bundle)

//  println(bundle.thePrice())
//  println(multibundle.thePrice())

  //5
  val treeList = List(List(3,8), 2, List(5), List(List(1,1)))

  def sumTree(lst: List[Any]): Int = lst match {
    case Nil => 0
    case (h:Int) :: tail => h + sumTree(tail)
    case (innerList @List(_*)) :: tail => sumTree(innerList) + sumTree(tail)
  }

//  println(sumTree(treeList))

  //6, 7 and 8
  sealed abstract class BinaryTree
  case class Leaf(value: Int) extends BinaryTree
  case class Node(operator: String ,children: BinaryTree*) extends BinaryTree

  def sumValues(tree: BinaryTree): Int = tree match {
    case Leaf(value) => value
    case Node("+" ,children@ _*) => children.map(sumValues).sum
    case Node("*",children@ _*) => children.map(sumValues).product
    case Node("-",children@ _*) => children.map(sumValues).reduce(_ - _)


  }
  val myTree = Node("+", Node("+", Leaf(1), Node("*",Leaf(2), Leaf(3))), Node("-",Node("*",Leaf(4), Leaf(5)),Node("+",Leaf(6),Leaf(7))))
  println(sumValues(myTree))

  //9
  def sum(lst: List[Option[Int]]): Int= lst.map(_.getOrElse(0)).sum

  //10
  def f(x: Double) = if (x != 1) Some(1/ (x-1)) else None
  def g(x: Double) = if (x >= 0) Some(Math.sqrt(x)) else None

  def compose(f: Double => Option[Double], g: Double => Option[Double]) = (x: Double) => {
    if(f(x).isDefined) g(f(x).get) else None
  }

  val h = compose(f, g)
  println(h(2))


}
