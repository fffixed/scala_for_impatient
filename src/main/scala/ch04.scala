object ch04 {

  def ex01(): Unit = {
    val want = Map("laptop" -> 2000.0, "led tv" -> 1200.0, "friends" -> 0.0, "hair" -> 3000.0)
    //val want10 = want.map { case (k, v) => k -> v * 0.9 }
    val want10 = want.map(z => z._1 -> z._2 * 0.9)
    println(want10)
  }

  def ex02(): Unit = {
    val in = new java.util.Scanner(new java.io.File("README.md"))
    val wordCount = collection.mutable.Map.empty[String, Int].withDefaultValue(0)
    while (in.hasNext()) wordCount(in.next()) += 1
    println(wordCount)
  }

  def ex03(): Unit = {
    val in = new java.util.Scanner(new java.io.File("README.md"))
    var wordCount = Map.empty[String, Int].withDefaultValue(0)
    while (in.hasNext()) {
      val s = in.next()
      wordCount += s -> (wordCount(s) + 1)
    }
    println(wordCount)
  }

  def ex04(): Unit = {
    val in = new java.util.Scanner(new java.io.File("README.md"))
    var wordCount = collection.immutable.SortedMap.empty[String, Int].withDefaultValue(0)
    while (in.hasNext()) {
      val s = in.next()
      wordCount += s -> (wordCount(s) + 1)
    }
    println(wordCount)
  }

  def ex05(): Unit = {
    import collection.JavaConverters._
    val in = new java.util.Scanner(new java.io.File("README.md"))
    var wordCount = new java.util.TreeMap[String, Int].asScala
    while (in.hasNext()) {
      val s = in.next()
      wordCount += s -> (wordCount.getOrElse(s, 0) + 1)
    }
    println(wordCount)
  }

  def ex06(): Unit = {
    val calendar = collection.mutable.LinkedHashMap(
      "Monday" -> java.util.Calendar.MONDAY,
      "Sunday" -> java.util.Calendar.SUNDAY,
      "Saturday" -> java.util.Calendar.SATURDAY,
      "Friday" -> java.util.Calendar.FRIDAY,
      "Thursday" -> java.util.Calendar.THURSDAY,
      "Wednesday" -> java.util.Calendar.WEDNESDAY,
    )
    calendar += "Tuesday" -> java.util.Calendar.TUESDAY
    calendar.foreach(println)
  }

  def ex07(): Unit = {
    import collection.JavaConverters._
    val mapProps = System.getProperties.asScala
    val maxKeyLength = mapProps.keys.map(_.length).max
    println("-" * (maxKeyLength + 5 + maxKeyLength))
    mapProps.foreach { case (k, v) =>
      val space = " " * (maxKeyLength - k.length)
      println(s"| $k$space | $v")
    }
    println("-" * (maxKeyLength + 5 + maxKeyLength))
  }

  /** exercise 08  - solution 1 */
  def minmax1(values: Array[Int]): (Int, Int) = {
    if (values.isEmpty) throw new Exception("Array is empty!")
    var min = values(0)
    var max = min
    values.foreach { v =>
      if (v < min) min = v
      if (v > max) max = v
    }
    (min, max)
  }

  /** exercise 08 - solution 2 */
  def minmax2(values: Array[Int]): (Int, Int) = {
    if (values.isEmpty) throw new Exception("Array is empty!")
    values.foldLeft(values(0), values(0)) { case ((min,max),v) =>
      (if (v < min) v else min, if (v > max) v else max)
    }
  }

  /** exercise 08 - native solution */
  def minmax(values: Array[Int]): (Int, Int) = {
    if (values.isEmpty) throw new Exception("Array is empty!")
    (values.min, values.max)
  }

    /** exercise 09 */
  def lteqgt(values: Array[Int], x: Int): (Int, Int, Int) = {
    values.foldLeft(0,0,0) { case ((less,equal,greater),v) =>
      if (v < x) (less + 1, equal, greater)
      else if (v == x) (less, equal + 1, greater)
      else (less, equal, greater + 1)
    }
  }

  def ex10(): Unit = {
    val zip1 = "Hello".zip("World")
    println(zip1)
  }

}
