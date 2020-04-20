/*
 * Copyright 2015-2018 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package com.snooper;

import com.snooper.constant.Action;
import com.snooper.constant.Direction;
import com.snooper.dto.Coordinate;
import com.snooper.dto.RoboticRover;
import com.snooper.service.RoboticRoverActionImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationIntTests {

	Application application = new Application();

	@Test
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
}
