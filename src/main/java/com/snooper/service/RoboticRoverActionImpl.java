package com.snooper.service;

import com.snooper.constant.Action;
import com.snooper.constant.Direction;
import com.snooper.dto.Coordinate;
import com.snooper.dto.RoboticRover;

public class RoboticRoverActionImpl implements RoboticRoverAction {
    @Override
    public void act(RoboticRover roboticRover, Action action) {
        Direction direction = roboticRover.getDirection();

        if (action == Action.L) {
            roboticRover.setDirection(direction.getLeftTurn());
        } else if (action == Action.R) {
            roboticRover.setDirection(direction.getRightTurn());
        } else {
            int x = roboticRover.getCoordinate().getX() + direction.getMoveX();
            int y = roboticRover.getCoordinate().getY() + direction.getMoveY();
            roboticRover.setCoordinate(new Coordinate(x, y));
        }
    }
}
