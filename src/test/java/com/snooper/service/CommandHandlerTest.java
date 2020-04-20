package com.snooper.service;

import com.snooper.constant.Action;
import com.snooper.constant.Direction;
import com.snooper.dto.Plateau;
import com.snooper.dto.RoboticRover;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommandHandlerTest {

	private CommandHandlerImpl commandHandler = new CommandHandlerImpl();

	@Test
	@DisplayName("parsePlateau should return plateau")
	void parsePlateauShouldReturnPlateau() {
		Plateau plateau = commandHandler.parsePlateau("4 4");

		assertEquals(4, plateau.getMaxX());
		assertEquals(4, plateau.getMaxY());
		assertEquals(0, plateau.getMinY());
		assertEquals(0, plateau.getMinY());
	}

	@Test
	@DisplayName("parsePlateau should throw exception when command is incorrect")
	void parsePlateauShouldThrowError() {
		Exception exception = assertThrows(IllegalArgumentException.class, () ->
				commandHandler.parsePlateau("4"));

		assertEquals("Invalid command for plateau coordinates", exception.getMessage());
	}

	@Test
	@DisplayName("parsePlateau should throw exception when wrong coordinates format")
	void parsePlateauShouldThrowErrorWhenWrongCoordinatesFormat() {
		Exception exception = assertThrows(IllegalArgumentException.class, () ->
				commandHandler.parsePlateau("S 4"));

		assertEquals("Invalid plateau coordinates", exception.getMessage());
	}

	@Test
	@DisplayName("parsePlateau should throw exception when wrong minX and maxX")
	void parsePlateauShouldThrowErrorWhenWrongCoordinateX() {
		Exception exception = assertThrows(IllegalArgumentException.class, () ->
				commandHandler.parsePlateau("-1 1"));

		assertEquals("Invalid minX and maxX", exception.getMessage());
	}

	@Test
	@DisplayName("parsePlateau should throw exception when wrong minY and maxY")
	void parsePlateauShouldThrowErrorWhenWrongCoordinateY() {
		Exception exception = assertThrows(IllegalArgumentException.class, () ->
				commandHandler.parsePlateau("1 -1"));

		assertEquals("Invalid minY and maxY", exception.getMessage());
	}

	@Test
	@DisplayName("parseRoboticRover should return roboticRover")
	void parseRoboticRoverShouldReturnRoboticRover() {
		RoboticRover roboticRover = commandHandler.parseRoboticRover("4 4 N");

		assertEquals(4, roboticRover.getCoordinate().getX());
		assertEquals(4, roboticRover.getCoordinate().getY());
		assertEquals(Direction.valueOf("N"), roboticRover.getDirection());
	}

	@Test
	@DisplayName("parseRoboticRover should throw exception when command is missing direction")
	void parseRoboticRoverShouldThrowError() {
		Exception exception = assertThrows(IllegalArgumentException.class, () ->
				commandHandler.parseRoboticRover("4 4")
		);

		assertTrue(exception.getMessage().contains("roboticRover"));
	}

	@Test
	@DisplayName("parseRoboticRover should throw exception when command is using wrong direction")
	void parseRoboticRoverShouldThrowErrorWhenWrongDirection() {
		Exception exception = assertThrows(IllegalArgumentException.class, () ->
				commandHandler.parseRoboticRover("4 4 T")
		);

		assertTrue(exception.getMessage().contains("Invalid direction"));
	}

	@Test
	@DisplayName("parseRoboticRover should throw exception when command is using wrong x or y")
	void parseRoboticRoverShouldThrowErrorWhenWrongCoordination() {
		Exception exception = assertThrows(IllegalArgumentException.class, () ->
				commandHandler.parseRoboticRover("S 4 T")
		);

		assertTrue(exception.getMessage().contains("Invalid roboticRover coordinates"));
	}

	@Test
	@DisplayName("parseActions should return actions")
	void parseActionsShouldReturnActions() {
		List<Action> actions = commandHandler.parseActions("LRM");

		List<Action> expectations = Arrays.asList(Action.L, Action.R, Action.M);
		for (int i = 0; i < actions.size(); i++) {
			assertEquals(expectations.get(i), actions.get(i));
		}
	}

	@Test
	@DisplayName("parseActions should throw error when command is null")
	void parseActionsShouldThrowError() {
		Exception exception = assertThrows(IllegalArgumentException.class, () ->
				commandHandler.parseActions(null)
		);
		assertTrue(exception.getMessage().contains("actions"));
	}

	@Test
	@DisplayName("parseActions should throw error when command is using wrong action")
	void parseActionsShouldThrowErrorWhenWrongAction() {
		Exception exception = assertThrows(IllegalArgumentException.class, () ->
				commandHandler.parseActions("T")
		);
		System.out.println("exception " + exception);
		assertTrue(exception.getMessage().contains("Invalid action"));
	}
}
