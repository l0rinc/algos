package union_find

import scala.language.postfixOps

object Main extends App {
  private def parse(input: String) = (input split ' ' toList) map (_ split '-' map (_ toInt) toList)
  private val connections = parse("8-0 9-4 3-7 1-9 2 5-4-7")

  Array(new UnionFindHash[Int],
        new UnionFindArray(10)) foreach { app ⇒
    println(app.getClass getSimpleName)

    for (elements ← connections) {
      println(s"Connecting ${ elements }")
      app connect (elements.head, elements.tail: _*)
    }

    println(s"${ app.count } components found")
    for ((group, elements) ← app.groups)
      println(elements.toList.sorted mkString ("{", ", ", "}"))

    assert(app.connected(8, 0))
    assert(app.connected(3, 1, 4, 1, 5, 9))
    assert(app.connected(7, 7))
    assert(!app.connected(8, 0, 1))
    assert(!app.connected(100, 2))
  }
}