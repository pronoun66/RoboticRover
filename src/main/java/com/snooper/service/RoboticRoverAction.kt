package com.snooper.service

import com.snooper.constant.Action
import com.snooper.dto.RoboticRover

interface RoboticRoverAction {
    fun act(roboticRover: RoboticRover, action: Action)
}