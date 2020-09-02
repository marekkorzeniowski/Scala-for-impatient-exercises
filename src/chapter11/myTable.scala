package chapter11

class myTable(private val rows: List[List[String]]= List(List())) {
  def | (cellContent: String) = new myTable(rows.updated(rows.length-1, rows.last ++ List(cellContent)))
  def || (cellContent: String) = new myTable(rows ++ List(List(cellContent)))

  override def toString: String = "<table>" +
  s"<tr>${rows.map(cells =>
    cells.map(cell =>
    s"<td>$cell</td>").mkString("")).mkString("")}</tr>" + "</table>"

}

object myTable extends App{
  def apply() = new myTable()

  println(Table() | "Java" | "Scala" || "gostling" | "Janek" || "zbychu" | "mama")
}
