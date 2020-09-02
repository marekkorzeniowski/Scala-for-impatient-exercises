import scala.io.StdIn

object passwordCheck extends App {

  val correctPassword = "secret"
  val name = java.lang.System.getProperty("user.name")

  var flag = true
  while (flag) {

    println("What's your name")
    print("> ")
    var input = Console.in.readLine()

    println("Hello" + input + "\nWhat's your password?")

    var pass = Console.in.readLine()
    if(name.equals(input) && pass.equals(correctPassword)){
     println( "Welcome!")
      flag = false
    }
    else {
      println("Try again")
    }
  }
}
