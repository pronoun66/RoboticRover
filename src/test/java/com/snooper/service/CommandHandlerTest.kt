package com.snooper.service

import com.snooper.constant.Action
import com.snooper.constant.Direction
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CommandHandlerTest {
    private val commandHandler = CommandHandlerImpl()

    @Test
    fun `parsePlateau should return plateau`() {
        val (_, minY, maxX, maxY) = commandHandler.parsePlateau("4 4")
        assertEquals(4, maxX)
        assertEquals(4, maxY)
        assertEquals(0, minY)
        assertEquals(0, minY)
    }

    @Test
    fun `parsePlateau should throw exception when command is incorrect`() {
        val exception: Exception = assertThrows(IllegalArgumentException::class.java) {
            commandHandler.parsePlateau("4") }

        assertEquals("Invalid command for plateau coordinates", exception.message)
    }

    @Test
    fun `parsePlateau should throw exception when wrong coordinates format`() {
        val exception: Exception = assertThrows(IllegalArgumentException::class.java) {
            commandHandler.parsePlateau("S 4") }

        assertEquals("Invalid plateau coordinates", exception.message)
    }

    @Test
    fun `parsePlateau should throw exception when wrong minX and maxX`() {
        val exception: Exception = assertThrows(IllegalArgumentException::class.java) {
            commandHandler.parsePlateau("-1 1") }

        assertEquals("Invalid minX and maxX", exception.message)
    }

    @Test
    fun `parsePlateau should throw exception when wrong minY and maxY`() {
        val exception: Exception = assertThrows(IllegalArgumentException::class.java) {
            commandHandler.parsePlateau("1 -1") }

        assertEquals("Invalid minY and maxY", exception.message)
    }

    @Test
    fun `parseRoboticRover should return roboticRover`() {
        val (coordinate, direction) = commandHandler.parseRoboticRover("4 4 N")

        assertEquals(4, coordinate.x)
        assertEquals(4, coordinate.y)
        assertEquals(Direction.valueOf("N"), direction)
    }

    @Test
    fun `parseRoboticRover should throw exception when command is missing direction`() {
        val exception: Exception = assertThrows(IllegalArgumentException::class.java
        ) { commandHandler.parseRoboticRover("4 4") }

        assertTrue(exception.message!!.contains("roboticRover"))
    }

    @Test
    fun `parseRoboticRover should throw exception when command is using wrong direction`() {
        val exception: Exception = assertThrows(IllegalArgumentException::class.java
        ) { commandHandler.parseRoboticRover("4 4 T") }

        assertTrue(exception.message!!.contains("Invalid direction"))
    }

    @Test
    fun `parseRoboticRover should throw exception when command is using wrong x or y`() {
        val exception: Exception = assertThrows(IllegalArgumentException::class.java
        ) { commandHandler.parseRoboticRover("S 4 T") }

        assertTrue(exception.message!!.contains("Invalid roboticRover coordinates"))
    }

    @Test
    fun `parseActions should return actions`() {
        val actions = commandHandler.parseActions("LRM")
        val expectations = listOf(Action.L, Action.R, Action.M)

        for (i in actions.indices) {
            assertEquals(expectations[i], actions[i])
        }
    }

    @Test
    fun `parseActions should throw error when command is using wrong action`() {
        val exception: Exception = assertThrows(IllegalArgumentException::class.java) {
            commandHandler.parseActions("T") }

        assertTrue(exception.message!!.contains("Invalid action"))
    }
}