package pap.lorinc.algos.union_find.percolation

import pap.lorinc.algos.union_find.UnionFindBase

import scala.language.postfixOps

class Percolation(override val dim: Int, private val union: UnionFindBase[Int]) extends Grid(dim) {
  def include(coords: (Int, Int)): Unit = {
    val node = toIndex(coords)
    mark(node)
    connect(node, coords)

    val (x, y) = coords
    for ((dx, dy) ← neighbors)
      connect(node, (x + dx, y + dy))
  }

  def connect(node: Int, neighbor: (Int, Int)) = {
    if (marked(neighbor)) {
      union connect (node, toIndex(neighbor))

      val (_, y) = neighbor
      if (y == 0)
        union connect (node, topVirtualNode)
      else if (y == dim - 1)
        union connect (node, bottomVirtualNode)
    }
  }

  def percolates = union connected (topVirtualNode, bottomVirtualNode)
}