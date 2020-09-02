package chapter11

case class Fraction(n: Int, d: Int) {
  require(d != 0)

  private val num  = n * sign(d)/ gcd(n,d)
  private val den = d * sign(d)/gcd(n,d)

  override def toString: String = s"$num/$den"

  def sign(a: Int): Int = if(a<0) -1 else if (a>0) 1 else 0
  def gcd(a: Int, b: Int): Int = if(b==0) math.abs(a) else gcd(b, a%b)

  def +(fr: Fraction): Fraction = new Fraction((num*fr.den + fr.num* den), den*fr.den)

}

object Fraction extends App{
  val fr = Fraction(1,2)
  val fr1 = Fraction(6,8)
 val fr2 = Fraction(5,1)

  println(fr+fr1)

  println(fr)
  println(fr1)
  println(fr2)
}
