package test_cases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import SortAlgo.ArraySort5MainImpl;

class Sort_test {

	@SuppressWarnings ("static-access")
	@Test
	void testWithGivenData() {
		ArraySort5MainImpl impl = new ArraySort5MainImpl();
		List<Integer> inputList = new ArrayList<Integer>(Arrays.asList(2, 9, 79, 16, 49, 65, 63, 99, 20, 35, 21, 56, 54, 88, 38, 77, 66, 12, 64, 90, 71, 81, 5, 50, 51));
		assertEquals(new ArrayList<>(Arrays.asList(99, 90, 88, 7)), impl.getMax3(inputList));
	}
	
	@SuppressWarnings ("static-access")
	@Test
	void test_RandomNumberFun() {
		ArraySort5MainImpl impl = new ArraySort5MainImpl();
		List<Integer> inputList = impl.getRamdomNumbers(0,100);
		int listSize = inputList.size();
		assertEquals(25, listSize);
	}
	
	
	@SuppressWarnings ("static-access")
	@Test
	void testWithRandomDataGetSORT5_calls() {
		ArraySort5MainImpl impl = new ArraySort5MainImpl();
		List<Integer> inputList = impl.getRamdomNumbers(0,100);
		int sortCalls = (impl.getMax3(inputList)).get(3);
		assertEquals(7, sortCalls);
	}
	
	

}
