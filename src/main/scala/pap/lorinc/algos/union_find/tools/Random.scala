package pap.lorinc.algos.union_find.tools

import scala.annotation.tailrec

object Random {
  private var seed = System.currentTimeMillis
  val random = {
    println(s"Using seed: ${ seed }L")
    new scala.util.Random(seed)
  }

  def reset() = setSeed(seed)
  def setSeed(seed: Long) = {
    this.seed = seed
    random.setSeed(seed)
  }

  @tailrec def next[T](size: Int, transform: (Int) ⇒ T, invalid: (T) ⇒ Boolean): T = {
    val nextInt = random.nextInt(size)

    val result = transform(nextInt)
    if (invalid(result))
      next(size, transform, invalid)
    else
      result
  }
}
