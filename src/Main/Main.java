package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter comma separated list");
		String inputString = br.readLine();
		List<Intervall> result = null;

		try {
			
			List<Intervall> intervalls = IntervallTools.createIntervallsFromString(inputString);
			result = IntervallTools.mergeIntervalls(intervalls);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		};

		System.out.println("Result:");

		result.stream().forEach(x -> {
			System.out.print(x.toString());
		});

	}

}
