package union_find.percolation

import java.lang.Math._

import scala.collection.mutable

abstract class Grid(val dim: Int) {
  protected val size = dim * dim
  private val grid = new mutable.BitSet(size)

  protected val topVirtualNode = size
  protected val bottomVirtualNode = size + 1

  def toCoords(index: Int): (Int, Int) = (index % dim, index / dim)
  def toIndex(coords: (Int, Int)): Int = {
    val (x, y) = coords
    x + y * dim
  }

  val neighbors = {
    for (dx ← -1 to 1; dy ← -1 to 1; if abs(dx) != abs(dy))
      yield (dx, dy)
  } toList

  def threshold = grid.size / size.toDouble

  def mark(node: Int) = grid add node
  def marked(coords: (Int, Int)) = {
    val (x, y) = coords
    (validIndex(x) && validIndex(y)
     && (grid contains toIndex(coords)))
  }

  private def validIndex(i: Int) = (i >= 0) && (i < dim)

  def printGrid() = {
    val range = 0 until dim
    for (i ← range; j ← range) {
      if (j == 0) {
        println("")
        if (i == 0) println("")
      }

      if (marked((j, i))) print("x")
      else print(".")
    }
  }
}