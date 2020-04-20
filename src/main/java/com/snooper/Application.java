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

        List<String> results = new ArrayList<>();
        Plateau plateau = commandHandler.parsePlateau(commands[0]);

        for (int i = 1; i < commands.length; i += 2) {
            RoboticRover roboticRover = commandHandler.parseRoboticRover(commands[i]);
            List<Action> actions = commandHandler.parseActions(commands[i + 1]);

            try {
                plateauNavigation.handle(plateau, roboticRover, actions);
                int x = roboticRover.getCoordinate().getX();
                int y = roboticRover.getCoordinate().getY();
                String direction = roboticRover.getDirection().toString();
                results.add(x + " " + y + " " + direction);
            } catch (OutOfBoundaryException e) {
                results.add(e.getMessage());
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (String result: results) {
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
                + "MMRMMRMRRM"
        ));
    }
}
