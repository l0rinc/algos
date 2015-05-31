package union_find

import tools.{Random, Timer}
import union_find.percolation.Percolation

import scala.language.postfixOps

object Main extends App {
  private def parse(input: String) = (input split ' ' toList) map (_ split '-' map (_ toInt) toList)
  private val connections = parse("8-0 9-4 3-7 1-9 2 5-4-7")

  for (union ← List(new UnionFindHash[Int], new UnionFindArray(10))) {
    println(union.getClass getSimpleName)

    for (elements ← connections) {
      println(s"Connecting ${ elements }")
      union connect (elements.head, elements.tail: _*)
    }

    println(s"${ union.count } components found")
    for ((group, elements) ← union.groups)
      println(elements.toList.sorted mkString ("{", ", ", "}"))

    assert(union.connected(8, 0))
    assert(union.connected(3, 1, 4, 1, 5, 9))
    assert(union.connected(7, 7))
    assert(!union.connected(8, 0, 1))
    assert(!union.connected(100, 2))
  }

  // Percolation
  val dim = 2000
  for (union ← List(new UnionFindHash[Int], new UnionFindArray(dim * dim + 2))) {
    Random.reset()

    println(); println(union.getClass getSimpleName)

    val percolation = Timer.run { percolate(dim, union) }
    println(s"Connected: ${ percolation threshold }")
    if (percolation.dim < 100) percolation.printGrid()
  }

  def percolate(dim: Int, union: UnionFindBase[Int]) = {
    val percolation = new Percolation(dim, union)

    do {
      val coords = Random.next(dim * dim, percolation.toCoords, percolation.marked)
      percolation include coords
    } while (!percolation.percolates)

    percolation
  }
}