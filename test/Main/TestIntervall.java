package Main;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestIntervall {
	
	private List<Intervall> intervalls = new ArrayList<Intervall>();
	
	Intervall int0;
	Intervall int1;
	Intervall int2;
	Intervall int3;
	
	@BeforeEach
	public void setup() {

		int0 = new Intervall(1,5);
		int1 = new Intervall(7,12);
		int2 = new Intervall(9,15);
		int3 = new Intervall(2,6);
		
		intervalls.add(int0);
		intervalls.add(int1);
		intervalls.add(int2);
		intervalls.add(int3);
	
	}
	

	@Test
	public void testComperator() {
	
		IntervallComperator comp = new IntervallComperator();
		
		int compare = comp.compare(intervalls.get(0), intervalls.get(1));
		
		assertEquals(-1, compare, "comperator is not correct");
		
		compare = comp.compare(intervalls.get(0), intervalls.get(0));
		
		assertEquals(0, compare, "comperator is not correct");
		
		compare = comp.compare(intervalls.get(2), intervalls.get(1));
		
		assertEquals(1, compare, "comperator is not correct");
	}
	
	
	@Test
	public void testCreateIntervallsFromString() {
		
		String testString = "[2,6][3,8][2,3][12,34]";
		
		List<Intervall> result = IntervallTools.createIntervallsFromString(testString);
		
		assertEquals(4, result.size());
		assertEquals(result.get(0).getClass(), Intervall.class);
		
	}
	
	@Test
	public void testCreateIntervallsFromStringWrongInput() {		
		String testString = "";
		Exception except = assertThrows(IllegalArgumentException.class, () -> IntervallTools.createIntervallsFromString(testString));
		assertEquals("Input has wrong format. Please use a format like that '[1,2][2,3][3,4]'", except.getMessage());
		
	}
	
	@Test
	public void testCreateIntervallsFromStringWrongValueOrder() {		
		String testString = "[2,1]";
		Exception except = assertThrows(IllegalArgumentException.class, () -> IntervallTools.createIntervallsFromString(testString));
		assertEquals("values of Intervall is in wrong order: [2,1]", except.getMessage());
		
	}
	
	@Test
	public void testMergeIntervalls() {
		
		List<Intervall> list = new ArrayList<Intervall>();
		list.add(int0);
		list.add(int3);
		
		List<Intervall> listResult = IntervallTools.mergeIntervalls(list); 
		
		assertEquals(listResult.size(), 1, "merge did not work, to many items");
		assertEquals(listResult.get(0).getBegin(), 1, "start of intervall did not work" );
		assertEquals(listResult.get(0).getEnd(), 6, "end of intervall did not work" );
		
		List<Intervall> list2 = new ArrayList<Intervall>();
		list2.add(int0);
		list2.add(int2);
		
		List<Intervall> listResult2 = IntervallTools.mergeIntervalls(list2); 
		
		assertEquals(2, listResult2.size(), "Intervalls shoudn't be merges");
		assertEquals(1, listResult2.get(0).getBegin(), "intervall shoudn't be changed" );
		assertEquals(5, listResult2.get(0).getEnd(), "intervall shoudn't be changed" );
		assertEquals(9, listResult2.get(1).getBegin(), "intervall shoudn't be changed" );
		assertEquals(15, listResult2.get(1).getEnd(), "intervall shoudn't be changed" );
	}


}
