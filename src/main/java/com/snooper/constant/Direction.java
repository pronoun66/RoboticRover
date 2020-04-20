package com.snooper.constant;

public enum Direction {
    E(1, 0),
    W(-1, 0),
    N(0, 1),
    S(0 , -1);

    private Direction leftTurn;
    private Direction rightTurn;
    private int moveX;
    private int moveY;

    static {
        E.leftTurn = N;
        W.leftTurn = S;
        N.leftTurn = W;
        S.leftTurn = E;

        E.rightTurn = S;
        W.rightTurn = N;
        N.rightTurn = E;
        S.rightTurn = W;
    }


    Direction(int moveX, int moveY) {
        this.moveX = moveX;
        this.moveY = moveY;
    }

    public Direction getLeftTurn() {
        return leftTurn;
    }

    public Direction getRightTurn() {
        return rightTurn;
    }

    public int getMoveX() {
        return moveX;
    }

    public int getMoveY() {
        return moveY;
    }

}
