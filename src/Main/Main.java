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
		String s = br.readLine();

		List<Intervall> intervalls = IntervallTools.createIntervallsFromString(s);

		System.out.println();

		List<Intervall> result = IntervallTools.mergeIntervalls(intervalls);

		result.stream().forEach(x -> {
			System.out.print(x.toString());
		});

	}

}
