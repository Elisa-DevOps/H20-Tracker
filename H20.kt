//Project: H20/ Fluid Intake Tracker
//Purpose: Tracking Water Consumption
//Author: Elisa Aldridge

import java.io.File

fun readCsvSimple(fileName: String) {
    val lines = File(fileName).readLines()
    lines.forEach { line ->
        val row = line.split(",")
        println(row)
    }
}

var inputOfUser = mutableListOf("Ounces,Time,Lat,Long")

fun writeCsvSimple(fileName: String) {
    File(fileName).writeText(inputOfUser.joinToString("\n"))
}

var fluidTracker = 0

fun welcome() {
    println("Welcome to the H20 Tracker. Written by Elisa Aldridge.")

    while (true) {
        println("Would you like to enter water consumption details? y/n")
        var userInput = readLine()
        if (userInput == "y") {
            println("Please enter the amout of fluid you consumed in Ounces:")
            var inputOunces = readLine()!!.toInt()
            fluidTracker += inputOunces
            println("You have consumed $fluidTracker Ounces\n")

            println("Please enter the time you consume the fluid: [example: 3:30pm is 15:30]")
            var inputTime = readLine()

            println("Please enter the latitude:")
            var inputLat = readLine()

            println("Pleae enter the longitude:")
            var inputLong = readLine()

            inputOfUser.add("$inputOunces,$inputTime,$inputLat,$inputLong")
            println("$inputOunces,$inputTime,$inputLat,$inputLong")

            fluidTracker += inputOunces
            println("You have consumed a total of $fluidTracker Ounces")
        } else if (userInput == "n") {
            println("You selected no\n")
            println("Goodbye")
            break
        } else {
            println("You did not select a valid input\n")
            println("Good-bye")
            break
        }
    }  
}

fun main() {
    //inputOfUser.add("9,2:54")
    welcome()
    writeCsvSimple("water.csv")
    readCsvSimple("water.csv")

}