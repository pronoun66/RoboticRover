package com.snooper.service

import com.snooper.constant.Action
import com.snooper.dto.Plateau
import com.snooper.dto.RoboticRover
import com.snooper.exception.OutOfBoundaryException

interface PlateauNavigation {
    @Throws(OutOfBoundaryException::class)
    fun handle(plateau: Plateau, roboticRover: RoboticRover, actions: List<Action>)
}