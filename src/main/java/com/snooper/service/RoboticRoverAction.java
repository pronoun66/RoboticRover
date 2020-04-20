package com.snooper.service;

import com.snooper.constant.Action;
import com.snooper.dto.RoboticRover;

public interface RoboticRoverAction {

    void act(RoboticRover roboticRover, Action action);
}
