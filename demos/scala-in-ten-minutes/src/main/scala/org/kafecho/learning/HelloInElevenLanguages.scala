package org.kafecho.learning

/** South Africa has 11 official languages.
 *  
 *  Let's see what we can do with that information.
 *  Thanks to http://thatchwick.blogspot.com/2009/01/thursday-8-january-09-hello-in-eleven.html for the list.
 */
object HelloInElevenLanguages extends App {

  val languages = Map(
    "isiZulu" -> "Sanibonani",
    "isiXhosa" -> "Molo",
    "Afrikaans" -> "Hallo",
    "Sepedi" -> "Thobela",
    "Setswana" -> "Dumela",
    "Sesotho" -> "Lumela",
    "Xitsonga" -> "Abusheni",
    "siSwati" -> "Sanibona",
    "Tshivenda" -> "Avuwani",
    "isiNdebele" -> "Salibonani",
    "English" -> "Hello")

  println(s"In South Africa there are ${languages.size} ways to say hello.")

  /*
   * Find the shortest and longest ways of saying Hello in South Africa.
   */
  val byLength = languages
  .groupBy(tuple => tuple._2.size)
  .toList
  .sortBy ( tuple => tuple._1)
  
  println(s"Greetings grouped by length:\n${byLength.mkString("\n")}.")

  val shortest = byLength.head
  val longest = byLength.last
  
  val shortestGreetings = shortest._2.map { tuple => s"In ${tuple._1}, you greet with ${tuple._2}." }
  val longestGreetings  = longest._2.map  { tuple => s"In ${tuple._1}, you greet with ${tuple._2}." }

  println("Here are the shortest way(s) of saying hello:\n" + shortestGreetings.mkString("\n"))
  println("Here are the longest way(s) of saying hello:\n" + longestGreetings.mkString("\n"))

  /*
   * Which language gives you the most Scrabble points?
   */
  val scrabblePoints = Map(
    "eaionrtlsu" -> 1,
    "dg" -> 2,
    "bcmp" -> 3,
    "fhvwy" -> 4,
    "k" -> 5,
    "jx" -> 8,
    "qz" -> 10)

  /** Find out how many points a given letter give you. */
  def scrabblePoints(letter: Char): Int = {
    val key = scrabblePoints.keys.find(_.contains(letter.toLower)).get
    scrabblePoints(key)
  }

  val scrabblePointsPerLanguage = languages.toList.map{ pair => 
    val (language, _) = pair
    (language, language.map { letter => scrabblePoints(letter) }.sum)
  }.sortBy{ tuple => tuple._2}

  println (scrabblePointsPerLanguage)
  
  println ("If you know how to spell it:")
  println( scrabblePointsPerLanguage.map ( tuple => s"-${tuple._1} will get you ${tuple._2} points.").mkString("\n") )
}