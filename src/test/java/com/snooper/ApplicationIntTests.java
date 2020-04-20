package com.snooper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationIntTests {

	Application application = new Application();

	@Test
	@DisplayName("Application happy path")
	void applicationHappyPath() {
		String result = application.roboticRoverNavigatePlateau(
				"5 5\n"
						+ "1 2 N\n"
						+ "LMLMLMLMM\n"
						+ "3 3 E\n"
						+ "MMRMMRMRRM"
		);

		assertEquals("1 3 N\n5 1 E\n", result);
	}

	@Test
	@DisplayName("Application should throw OutOfBoundaryException")
	void applicationShouldReturnOutOfBoundaryException() {
		String result = application.roboticRoverNavigatePlateau(
				"5 5\n"
						+ "1 2 W\n"
						+ "MMMMM"
		);

		assertEquals("OutOfBoundaryException\n", result);
	}
}
