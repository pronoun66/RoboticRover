package com.snooper.dto

data class Plateau (var minX: Int, var minY: Int, var maxX: Int, var maxY: Int) {
    init {
        if (minX > maxX) {
            throw IllegalArgumentException("Invalid minX and maxX")
        }

        if (minY > maxY) {
            throw IllegalArgumentException("Invalid minY and maxY")
        }
    }
}