package chapter8

import scala.collection.mutable.ListBuffer

abstract class Item {
  def price: Double
  def description: String

  override def toString: String = f"${price}%.2f $$ ${description}"
}

class SimpleItem(override val price: Double, override val description: String) extends Item

class Bundle {
  private var container: ListBuffer[SimpleItem] = new ListBuffer[SimpleItem]()
  def addItem(newItem: SimpleItem) = container += newItem

  def printDescription: String = container.map(_.description).mkString("\n")
  def printPrice: Double = container.map(_.price).sum
}

object testBundle extends App {
  val cookie = new SimpleItem(1, "cookie")
  val cake = new SimpleItem(2, "cake")
  val inne = new SimpleItem(5, "a co innego")

  var bundle = new Bundle
  bundle.addItem(cookie)
  println(cookie)
  bundle.addItem(cake)
  bundle.addItem(inne)

  println(bundle.printDescription)
  println(bundle.printPrice)
}
