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




}
