package com.snooper.service;

import com.snooper.constant.Action;
import com.snooper.dto.Plateau;
import com.snooper.dto.RoboticRover;

import java.util.List;

public interface CommandHandler {
    Plateau parsePlateau(String command);

    RoboticRover parseRoboticRover(String command);

    List<Action> parseActions(String command);
}
