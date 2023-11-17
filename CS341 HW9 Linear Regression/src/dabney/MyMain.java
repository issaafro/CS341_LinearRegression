package dabney;

import java.util.Arrays;

public class MyMain {

	static Integer[] hourData = {2, 3, 5, 7, 9, 11, 14};
	static Integer[] bugData = {4, 5, 7, 10, 15, 20, 30};

	public static void main(String[] args) {
		System.out.print("\n\n" + (int) predictForValue(13));
		System.out.println(" is the number of bugs predicted for 13 hours of code.");
	}


	private static double predictForValue(int predictForDependentVariable) {
		if (hourData.length != bugData.length)
		throw new IllegalStateException("Must have equivalent data point size");

		// TASK 1: VERIFY DATA
		Integer numberOfDataValues = hourData.length;
		System.out.println("Verify Task 1: \n\t hourData: " + Arrays.toString(hourData));
		System.out.println("\t bugData: " + Arrays.toString(bugData));

		// TASK 2: CREATE AN DOUBLE ARRAY TO HOLD HOURS SQUARED.
		Double[] hoursSquared = new Double[numberOfDataValues];
		for (int i = 0; i < numberOfDataValues; i++) {
			hoursSquared[i] = (double) (hourData[i] * hourData[i]);
		}
		System.out.println("Verify Task 2: hours squared: " + Arrays.toString(hoursSquared));

		// TASK 3: CREATE AN ARRAY TO HOLD THE HOURS MULTIPLIED BY THE BUGS
		Double[] hoursMultipliedByBugs = new Double[numberOfDataValues];
		for (int i = 0; i < numberOfDataValues; i++) {
			hoursMultipliedByBugs[i] = (double) (hourData[i] * bugData[i]);
		}
		System.out.println("Verify Task 3: hoursMultipliedBybugs = " + Arrays.toString(hoursMultipliedByBugs));



		// TASK 4: COMPUTE THE HOURS SUMMED AND THE BUGS SUMMED
		Double hoursSummed = 0.0;
		for (int i = 0; i < numberOfDataValues; i++) {
			hoursSummed += (double) hourData[i];
		}
		System.out.println("Verify Task 4a: hoursSummed = " + hoursSummed);
		Integer bugsSummed = 0;
		for (int i = 0; i < numberOfDataValues; i++) {
			bugsSummed += bugData[i];
		}
		System.out.println("Verify Task 4b: bugsSummed = " + bugsSummed);

		// TASK 5: COMPUTE THE SUM OF HOURS SQUARED
		Double sumOfHourSquared = 0.0;

		for (int i = 0; i < numberOfDataValues; i++) {
			sumOfHourSquared += (double) hoursSquared[i];
		}
		System.out.println("Verify Task 5: sumOfHourSquared = " + sumOfHourSquared);

		// TASK 6: COMPUTE THE SUM OF HOURS MULTIPLIED BY BUGS.
		Double sumOfHoursMultipliedByBugs = 0.0;
		for (int i = 0; i < numberOfDataValues; i++) {
			sumOfHoursMultipliedByBugs += hoursMultipliedByBugs[i];
		}
		System.out.println("Verify Task 6: sumOfHoursMultipliedByBugs = " + sumOfHoursMultipliedByBugs);

		// TASK 7: COMPUTE THE SLOPE  BEGIN BY COMPUTING THE SLOPE NOMINATOR AND
		// DENOMINATOR
		Double slopeNominator = numberOfDataValues * sumOfHoursMultipliedByBugs - bugsSummed * hoursSummed;
		Double slopeDenominator = numberOfDataValues * sumOfHoursMultipliedByBugs - Math.pow(hoursSummed, 2);
		Double slope = slopeNominator / slopeDenominator;
		System.out.println("Verify Task 7");
		System.out.println("\t slope Nominator: " + slopeNominator);
		System.out.println("\t slope Denominator: " + slopeDenominator);
		System.out.println("\t slope : " + slope);

		// TASK 8: COMPUTE THE INTERCEPT.
		//   BEGIN BY COMPUTING THE INTERCEPT NOMINATOR AND DENOMINATOR.
		double interceptNominator = bugsSummed - slope * hoursSummed;
		double interceptDenominator = numberOfDataValues;
		double intercept = interceptNominator / interceptDenominator;
		System.out.println("Verify Task 8");
		System.out.println("\t interceptNominator: " + interceptNominator);
		System.out.println("\t interceptDenominator: " + interceptDenominator);
		System.out.println("\t intercept : " + intercept);


		// TASK 9: COMPUTE AND RETURN THE PREDICTED NUMBER OF BUGS.
		double predictedBugs = (slope * predictForDependentVariable) + intercept;
		return predictedBugs;

	}

}
