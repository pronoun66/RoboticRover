package com.snooper.service

import com.snooper.constant.Action
import com.snooper.constant.Direction
import com.snooper.dto.Coordinate
import com.snooper.dto.Plateau
import com.snooper.dto.RoboticRover
import com.snooper.exception.OutOfBoundaryException
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PlateauNavigationImplTests {
    private val plateauNavigationImpl = PlateauNavigationImpl()

    @Test
    fun `plateauNavigationImpl happy path`() {
        val plateau = Plateau(0, 0, 5, 5)
        val roboticRover = RoboticRover(Coordinate(0, 0), Direction.N)
        try {
            plateauNavigationImpl.handle(plateau, roboticRover, listOf(Action.M, Action.M))
        } catch (e: OutOfBoundaryException) {
            e.printStackTrace()
        }
        assertEquals(0, roboticRover.coordinate.x)
        assertEquals(2, roboticRover.coordinate.y)
        assertEquals(Direction.N, roboticRover.direction)
    }

    @Test
    fun `plateauNavigationImpl should throw OutOfBoundaryException when robot is over plateau's boundary`() {
        val plateau = Plateau(0, 0, 1, 1)
        val roboticRover = RoboticRover(Coordinate(0, 0), Direction.N)
        val exception: Exception = assertThrows(OutOfBoundaryException::class.java) {
            plateauNavigationImpl.handle(plateau, roboticRover, listOf(Action.M, Action.M)) }

        assertTrue(exception.message!!.contains("OutOfBoundaryException"))
    }
}