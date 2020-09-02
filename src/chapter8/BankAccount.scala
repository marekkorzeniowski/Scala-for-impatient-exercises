package chapter8

class BankAccount(initialBalance: Double) {
  private var balance = initialBalance
  def currentBalance = balance
  def deposit(amount: Double) = { balance += amount; balance}
  def withdraw(amount: Double) = { balance -= amount; balance}

  override def toString: String = s"Account balance = ${balance}"
}

class CheckingAccount(var initialBalance: Double) extends BankAccount(initialBalance) {
  override def deposit(amount: Double): Double = {initialBalance += (amount-1); initialBalance}
  override def withdraw(amount: Double): Double = {initialBalance -= (amount+1); initialBalance}
}


class SavingsAccount(var balance: Double, val interest: Double) extends BankAccount(balance) {
  val maxActions = 3

  private[this] var actionsInMonth = 0

  override def deposit(amount: Double): Double = {
    actionsInMonth +=1
    super.deposit(amount - (if(actionsInMonth > maxActions) 2 else 0))
  }

  override def withdraw(amount: Double): Double = {
    actionsInMonth += 1
    super.withdraw(amount + (if(actionsInMonth > maxActions)2 else 0))
  }

  def earnMonthlyIntrest() = {
    actionsInMonth = 0
    super.deposit(balance * (interest/100))
  }

//  override def toString: String = s"Balance = ${balance}, and Counter ${counter}"
}

object bank extends App {
  val savings = new SavingsAccount(100, 3)
  println(savings)
  savings.deposit(100)
  savings.earnMonthlyIntrest()
  println(savings)
  savings.deposit(100)
  savings.deposit(100)

  savings.deposit(100)
 println(savings)
  savings.withdraw(50)
  println(savings)

}