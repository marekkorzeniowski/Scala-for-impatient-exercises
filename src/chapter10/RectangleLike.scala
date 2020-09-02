package chapter10
import java.awt.geom.{Ellipse2D, Rectangle2D}

trait RectangleLike {
 this: java.awt.geom.RectangularShape =>

  def translate(dx: Int, dy: Int) = {
    this.setFrame(this.getX + dx, this.getY + dy, this.getWidth, this.getHeight)
    this
  }

  def grow(dx: Int, dy: Int) = {
    this.setFrame(this.getX, this.getY, this.getWidth*dx, this.getHeight* dy)
    this
  }

  override def toString: String = s"RectangleLike x: $getX, y:$getY, width: $getWidth, height: $getHeight"


}

object rectangleTest extends App {
  val egg = new Ellipse2D.Double(0,0, 5,5) with RectangleLike
  egg.translate(1,2)
  egg.grow(2,2)

  println(egg)

}
