package com.snooper.service;

import com.snooper.constant.Action;
import com.snooper.constant.Direction;
import com.snooper.dto.Coordinate;
import com.snooper.dto.Plateau;
import com.snooper.dto.RoboticRover;
import com.snooper.exception.OutOfBoundaryException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PlateauNavigationImplTests {

	PlateauNavigationImpl plateauNavigationImpl = new PlateauNavigationImpl();

	@Test
	@DisplayName("plateauNavigationImpl happy path")
	void plateauNavigationImplHappyPath() {
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
	@DisplayName("plateauNavigationImpl should throw OutOfBoundaryException when robot is over plateau's boundary")
	void plateauNavigationShouldThrowOutOfBoundaryException() {
		Plateau plateau = new Plateau(0, 0, 1, 1);
		RoboticRover roboticRover = new RoboticRover(new Coordinate(0, 0), Direction.N);

		Exception exception = assertThrows(OutOfBoundaryException.class, () ->
				plateauNavigationImpl.handle(plateau, roboticRover, Arrays.asList(Action.M, Action.M)));

		assertTrue(exception.getMessage().contains("OutOfBoundaryException"));
	}
}
