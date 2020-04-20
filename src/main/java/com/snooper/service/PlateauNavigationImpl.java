package com.snooper.service;

import com.snooper.constant.Action;
import com.snooper.dto.Plateau;
import com.snooper.dto.RoboticRover;
import com.snooper.exception.OutOfBoundaryException;

import java.util.List;

public class PlateauNavigationImpl implements PlateauNavigation {

    private RoboticRoverAction roboticRoverAction = new RoboticRoverActionImpl();

    @Override
    public void handle(Plateau plateau, RoboticRover roboticRover, List<Action> actions) throws OutOfBoundaryException {
        this.checkBoundary(plateau, roboticRover);

        for (Action action: actions) {
            roboticRoverAction.act(roboticRover, action);
            this.checkBoundary(plateau, roboticRover);
        }
    }

    private void checkBoundary(Plateau plateau, RoboticRover roboticRover) throws OutOfBoundaryException {
        if (roboticRover.getCoordinate().getX() < plateau.getMinX()
                || roboticRover.getCoordinate().getX() > plateau.getMaxX()
                || roboticRover.getCoordinate().getY() < plateau.getMinY()
                || roboticRover.getCoordinate().getY() > plateau.getMaxY()
        ) {
            throw new OutOfBoundaryException("OutOfBoundaryException");
        }
    }
}
