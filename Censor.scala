trait Censor {
  val replacements = Map(
    "shoot" -> "pucky",
    "darn" -> "beans"
  )

  def replace_curses(s: String): String = {
    s.split(" ").map((word) => replacements.getOrElse(word, word)).mkString(" ")
  }
}

class Curses {
  val profanity = "shoot fuck you darn"
}

object CensorTest extends App {
  val test = new Curses with Censor

  println(test.replace_curses(test.profanity))
}

