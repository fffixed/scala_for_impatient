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

  /** ex06*/
  class Person(_age: Int) {
    var age = if (_age > 0) _age else 0
  }



}
