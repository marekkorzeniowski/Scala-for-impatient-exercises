package chapter5

class Time(val hour: Int, val minute: Int) {
  require(hour >= 0 && hour < 24, "proper format 0 - 23")
  require(minute >= 0 && minute < 60, "minute format 0 - 59")


  def before(other: Time): Boolean =
    (hour < other.hour || (hour == other.hour && minute < other.minute))

  override def toString: String = f"$hour%02d: $minute%02d"

  //addinonaly constructor
  def this(minutes: Int) = this(minutes / 60, minutes % 60)

}



object Main2 {
  def main(args: Array[String]): Unit = {
    val onePm = new Time(20, 0)
    println(onePm.toString)
    val twelve = new Time(12, 59)

    val minutes = new Time(150)
    println(minutes.toString)



    println(onePm.before(twelve))

  }
}
