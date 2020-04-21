package com.snooper

import com.snooper.exception.OutOfBoundaryException
import com.snooper.service.CommandHandler
import com.snooper.service.CommandHandlerImpl
import com.snooper.service.PlateauNavigation
import com.snooper.service.PlateauNavigationImpl
import java.util.*
import java.util.stream.Collectors

class Application {

    private var plateauNavigation: PlateauNavigation = PlateauNavigationImpl()
    private var commandHandler: CommandHandler = CommandHandlerImpl()

    fun roboticRoverNavigatePlateau(input: String): String {
        val commands = input.split("\n")

        require(commands.isNotEmpty()) { "Null input" }
        require(commands.size % 2 != 0) { "Invalid input" }

        val plateau = commandHandler.parsePlateau(commands[0])

        // Each command set includes roboticRover and actions
        val commandSets: MutableList<Array<String>> = ArrayList()

        var i = 1
        while (i < commands.size) {
            commandSets.add(arrayOf(commands[i], commands[i + 1]))
            i += 2
        }

        // parallel running commandSets
        val results = commandSets.stream()
                .parallel()
                .map { commandSet: Array<String> ->
                    val roboticRover = commandHandler.parseRoboticRover(commandSet[0])
                    val actions = commandHandler.parseActions(commandSet[1])
                    try {
                        plateauNavigation.handle(plateau, roboticRover, actions)
                        val x = roboticRover.coordinate.x
                        val y = roboticRover.coordinate.y
                        val direction = roboticRover.direction.toString()
                        return@map "$x $y $direction"
                    } catch (e: OutOfBoundaryException) {
                        return@map e.message
                    }
                }
                .collect(Collectors.toList())
        val stringBuilder = StringBuilder()
        for (result in results) {
            stringBuilder.append(result + "\n")
        }
        return stringBuilder.toString()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val application = Application()
            println(application.roboticRoverNavigatePlateau(
                    """
                        5 5
                        1 2 N
                        LMLMLMLMM
                        3 3 E
                        MMRMMRMRRM
                        0 0 S
                        M
                        1 1 W
                        M
                        2 2 N
                        M
                        """.trimIndent()
            ))
        }
    }
}