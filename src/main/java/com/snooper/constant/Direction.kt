package com.snooper.constant

enum class Direction(var moveX: Int, var moveY: Int) {
    E(1, 0) {
        override fun leftTurn() = N
        override fun rightTurn() = S
    },
    W(-1, 0) {
        override fun leftTurn() = S
        override fun rightTurn() = N
    },
    N(0, 1) {
        override fun leftTurn() = W
        override fun rightTurn() = E
    },
    S(0, -1) {
        override fun leftTurn() = E
        override fun rightTurn() = W
    };

    abstract fun leftTurn(): Direction
    abstract fun rightTurn(): Direction
}