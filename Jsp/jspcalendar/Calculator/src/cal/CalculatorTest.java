package cal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	void test() {
		// fail("Not yet implemented");
		Calculator cal = new Calculator();
		
		assertEquals(6, cal.sum(2, 3));
		
	}

}
