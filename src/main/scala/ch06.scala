object ch06 {

  /** ex01 */
  object Conversions {
    def inchesToCentimeters(inches: Double): Double = inches * 2.54
    def gallonsToLiters(gallons: Double): Double = gallons * 4.5461
    def milesToKilometers(miles: Double): Double = miles * 1.60934
  }

  /** ex02 */
  class UnitConversion(val rate: Double) {
    def apply(x: Double): Double = x * rate
  }
  object InchesToCentimeters extends UnitConversion(2.54)
  object GallonsToLiters extends UnitConversion(4.5461)
  object MilesToKilometers extends UnitConversion(1.60934)

  /** ex03 */
  object Origin extends java.awt.Point
  //This is probably a bad idea because java.awt.Point has direct access to variables x, y.

  /** ex04 */
  class Point(x: Int = 0, y: Int = 0) extends java.awt.Point(x, y)
  object Point {
    def apply(x: Int = 0, y: Int = 0): Point = new Point(x, y)
  }

  /** ex05 */
  object ex05 extends App {
    println(args.reverse.mkString(" "))
  }

  /** ex06 */
  object CardSuit extends Enumeration {
    val Clubs = Value("♣")
    val Diamonds = Value("♦")
    val Hearts = Value("♥")
    val Spades = Value("♠")
  }

  /** ex07 */
  def isRedSuit(suit: CardSuit.Value): Boolean = {
    suit == CardSuit.Diamonds || suit == CardSuit.Hearts
  }

  /** ex08 */
  object CubeRGB extends Enumeration {
    val Black =   Value(0x000000)
    val Red =     Value(0xff0000)
    val Yellow =  Value(0xffff00)
    val Green =   Value(0x00ff00)
    val Cyan =    Value(0x00ffff)
    val Blue =    Value(0x0000ff)
    val Magenta = Value(0xff00ff)
    val White =   Value(0xffffff)
  }


}