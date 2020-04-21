package com.snooper.service

import com.snooper.constant.Action
import com.snooper.constant.Direction
import com.snooper.dto.Coordinate
import com.snooper.dto.RoboticRover
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class RoboticRoverActionImplTests {
    private val roboticRoverAction = RoboticRoverActionImpl()

    @ParameterizedTest(name = "{0} turns left should be {1}")
    @CsvSource(
            "E, N",
            "W, S",
            "N, W",
            "S, E"
    )
    fun turnLeft(before: String, after: String) {
        val x = 1
        val y = 1
        val roboticRover = RoboticRover(Coordinate(x, y), Direction.valueOf(before))
        roboticRoverAction.act(roboticRover, Action.L)
        assertEquals(x, roboticRover.coordinate.x)
        assertEquals(y, roboticRover.coordinate.y)
        assertEquals(Direction.valueOf(after), roboticRover.direction)
    }

    @ParameterizedTest(name = "{0} turns right should be {1}")
    @CsvSource(
            "E, S",
            "W, N",
            "N, E",
            "S, W"
    )
    fun turnRight(before: String, after: String) {
        val x = 1
        val y = 1
        val roboticRover = RoboticRover(Coordinate(x, y), Direction.valueOf(before))
        roboticRoverAction.act(roboticRover, Action.R)
        assertEquals(x, roboticRover.coordinate.x)
        assertEquals(y, roboticRover.coordinate.y)
        assertEquals(Direction.valueOf(after), roboticRover.direction)
    }

    @ParameterizedTest(name = "[{1}, {2}] move {0} should be [{3}, {4}]")
    @CsvSource(
            "E, 1, 1, 2, 1",
            "W, 1, 1, 0, 1",
            "N, 1, 1, 1, 2",
            "S, 1, 1, 1, 0"
    )
    fun move(direction: String, beforeX: Int, beforeY: Int, afterX: Int, afterY: Int) {
        val afterDirection = Direction.valueOf(direction)
        val roboticRover = RoboticRover(Coordinate(beforeX, beforeY), Direction.valueOf(direction))
        roboticRoverAction.act(roboticRover, Action.M)
        assertEquals(afterX, roboticRover.coordinate.x)
        assertEquals(afterY, roboticRover.coordinate.y)
        assertEquals(afterDirection, roboticRover.direction)
    }
}