package server;

import compare.GoalsTemperatureComparison;

public class Test {
	public static void main(String[] args) {
		GoalsTemperatureComparison gt = new GoalsTemperatureComparison();
		JsonFormatter format = new JsonFormatter();

		System.out.println(format.format(gt.getData()));
	}
}
