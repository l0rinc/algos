package quickfind

import scala.language.postfixOps

object Main extends App {
  private def parse(input: String) = (input split ' ' toList) map (_ split '-' map (_ toInt) toList)
  private val connections = parse("8-0 9-4 3-7 1-9 2 5-4-7")

  Array(new QuickFindHash[Int], new QuickFindArray(9)) foreach { app ⇒
    println(app.getClass getSimpleName)

    connections foreach { elements ⇒
      println(s"Connecting $elements")
      app connect (elements: _*)
    }

    app.groups map (_._2 mkString ("{", ", ", "}")) foreach println

    assert(app.areConnected(8, 0))
    assert(app.areConnected(3, 1, 4, 1, 5, 9))
    assert(app.areConnected(7))
    assert(!app.areConnected(8, 0, 1))
    assert(!app.areConnected(100, 2))
  }
}