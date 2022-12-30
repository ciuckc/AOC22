import scala.io.Source

object main extends App
{
	def firstTask(inputString: String): Int = {
		val hashMap: Map[String, Int] = Map[String, Int]
			("A X"-> 4, "A Y" -> 8, "A Z" -> 3, 
			"B X" -> 1, "B Y"-> 5, "B Z" -> 9, 
			"C X" -> 7, "C Y" -> 2, "C Z" -> 6)
		return inputString.split("\n").map(hashMap.get(_).get).sum
	}

	def secondTask(inputString: String): Int = {
		val hashMap: Map[String, Int] = Map[String, Int]
			("A X"-> 3, "A Y" -> 4, "A Z" -> 8, 
			"B X" -> 1, "B Y"-> 5, "B Z" -> 9, 
			"C X" -> 2, "C Y" -> 6, "C Z" -> 7)
			return inputString.split("\n").map(hashMap.get(_).get).sum
	}

	val inputString: String = Source.fromFile("input.txt").mkString
	var totalPoints = firstTask(inputString)
	println(totalPoints)
	var coditionedWin = secondTask(inputString)
	println(coditionedWin)
}
// rock = 1 paper = 2 scissor = 3
// lose = 0 draw = 3 win = 6