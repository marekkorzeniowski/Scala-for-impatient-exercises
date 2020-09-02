package chapter10
import java.awt.Point

class OrderedPoint(x: Int, y: Int) extends java.awt.Point(x,y) with scala.math.Ordered[java.awt.Point]{
  override def compare(that: Point): Int = {
    if(getX == that.getX) getY compare that.getY
    else getX compare that.getX
  }
}

object testOrdPoint extends App{
  val x1 = new OrderedPoint(10,0)
  val x2 = new OrderedPoint(9,9)

println(x1 > x2)

}

