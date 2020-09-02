package chapter11
import java.nio.file.{Path, Paths}

object PathComponents extends App{

  val path: Path = Paths.get(raw"/home/marek/tutorials/Scala-for-Impatient/src/chapter10/cryptoLogger.scala")

  def unapply(path: java.nio.file.Path): Option[(Path, String)] = {
    if (path.getNameCount == 0) None
    else Some((path, path.getFileName.toString))
  }

//  println(unapply(path))

  def unapplySeq(path: java.nio.file.Path): Option[Seq[String]] = {
    if (path.getNameCount == 0) None
    else {
      import scala.collection.JavaConverters._
      val es = for (e <- path.asScala) yield e.toString
      Some(es.toSeq)
    }
  }

  println(unapplySeq(path))

  println(unapply(path))



}
