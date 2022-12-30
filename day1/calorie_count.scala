import scala.io.Source

object main extends App {
	val inventoryElfs = Source.fromFile("input.txt").mkString.split("\n\n")
	val summedUp = Array.newBuilder[Int]
	inventoryElfs.foreach { str =>
		val numbers = str.split("\n").map(_.toInt).foldLeft(0)(_ + _)
		summedUp += numbers
	}
	val result = summedUp.result().sortWith(_ > _)
	val firstTask = result.head.println
	val secondTask = result.take(3).sum.println
}