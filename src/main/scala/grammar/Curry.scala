package grammar


class Curry {

}

object Curry {
  def apply: Curry = new Curry()

  def main(args: Array[String]): Unit = {
    /**
      * Curry
      * 柯里化（Currying）是把接受多个参数的函数变换成接受一个单一参数(最初函数的第一个参数)的函数，
      * 并且返回接受余下的参数且返回结果的新函数的技术。
      *
      * 从数学的角度讲，这是一个对函数消元求解的过程。
      */
    def f(x: Int, y: Int): Int = x + y

    def g(x: Int) = f(x, 1)

    def z: Int = g(1)

    println(z)

    def zz = (x: Int) => (y: Int) => x + y

    val zz2 = (x: Int) => (y: Int) => x + y
    println(zz(1)(2))
    println(zz2(3)(3))
  }
}
