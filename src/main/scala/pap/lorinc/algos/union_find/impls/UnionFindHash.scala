package pap.lorinc.algos.union_find.impls

import pap.lorinc.algos.union_find.UnionFindBase

import scala.collection._
import scala.language.postfixOps

class UnionFindHash[@specialized(Int) T] extends UnionFindBase[T] {
  private val associations = mutable.HashMap[T, T]()

  override def groups = reverse(associations)

  override protected def get(value: T) = associations get value
  override protected def put(value: T, parent: T) = {
    associations(value) = parent
    parent
  }
}