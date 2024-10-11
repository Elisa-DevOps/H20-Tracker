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

fun validateFluidInput(inputOunces: String?) : Int? {
    //println("$inputOunces")
    println("You have not entered a Fluid Number Value. Please try again.\n")
    return inputOunces!!.toIntOrNull()   //!!non-null string, converts to int or throws null
}

var fluidTracker = 0

fun processFluidConsumption() {
    while (true) {
        println("Would you like to enter water consumption details? y/n")
        var userInput = readLine()
        if (userInput == "y" || userInput == "Y") {
            println("Please enter the amout of fluid you consumed in Ounces:")
            var inputOunces = readLine()
            var intOunces = validateFluidInput(inputOunces)     //sends user inputOunces to function validateFluidInput
            
            if (intOunces == null) {                        //if null returned from validateFluidInput, start at while
                continue
            }

            fluidTracker += intOunces
            println("You have consumed $fluidTracker Ounces\n")

            //need to write time input validations
            println("Please enter the time you consume the fluid: [example: 3:30pm is 15:30]")
            var inputTime = readLine()

            //need to write lat & long value input validations
            println("Please enter the latitude:")
            var inputLat = readLine()

            println("Pleae enter the longitude:")
            var inputLong = readLine()

            inputOfUser.add("$inputOunces,$inputTime,$inputLat,$inputLong")
            println("$inputOunces,$inputTime,$inputLat,$inputLong")

            fluidTracker += intOunces
            println("You have consumed a total of $fluidTracker Ounces")
        } else if (userInput == "n" || userInput == "N") {
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
    println("Welcome to the H20 Tracker.")
    //inputOfUser.add("9,2:54")
    processFluidConsumption()
    writeCsvSimple("water.csv")
    readCsvSimple("water.csv")

}