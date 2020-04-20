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

        int maxX = 0;
        int maxY = 0;
        
        try {
            maxX = Integer.valueOf(strings[0]);
            maxY = Integer.valueOf(strings[1]);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid plateau coordinates");
        }

        return new Plateau(0, 0, maxX, maxY);
    }

    @Override
    public RoboticRover parseRoboticRover(String command) {
        if (command == null) {
            throw new IllegalArgumentException("Invalid command for roboticRover");
        }

        String[] strings = command.split(" ");

        if (strings.length != 3) {
            throw new IllegalArgumentException("Invalid command for roboticRover");
        }

        int x;
        int y;

        try {
            x = Integer.valueOf(strings[0]);
            y = Integer.valueOf(strings[1]);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException("Invalid roboticRover coordinates");
        }

        Direction direction;
        try {
            direction = Direction.valueOf(strings[2]);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException("Invalid direction");
        }

        return new RoboticRover(new Coordinate(x, y), direction);
    }

    @Override
    public List<Action> parseActions(String command) {
        if (command == null) {
            throw new IllegalArgumentException("Invalid command for actions");
        }

        List<Action> actions = new ArrayList<>();
        for (String s: command.split("")) {
            try {
                Action action = Action.valueOf(s);
                actions.add(action);
            } catch (IllegalArgumentException exception) {
                throw new IllegalArgumentException("Invalid action");
            }
        }

        return actions;
    }
}
