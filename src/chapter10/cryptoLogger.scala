package chapter10

trait Logger {
  def log(msg: String)
}

trait ConsoleLogger extends Logger{
  override def log(msg: String): Unit = println("log:" + msg)
}

trait CryptoLogger extends Logger{
  val key = 3
  abstract override def log(msg: String): Unit = super.log(msg.map(c => (key + c).toChar).mkString)
}

object loggerTest extends App{
  val logger1 = new ConsoleLogger with CryptoLogger
  logger1.log("Hello world")

  val logger2 = new ConsoleLogger with CryptoLogger{
    override val key: Int = 0
  }
  logger2.log("Hello world")

}
