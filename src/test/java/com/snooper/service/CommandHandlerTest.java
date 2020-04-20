/*
 * Copyright 2015-2018 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package com.snooper.service;

import com.snooper.constant.Action;
import com.snooper.constant.Direction;
import com.snooper.dto.Plateau;
import com.snooper.dto.RoboticRover;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommandHandlerTest {

	private CommandHandlerImpl commandHandler = new CommandHandlerImpl();

	@Test
	void parsePlateauShouldReturnPlateau() {
		Plateau plateau = commandHandler.parsePlateau("4 4");

		assertEquals(4, plateau.getMaxX());
		assertEquals(4, plateau.getMaxY());
		assertEquals(0, plateau.getMinY());
		assertEquals(0, plateau.getMinY());
	}

	@Test
	void parsePlateauShouldThrowError() {
		Exception exception = assertThrows(IllegalArgumentException.class, () ->
				commandHandler.parsePlateau("4"));

		assertEquals("Invalid command for plateau coordinates", exception.getMessage());
	}

	@Test
	void parseRoboticRoverShouldReturnRoboticRover() {
		RoboticRover roboticRover = commandHandler.parseRoboticRover("4 4 N");

		assertEquals(4, roboticRover.getCoordinate().getX());
		assertEquals(4, roboticRover.getCoordinate().getY());
		assertEquals(Direction.valueOf("N"), roboticRover.getDirection());
	}

	@Test
	void parseRoboticRoverShouldThrowError() {
		Exception exception = assertThrows(IllegalArgumentException.class, () ->
				commandHandler.parseRoboticRover("4 4")
		);

		assertTrue(exception.getMessage().contains("roboticRover"));
	}

	@Test
	void parseActionsShouldReturnActions() {
		List<Action> actions = commandHandler.parseActions("LRM");

		List<Action> expectations = Arrays.asList(Action.L, Action.R, Action.M);
		for (int i = 0; i < actions.size(); i++) {
			assertEquals(expectations.get(i), actions.get(i));
		}
	}

	@Test
	void parseActionsShouldThrowError() {
		Exception exception = assertThrows(IllegalArgumentException.class, () ->
				commandHandler.parseActions(null)
		);
		assertTrue(exception.getMessage().contains("actions"));
	}
}
