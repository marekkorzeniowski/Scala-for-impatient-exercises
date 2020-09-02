package chapter5

class BankAccount {

  private var balance = 0

  def show() = balance
  def deposit(amount: Int) = balance += amount
  def withdraw(amount: Int) = if (amount <= balance) balance -= amount else sys.error("Not enough resources")


  object Main extends App {

    var bank = new BankAccount
    println(bank.balance)
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    var bank = new BankAccount
    println(bank.show)

    bank.deposit(100)
    println(bank.show)
  }

}


