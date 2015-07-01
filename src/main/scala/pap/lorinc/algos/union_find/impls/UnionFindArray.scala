package pap.lorinc.algos.union_find.impls

import pap.lorinc.algos.union_find.UnionFindBase

import scala.language.postfixOps

class UnionFindArray(private val dim: Int) extends UnionFindBase[Int] {
  val associations = (0 to dim) toArray

  override def groups = reverse(associations.zipWithIndex map (_.swap) toMap)

  override protected def get(value: Int) = associations lift value
  override protected def put(value: Int, parent: Int) = {
    associations(value) = parent
    parent
  }
}