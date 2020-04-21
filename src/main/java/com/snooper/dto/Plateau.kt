package com.snooper.dto

data class Plateau (var minX: Int, var minY: Int, var maxX: Int, var maxY: Int) {
    init {
        require(minX <= maxX) { "Invalid minX and maxX" }
        require(minY <= maxY) { "Invalid minY and maxY" }
    }
}