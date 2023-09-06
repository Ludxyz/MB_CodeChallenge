package Main;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IntervallTools {

	
	public static List<Intervall> createIntervallsFromString (String input) {
		
		List<Intervall> intervalls = new ArrayList<>();
		
		Pattern pattern = Pattern.compile("\\[(.*?)\\]");
		Matcher matcher = pattern.matcher(input);
		
		if(!input.matches("\\[(.*?)\\]")) {
			throw new IllegalArgumentException("Input has wrong format. Please use '[1,2][2,3][3,4]'");
		}
		
		while( matcher.find() ) {
			intervalls.add(new Intervall( matcher.group(1) ));
		}
		
		return intervalls;

	}
	
	
	public static List<Intervall> mergeIntervalls(List<Intervall> list) {
		
		list.sort(new IntervallComperator());
		
		Deque<Intervall> stack = new ArrayDeque<Intervall>();	
		
		for(Intervall intervallNew : list) {
			
			if (stack.isEmpty()) {
				stack.push(intervallNew);
				continue;
			}

			Intervall oldIntervall = stack.pop();

			
			if(oldIntervall.getEnd() < intervallNew.getBegin()) {
				stack.push(oldIntervall);
				stack.push(intervallNew);
				continue;
			}
			
			int newBegin;
			int newEnd;
			

			if (oldIntervall.getBegin() > intervallNew.getBegin()) {
				newBegin = intervallNew.getBegin();
			} else {
				newBegin = oldIntervall.getBegin();
			}

			if (oldIntervall.getEnd() < intervallNew.getEnd()) {
				newEnd = intervallNew.getEnd();
			} else {
				newEnd = oldIntervall.getEnd();
			}
			
			stack.push(new Intervall(newBegin, newEnd));
			
		}
		
		return stack.stream().sorted(new IntervallComperator()).toList();
		
		
	}
	
}
