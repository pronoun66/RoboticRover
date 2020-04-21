package com.snooper.service

import com.snooper.constant.Action
import com.snooper.dto.Plateau
import com.snooper.dto.RoboticRover

interface CommandHandler {
    fun parsePlateau(command: String): Plateau

    fun parseRoboticRover(command: String): RoboticRover

    fun parseActions(command: String): List<Action>
}