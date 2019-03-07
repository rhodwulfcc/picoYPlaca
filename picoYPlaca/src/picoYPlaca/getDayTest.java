package picoYPlaca;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class getDayTest {

	@Test
	void test() {
		int output = picoPlacaTest.getDay("7/3/2019"); //Thursday -> 5
		assertEquals(5, output);
	}

}
