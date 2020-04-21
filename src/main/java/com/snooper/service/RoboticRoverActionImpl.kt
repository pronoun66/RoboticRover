package com.snooper.service

import com.snooper.constant.Action
import com.snooper.dto.Coordinate
import com.snooper.dto.RoboticRover

class RoboticRoverActionImpl : RoboticRoverAction {
    override fun act(roboticRover: RoboticRover, action: Action) {
        val direction = roboticRover.direction
        when (action) {
            Action.L -> roboticRover.direction = direction.leftTurn()
            Action.R -> roboticRover.direction = direction.rightTurn()
            else -> {
                val x = roboticRover.coordinate.x + direction.moveX
                val y = roboticRover.coordinate.y + direction.moveY
                roboticRover.coordinate = Coordinate(x, y)
            }
        }
    }
}