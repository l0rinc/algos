package quickfind

import scala.collection._
import scala.language.postfixOps

class QuickFindHash[T] extends QuickFindBase[T] {
  private val associations = mutable.HashMap[T, T]()

  override def groups = reverse(associations)

  override protected def get(value: T) = associations getOrElse (value, value)
  override protected def put(value: T, parent: T) = {
    associations(value) = parent
    parent
  }
}