package chapter11

import scala.collection.mutable.ListBuffer

class Table(private val rows: List[List[String]] = List(List())){

  def |(cellContent: String) = new Table(rows.updated(rows.length-1, rows.last ++ List(cellContent)))
  def ||(cellContenet:String) = new Table(rows ++ List(List(cellContenet)))

  override def toString: String = "<table>" +
  rows.map(cells => s"<tr>${cells.map(cell => s"<td>$cell</td>").mkString("")}</tr>").mkString("") + "</table>"
}

object Table extends App{
  def apply() = new Table()

  println(Table() | "Java" | "Scala" || "gostling" | "Janek" || "zbychu" | "mama")
}
