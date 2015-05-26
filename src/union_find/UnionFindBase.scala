package union_find

import scala.collection._

/** http://www.cs.princeton.edu/courses/archive/fall12/cos226/lectures/00Intro+15UnionFind.pdf */

trait UnionFindBase[T] {
  def connect(elems: T*) = {
    val parent = root(elems(0))
    elems foreach (e ⇒ put(root(e), parent))
  }

  protected def root(value: T): T = { // TODO @tailrec?
    val parent = get(value)
    if (value == parent) parent
    else put(value, root(parent))
  }

  def areConnected(elems: T*) = (elems map root).toSet.size == 1

  def count = groups.size

  protected def reverse(map: Map[T, T]) = map groupBy (entry ⇒ root(entry._2)) mapValues (_.keys)

  def groups: Map[T, Iterable[T]]
  protected def get(value: T): T
  protected def put(value: T, parent: T): T
}