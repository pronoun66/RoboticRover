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
import com.snooper.dto.Coordinate;
import com.snooper.dto.Plateau;
import com.snooper.dto.RoboticRover;
import com.snooper.exception.OutOfBoundaryException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlateauNavigationImplTests {

	PlateauNavigationImpl plateauNavigationImpl = new PlateauNavigationImpl();

	@Test
	void plateauNavigationImplHappyCase() {
		Plateau plateau = new Plateau(0, 0, 5, 5);
		RoboticRover roboticRover = new RoboticRover(new Coordinate(0, 0), Direction.N);

		try {
			plateauNavigationImpl.handle(plateau, roboticRover, Arrays.asList(Action.M, Action.M));
		} catch (OutOfBoundaryException e) {
			e.printStackTrace();
		}

		assertEquals(0, roboticRover.getCoordinate().getX());
		assertEquals(2, roboticRover.getCoordinate().getY());
		assertEquals(Direction.N, roboticRover.getDirection());
	}

	@Test
	void plateauNavigationShouldThrowOutOfBoundaryException() {
		Plateau plateau = new Plateau(0, 0, 1, 1);
		RoboticRover roboticRover = new RoboticRover(new Coordinate(0, 0), Direction.N);

		Exception exception = assertThrows(OutOfBoundaryException.class, () ->
				plateauNavigationImpl.handle(plateau, roboticRover, Arrays.asList(Action.M, Action.M)));

		assertTrue(exception.getMessage().contains("OutOfBoundaryException"));
	}
}
