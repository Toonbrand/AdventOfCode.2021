package main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class Day01_SonarSweep {


	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();

		File file = new File("src/main/day01_input.txt");
		int[] nrs = Arrays.stream(new String(Files.readAllBytes(file.toPath())).split("\r\n")).mapToInt(Integer::parseInt).toArray();

		int largerCount = 0;
		int last = Integer.MAX_VALUE;
		
		for (int nr : nrs) {
			if(nr > last) largerCount++;
			last = nr;
		}
		System.out.println("Part 1: " + largerCount);
		
		largerCount = 0;
		last = Integer.MAX_VALUE;

		for (int j = 0; j < nrs.length-2; j++) {
			int sum = nrs[j] + nrs[j+1] + nrs[j+2];
			if(sum > last) largerCount++;
			last = sum;
		}
		System.out.println("Part 2: " + largerCount);
		
		long stopTime = System.currentTimeMillis();
		System.out.println("\nExecution time: " + (stopTime - startTime) + "ms");
	}
}
