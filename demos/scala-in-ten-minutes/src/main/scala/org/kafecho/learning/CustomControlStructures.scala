package org.kafecho.learning

import scala.xml.XML

/** A simple example showing how to create custom control structures in Scala.*/
object CustomControlStructures extends App {

  /** This method times the execution of the block of code passed as a parameter.
   *
   *  The block of code is a function which returns an element of type T.  
   */
  def timeThis[T](block: =>T) : T = {
    val start 	= System.nanoTime
    val result 	= block
    val duration = System.nanoTime - start
    
    // The syntax s"" is Scala String interpolation.
    // See http://docs.scala-lang.org/overviews/core/string-interpolation.html.
    println (s"The method took $duration nanoseconds to run.")
    block
  }
  
  timeThis{
    Thread.sleep(1000)
  }
  
  // Fetch the Gauteng weather using the Yahoo API. 
  val weather = timeThis{
    XML.load("http://weather.yahooapis.com/forecastrss?w=2346981&u=c")
  }
  
  // Scala has built-in support for XML parsing. It is easy to extract fields from an XML document.
  val temperature = weather \\ "condition" \ "@temp"
  println (s"The current temperature in Gauteng is $temperature degrees celsius.")
}