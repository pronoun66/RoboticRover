package com.snooper.service

import com.snooper.constant.Action
import com.snooper.dto.Plateau
import com.snooper.dto.RoboticRover
import com.snooper.exception.OutOfBoundaryException

class PlateauNavigationImpl : PlateauNavigation {
    private val roboticRoverAction: RoboticRoverAction = RoboticRoverActionImpl()

    @Throws(OutOfBoundaryException::class)
    override fun handle(plateau: Plateau, roboticRover: RoboticRover, actions: List<Action>) {
        checkBoundary(plateau, roboticRover)
        for (action in actions) {
            roboticRoverAction.act(roboticRover, action)
            checkBoundary(plateau, roboticRover)
        }
    }

    @Throws(OutOfBoundaryException::class)
    private fun checkBoundary(plateau: Plateau, roboticRover: RoboticRover) {
        if (roboticRover.coordinate.x < plateau.minX
                || roboticRover.coordinate.x > plateau.maxX
                || roboticRover.coordinate.y < plateau.minY
                || roboticRover.coordinate.y > plateau.maxY) {
            throw OutOfBoundaryException("OutOfBoundaryException")
        }
    }
}