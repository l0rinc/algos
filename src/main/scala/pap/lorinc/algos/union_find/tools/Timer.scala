package pap.lorinc.algos.union_find.tools

object Timer {
  def run[T](closure: ⇒ T): T = {
    val time = System.currentTimeMillis

    val result = closure

    val difference = System.currentTimeMillis - time
    println(s"Done in ${(difference / 10) / 100.0}s!")

    result
  }
}
