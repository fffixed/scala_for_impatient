object ch04 {

  def ex01(): Unit = {
    val want = Map("laptop" -> 2000.0, "led tv" -> 1200.0, "friends" -> 0.0, "hair" -> 3000.0)
    val want10 = want.map(z => z._1 -> z._2 * 0.9)
    println(want10)
  }

}
