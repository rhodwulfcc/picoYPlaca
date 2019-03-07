package picoYPlaca;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class getTimeTest {

	@Test
	void test() {
		int output[] = picoPlacaTest.getTime("8:21");
		assertArrayEquals(new int[] {8, 21}, output);
	}

}
