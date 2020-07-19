import scala.collection.mutable.ArrayBuffer

object ch03 {

  def ex08(): Unit = {
    val array = ArrayBuffer(1,2,3,-3,-4,5,-1,6,7,-7,8)
    val indicesOfNegative = array.indices.filter(array(_) < 0).reverse.init
    indicesOfNegative.foreach(array.remove)
    println(array)
  }

  def ex09(): Unit = {
    val array = ArrayBuffer(1,2,3,-3,-4,5,-1,6,7,-7,8)
    val iterator = array.iterator.zipWithIndex
    iterator.find(_._1 < 0)
    val secondIndexOfNegative = iterator.find(_._1 < 0).map(_._2).getOrElse(array.length)
    val indicesForMove = for (i <- secondIndexOfNegative until array.length if array(i) >= 0) yield i
    indicesForMove.zipWithIndex.foreach { case (iGlobal, ii) =>
      array(secondIndexOfNegative + ii) = array(iGlobal)
    }
    val quantityToCut = array.length - (secondIndexOfNegative + indicesForMove.length)
    if (quantityToCut > 0) array.trimEnd(quantityToCut)
    println(array)
  }

}
