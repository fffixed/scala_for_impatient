import scala.beans.BeanProperty

object ch05 {

  /** ex01 */
  class Counter {
    private var value = 0
    def increment() { if (value == Int.MaxValue) value = 0 else value += 1 }
    def current = value
  }

  /** ex02 */
  class BankAccount {
    private var _balance: Double = 0
    def balance = _balance

    def deposit(amount: Double) {
      if (amount < 0) throw new Exception("Deposit amount can't be negative")
      _balance += amount
    }

    def withdraw(amount: Double) {
      if (amount < 0) throw new Exception("Withdrawal amount can't be negative")
      _balance -= amount
    }
  }

  /** ex03 */
  class Time(val hours: Int, val minutes: Int) {
    if (hours < 0 || hours > 23) throw new Exception("Incorrect hours value")
    if (minutes < 0 || minutes > 59) throw new Exception("Incorrect minutes value")
    def before(other: Time): Boolean = {
      hours < other.hours  || (hours == other.hours && minutes < other.minutes)
    }
  }

  /** ex04 */
  class Time2(_hours: Int, _minutes: Int) {
    private val total = _hours * 60 + _minutes
    if (total >= 1440) throw new Exception("Total number of minutes exceeds maximum for a day")
    def hours: Int = total / 60
    def minutes: Int = total % 60
    def before(other: Time2): Boolean = total < other.total
  }

  /** ex05 */
  class Student(@BeanProperty var name: String, @BeanProperty var id: Long)

  /** ex06 */
  class Person(_age: Int) {
    var age = if (_age > 0) _age else 0
  }

  /** ex07 */
  class Person2(name: String) {
    private[this] val qName = name.split(" ")
    if (qName.length < 2) throw new Exception("The name must contain first and last names separated by a space")
    val firstName: String = name.split(" ").head
    val lastName: String = name.split(" ").tail.head
  }

  /** ex08 */
  class Car(val manufacturer: String, val model: String) {
    private var _yearManufacture: Int = -1
    def yearManufacture = _yearManufacture
    var regNumber: String = ""

    def this(manufacturer: String, model: String, yearManufacture: Int) {
      this(manufacturer, model)
      this._yearManufacture = yearManufacture
    }
    def this(manufacturer: String, model: String, regNumber: String) {
      this(manufacturer, model)
      this.regNumber = regNumber
    }
    def this(manufacturer: String, model: String, yearManufacture: Int, regNumber: String) {
      this(manufacturer, model, yearManufacture)
      this.regNumber = regNumber
    }
  }

  /** ex09 */
  //boredom

  /** ex10 */
  class Employee {
    private var _name: String = "John Q. Public"
    def name = _name
    var salary: Double = 0.0

    def this(name: String, salary: Double) {
      this()
      this._name = name
      this.salary = salary
    }
  }

  //I like the next variant better without explicitly declaring properties:
  class Employee2(val name: String = "John Q. Public", var salary: Double = 0.0)

}
