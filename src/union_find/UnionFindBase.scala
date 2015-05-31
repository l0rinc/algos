package union_find

import scala.collection._

/** http://www.cs.princeton.edu/courses/archive/fall12/cos226/lectures/00Intro+15UnionFind.pdf */

trait UnionFindBase[@specialized(Int) T] {
  def connect(first: T, rest: T*): Unit = {
    val parent = root(first)
    for (value ← rest)
      put(root(value), parent)
  }

  protected def root(value: T): T = get(value) match {
    case Some(parent) if parent != value ⇒ put(value, root(parent))
    case _                               ⇒ value
  }

  def connected(first: T, second: T, rest: T*) = {
    val reference = root(first)
    (reference == root(second)
     && (rest forall { reference == root(_) }))
  }

  def count = groups.size

  protected def reverse(map: Map[T, T]) = map groupBy (entry ⇒ root(entry._2)) mapValues (_.keys)

  def groups: Map[T, Iterable[T]]
  protected def get(value: T): Option[T]
  protected def put(value: T, parent: T): T
}