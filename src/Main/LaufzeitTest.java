package Main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LaufzeitTest {
	
	private static int intervallRange = 50;
	private static int amountIntervalls = 100000;

	public static void main(String[] args) {
		
		
		String input = getRandomIntervalls(amountIntervalls);
		
		long startTime = System.currentTimeMillis();
//		
		for (int i = 0; i < 1000; i++) {
			
			List<Intervall> intervalls = IntervallTools.createIntervallsFromString(input);
			List<Intervall> result = IntervallTools.mergeIntervalls(intervalls);
			
//			List<Intervall> result = IntervallTools.mergeIntervalls(getRandomIntervallsWithoutStrings(amountIntervalls));
			
		}
		
		
		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime)/1000 + " ms ");


	}
	
	public static int getRandomBeginIntervall(int min) {
	    return (int) ((Math.random() * ( (Integer.MAX_VALUE - intervallRange) - min)) + min);
	}
	
	public static int getRandomEndIntervall(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}
	
	
	public static String getRandomIntervalls(int amount) {
		String result = "";
		
		for(int i = 0; i<amount;i++) {
			
			int randomBegin = getRandomBeginIntervall(1);
			int randomEnd = getRandomEndIntervall(randomBegin, randomBegin + intervallRange);
			
			result += "["+ randomBegin + "," + randomEnd + "]";
			
		}
		
		
		return result;
	}
	
	public static List<Intervall> getRandomIntervallsWithoutStrings(int amount){
		
		List<Intervall> list = new ArrayList<Intervall>();
		
		for (int i = 0; i < amount; i++) {
			
			int randomBegin = getRandomBeginIntervall(1);
			int randomEnd = getRandomEndIntervall(randomBegin, randomBegin + intervallRange);
			
			list.add(new Intervall(randomBegin,randomEnd ));
			
		}
		
		return list;
		
	}
	
}
