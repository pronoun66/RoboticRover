package com.snooper.service;

import com.snooper.constant.Action;
import com.snooper.constant.Direction;
import com.snooper.dto.Coordinate;
import com.snooper.dto.RoboticRover;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoboticRoverActionImplTests {

	private RoboticRoverActionImpl roboticRoverAction = new RoboticRoverActionImpl();

	@ParameterizedTest(name = "{0} turns left should be {1}")
	@CsvSource({
			"E, N",
			"W, S",
			"N, W",
			"S, E"
	})
	void turnLeft(String before, String after) {
		int x = 1;
		int y = 1;

		RoboticRover roboticRover = new RoboticRover(new Coordinate(x, y), Direction.valueOf(before));
		roboticRoverAction.act(roboticRover, Action.L);
		assertEquals(x, roboticRover.getCoordinate().getX());
		assertEquals(y, roboticRover.getCoordinate().getY());
		assertEquals(Direction.valueOf(after), roboticRover.getDirection());
	}

	@ParameterizedTest(name = "{0} turns right should be {1}")
	@CsvSource({
			"E, S",
			"W, N",
			"N, E",
			"S, W"
	})
	void turnRight(String before, String after) {
		int x = 1;
		int y = 1;


		RoboticRover roboticRover = new RoboticRover(new Coordinate(x, y), Direction.valueOf(before));
		roboticRoverAction.act(roboticRover, Action.R);
		assertEquals(x, roboticRover.getCoordinate().getX());
		assertEquals(y, roboticRover.getCoordinate().getY());
		assertEquals(Direction.valueOf(after), roboticRover.getDirection());
	}

	@ParameterizedTest(name = "[{1}, {2}] move {0} should be [{3}, {4}]")
	@CsvSource({
			"E, 1, 1, 2, 1",
			"W, 1, 1, 0, 1",
			"N, 1, 1, 1, 2",
			"S, 1, 1, 1, 0"
	})
	void move(String direction, int beforeX, int beforeY, int afterX, int afterY) {
		Direction afterDirection = Direction.valueOf(direction);

		RoboticRover roboticRover = new RoboticRover(new Coordinate(beforeX, beforeY), Direction.valueOf(direction));
		roboticRoverAction.act(roboticRover, Action.M);
		assertEquals(afterX, roboticRover.getCoordinate().getX());
		assertEquals(afterY, roboticRover.getCoordinate().getY());
		assertEquals(afterDirection, roboticRover.getDirection());
	}
}
