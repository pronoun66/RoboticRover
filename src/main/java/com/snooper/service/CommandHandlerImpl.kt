package com.snooper.service

import com.snooper.constant.Action
import com.snooper.constant.Direction
import com.snooper.dto.Coordinate
import com.snooper.dto.Plateau
import com.snooper.dto.RoboticRover
import java.util.*

class CommandHandlerImpl : CommandHandler {
    override fun parsePlateau(command: String): Plateau {
        val strings = command.split(" ")

        require(strings.size == 2) { "Invalid command for plateau coordinates" }

        val maxX: Int
        val maxY: Int
        try {
            maxX = Integer.valueOf(strings[0])
            maxY = Integer.valueOf(strings[1])
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Invalid plateau coordinates")
        }

        return Plateau(0, 0, maxX, maxY)
    }

    override fun parseRoboticRover(command: String): RoboticRover {
        val strings = command.split(" ")

        require(strings.size == 3) { "Invalid command for roboticRover" }

        val x: Int
        val y: Int
        try {
            x = Integer.valueOf(strings[0])
            y = Integer.valueOf(strings[1])
        } catch (exception: IllegalArgumentException) {
            throw IllegalArgumentException("Invalid roboticRover coordinates")
        }

        val direction: Direction
        try {
            direction = Direction.valueOf(strings[2])
        } catch (exception: IllegalArgumentException) {
            throw IllegalArgumentException("Invalid direction")
        }

        return RoboticRover(Coordinate(x, y), direction)
    }

    override fun parseActions(command: String): List<Action> {
        val actions: MutableList<Action> = ArrayList()

        for (c in command.toCharArray()) {
            try {
                val action = Action.valueOf(c.toString())
                actions.add(action)
            } catch (exception: IllegalArgumentException) {
                throw IllegalArgumentException("Invalid action")
            }
        }
        return actions
    }
}