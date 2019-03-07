package picoYPlaca;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class getPlateTest {

	@Test
	void test() {
		int output = picoPlacaTest.getPlate(2448); //takes the last digit -> 8
		assertEquals(8, output);
	}

}