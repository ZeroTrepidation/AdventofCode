package day5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class day5tests {
	
	String buffer;

	@BeforeEach
	void setUp() throws Exception {
		buffer = "BFFFBBFRRR";
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	

	@Test
	void test() {
		
		String assertionError = null;
		
		try {
			assertEquals(70, d5part1.binaryPartition(buffer.toCharArray(), 0, 128, 127, 0));
        }
        catch (AssertionError ae) {
            assertionError = ae.toString();
        }
        System.out.println(assertionError);
	}

}
