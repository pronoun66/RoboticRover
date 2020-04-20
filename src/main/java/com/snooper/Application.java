package com.snooper;

import com.snooper.constant.Action;
import com.snooper.dto.Plateau;
import com.snooper.dto.RoboticRover;
import com.snooper.exception.OutOfBoundaryException;
import com.snooper.service.CommandHandler;
import com.snooper.service.CommandHandlerImpl;
import com.snooper.service.PlateauNavigation;
import com.snooper.service.PlateauNavigationImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    PlateauNavigation plateauNavigation = new PlateauNavigationImpl();
    CommandHandler commandHandler = new CommandHandlerImpl();

    public String roboticRoverNavigatePlateau(String input) {
        String[] commands = input.split("\n");
        if (commands.length == 0) {
            throw new IllegalArgumentException("Null input");
        }

        if (commands.length % 2 == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        Plateau plateau = commandHandler.parsePlateau(commands[0]);

        // Each command set includes roboticRover and actions
        List<String[]> commandSets = new ArrayList<>();
        for (int i = 1; i < commands.length; i += 2) {
            String[] commandSet = new String[2];
            commandSet[0] = commands[i];
            commandSet[1] = commands[i + 1];
            commandSets.add(commandSet);
        }

        // parallel running commandSets
        List<String> results = commandSets.stream()
                .parallel()
                .map(commandSet -> {
                    RoboticRover roboticRover = commandHandler.parseRoboticRover(commandSet[0]);
                    List<Action> actions = commandHandler.parseActions(commandSet[1]);

                    try {
                        plateauNavigation.handle(plateau, roboticRover, actions);
                        int x = roboticRover.getCoordinate().getX();
                        int y = roboticRover.getCoordinate().getY();
                        String direction = roboticRover.getDirection().toString();
                        return x + " " + y + " " + direction;
                    } catch (OutOfBoundaryException e) {
                        return e.getMessage();
                    }
                })
                .collect(Collectors.toList());

        StringBuilder stringBuilder = new StringBuilder();
        for (String result : results) {
            stringBuilder.append(result + "\n");
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        Application application = new Application();
        System.out.println(application.roboticRoverNavigatePlateau(
                "5 5\n"
                        + "1 2 N\n"
                        + "LMLMLMLMM\n"
                        + "3 3 E\n"
                        + "MMRMMRMRRM\n"
                        + "0 0 S\n"
                        + "M\n"
                        + "1 1 W\n"
                        + "M\n"
                        + "2 2 N\n"
                        + "M"
        ));
    }
}
