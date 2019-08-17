/*
 * Copyright 2015-2018 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTests {

	Calculator calculator = new Calculator();

	@Test
	@DisplayName("1 + 1 = 2")
	void addsTwoNumbers() {
		assertEquals(2, calculator.add(1, 1), "1 + 1 deveria ser igual a 2");
	}
	
	@Test
	@DisplayName("1 - 1 = 0")
	void subTwoNumbers(){
		assertEquals(0, calculator.sub(1, 1), "1 - 1 deveria ser igual a 0");
	}
	
	@Test
	@DisplayName("5 * 5 = 25")
	void multTwoNumbers(){
		assertEquals(25, calculator.mult(5, 5), "5 * 5 deveria ser igual a 25");
	}
	
	@Test
	@DisplayName("25 / 5 = 5")
	void divTwoNumbers(){
		assertEquals(5, calculator.div(25, 5), "25 / 5 deveria ser igual a 5");
		assertEquals(0, calculator.div(25, 0), "25 / 0 deveria retornar zero ou nulo");
	}

	@ParameterizedTest(name = "{0} + {1} = {2}")
	@CsvSource({
			"0,    1,   1",
			"1,    2,   3",
			"49,  51, 100",
			"1,  100, 101"
	})
	void add(int first, int second, int expectedResult) {
		Calculator calculator = new Calculator();
		assertEquals(expectedResult, calculator.add(first, second),
				() -> first + " + " + second + " should equal " + expectedResult);
	}
}
