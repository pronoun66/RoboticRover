package com.snooper.service;

import com.snooper.constant.Action;
import com.snooper.dto.Plateau;
import com.snooper.dto.RoboticRover;
import com.snooper.exception.OutOfBoundaryException;

import java.util.List;

public interface PlateauNavigation {

    void handle(Plateau plateau, RoboticRover roboticRover, List<Action> actions) throws OutOfBoundaryException;
}
