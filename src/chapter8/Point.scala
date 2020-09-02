package chapter8

class Point(val x: Int, val y: Int) {
  def +(that: Point) = new Point(x + that.x, y + that.y)
  def /(div: Int) = new Point(x/div, y/div)

  override def toString: String = s"x: ${x}, y:${y}"
}

class LabeledPoint(val lable: String, val xLabled: Int, val yLabled: Int) extends Point( xLabled, yLabled)

abstract class Shape {
  def centerPoint: Point
}

class Rectangle(leftTop: Point, rightBottom: Point) extends Shape {
  override def centerPoint: Point = (leftTop + rightBottom)/2
}

class Circle(override val centerPoint: Point, val radius: Double) extends Shape

object shapeTest extends App {
  val a = new Point(4,0)
  val b = new Point(0,4)

  val rec = new Rectangle(a,b)
  println(rec.centerPoint)
}

class Square(x: Int, y: Int, width: Int) extends java.awt.Rectangle(x, y, width, width) {
//  def this() = this(0,0,0)
//  def this(width: Int) = this(0,0, width)
//  def this(x: Int, y: Int, width: Int) = this(x,y , width)
}
