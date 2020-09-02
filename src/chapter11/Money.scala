package chapter11

case class Money(d: Int, c: Int) {
  //¢
  private val dolars = if(c>99) d+ c/100 else d
  private val cents = if(c>99) c% 100 else c

  override def toString: String = f"$dolars$$ $cents%1.0f¢"

  def + (other: Money) = new Money(dolars + other.dolars, cents + other.cents)
  def * (n: Int) = new Money(n*dolars, n * cents)

  def ==(other: Money) = dolars == other.dolars && cents == other.cents

}

object Money extends App{
  val mon = Money(3,101)
  val dol = Money(0,99)
  val mon1 = Money(4,1)
  println(mon + dol)

  println(mon)

  println(mon == mon1)
}
