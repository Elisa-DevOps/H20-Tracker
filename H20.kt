//Project: H20 Tracker
//Purpose: Tracking Water Consumption
//Author: Elisa Aldridge

/*class H20 (val amount: Int) {
    fun waterEntry = mutableMapOf<Int, List<String>>() {
        
    }
}*/

var fluidTracker = 0

fun waterConsum() {
    println("Would you like to enter water consumption details? y/n")
    var userInput = readLine()
    if (userInput == "y" || userInput == "n") {
        while (userInput == "y" || userInput == "n") {
            if (userInput == "y") {
                println("Please enter the amout of fluid you consumed in Ounces:")
                val ounces = readLine()!!.toInt()
                fluidTracker += ounces
                println("You have consumed $fluidTracker Ounces\n")
                println("Would you like to enter more fluids you consumed?")
                userInput = readLine()
                if (userInput == "y") {
                    println("Please enter the amout of fluid you consumed in Ounces:")
                    val ounces = readLine()!!.toInt()
                    fluidTracker += ounces
                    println("You have consumed $fluidTracker Ounces\n")
                } else {
                    println("You hace consumed a total of $fluidTracker Ounces")
                    break
                }
                break
            } else {
                println("You selected no\n")
                println("Goodbye")
                break
            }
        }
    }  else {
        println("you did not select a valid input\n")
        println("Good-bye")
    }
}

fun main() {
    waterConsum()
}