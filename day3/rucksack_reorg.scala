import scala.io.Source

@main def main() =
	def getPriorityPoints(list: List[Char]): List[Int] =
		val listOfPoints = list.map(item =>
			item match
				case item if item.isLower => item - 'a' + 1
				case item if item.isUpper => item - 'A' + 27
			)
		listOfPoints
	
	def firstTask(rucksacks: List[String]): Int =
		val divideItems: List[(String, String)]= rucksacks.map(rucksack => rucksack.splitAt(rucksack.length / 2))
		val commonItemPerRucksack: List[Char] = divideItems.map(_ intersect _).map(_.head)
		val priorityPointsPerItem: List[Int] = getPriorityPoints(commonItemPerRucksack)
		priorityPointsPerItem.sum
	
	def secondTask(rucksacks: List[String]): Int =
		val divideInGroups: List[(String, String, String)] = rucksacks
		.sliding(3, 3)
		.collect {case List(a, b, c) => (a, b, c)}
		.toList
		val commonBadgesPerGroup: List[Char]= divideInGroups.map(_ intersect _ intersect _).map(_.head)
		val priorityPointsPerGroup: List[Int] = getPriorityPoints(commonBadgesPerGroup)
		priorityPointsPerGroup.sum

	val input = Source.fromFile("input.txt").mkString
	val rucksacks: List[String] = input.split("\n").toList
	val sumOfPoints: Int = firstTask(rucksacks)
	println(sumOfPoints)
	val  sumOfBadgeTypeGroup: Int = secondTask(rucksacks)
	println(sumOfBadgeTypeGroup)