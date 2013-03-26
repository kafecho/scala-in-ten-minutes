package org.kafecho.learning

import org.scalatest.WordSpec
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.MustMatchers

/** An sample test which shows you how to write BDD using ScalaTest.
 *  
 *  ScalaTest provides an internal DSL for writing tests which are easy to read. 
 *  The code below is valid Scala code, although it reads a bit more like english.
 */
@RunWith(classOf[JUnitRunner])
class StereotypesTest extends WordSpec with MustMatchers {

  case class Person(firstname: String, country: String, likes: Set[String])

  val Guillaume = Person("Guillaume", "France", Set("Camembert", "Wine", "Braais"))
  val Ian = Person("Ian", "South Africa", Set("Braais", "Billtong", "Wine"))
  val Jacques = Person("Jacques", "South Africa", Set("Braais", "Billtong", "Wine", "Koeksisters"))
  val people = Set(Guillaume, Ian, Jacques)

  "All South Africans" must {
    "love braais" in {
      people.filter(p => p.country == "South Africa").foreach { p => p.likes("Braais") must be(true) }
    }
  }

  "Guillaume" must {

    "as a Frenchman, Like cheese and wine" in {
      Guillaume.likes("Camembert") must be(true)
      Guillaume.likes("Wine") must be(true)
    }

    "in order to get his visa, show an appreciation for braais" in {
      Guillaume.likes("Braais") must be(true)
    }
  }
}

