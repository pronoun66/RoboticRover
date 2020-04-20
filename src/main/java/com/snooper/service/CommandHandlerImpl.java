package com.snooper.service;

import com.snooper.constant.Action;
import com.snooper.constant.Direction;
import com.snooper.dto.Coordinate;
import com.snooper.dto.Plateau;
import com.snooper.dto.RoboticRover;

import java.util.ArrayList;
import java.util.List;

public class CommandHandlerImpl implements CommandHandler {
    @Override
    public Plateau parsePlateau(String command) {
        if (command == null) {
            throw new IllegalArgumentException("Invalid command for plateau coordinates");
        }

        String[] strings = command.split(" ");

        if (strings.length != 2) {
            throw new IllegalArgumentException("Invalid command for plateau coordinates");
        }

        int maxX = Integer.valueOf(strings[0]);
        int maxY = Integer.valueOf(strings[1]);
        return new Plateau(0, 0, maxX, maxY);
    }

    @Override
    public RoboticRover parseRoboticRover(String command) {
        if (command == null) {
            throw new IllegalArgumentException("Invalid command for roboticRover coordinates");
        }

        String[] strings = command.split(" ");

        if (strings.length != 3) {
            throw new IllegalArgumentException("Invalid command for roboticRover coordinates");
        }

        int x = Integer.valueOf(strings[0]);
        int y = Integer.valueOf(strings[1]);
        Direction direction = Direction.valueOf(strings[2]);

        return new RoboticRover(new Coordinate(x, y), direction);
    }

    @Override
    public List<Action> parseActions(String command) {
        if (command == null) {
            throw new IllegalArgumentException("Invalid command for actions");
        }

        List<Action> actions = new ArrayList<>();
        for (String s: command.split("")) {
            actions.add(Action.valueOf(s));
        }

        return actions;
    }
}
