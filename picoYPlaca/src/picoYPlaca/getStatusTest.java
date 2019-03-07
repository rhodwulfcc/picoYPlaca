package picoYPlaca;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class getStatusTest {

	@Test
	void test() {
		String output = picoPlacaTest.getStatus(5, 8, 21, 8); //Thursday, 8:21am, plate ends on 8
		assertEquals("Car can NOT be on the road", output); // -> has pico y placa
	}

}
