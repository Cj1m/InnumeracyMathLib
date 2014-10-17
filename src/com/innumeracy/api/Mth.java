package com.innumeracy.api;

import java.math.BigInteger;
import java.util.ArrayList;

public class Mth {
	// Booleans
	/**
	 * @param number
	 *            CShecked for being palindromic (looking the same when written
	 *            backwards). Examples of palindromes are 101 or 234432.
	 * @return true if number is palindromic, false otherwise.
	 */
	public static boolean isPalindromic(int number) {
		String reversed = new StringBuilder(Integer.toString(number)).reverse()
				.toString();
		String normal = Integer.toString(number);
		return normal.equals(reversed);
	}

	/**
	 * @param number
	 *            Checked for being prime (only divisible by itself and 1).
	 * @return true if number is prime, false otherwise.
	 */
	public static boolean isPrime(int number) {
		if (number < 0) {
			throw new IllegalArgumentException("Error: int cannot be < 0!");
		}
		int sqrt = (int) (Math.sqrt(number) + 1);

		if (number == 2) {
			return true;
		}
		if (number == 1) {
			return false;
		}
		for (int j = 2; j <= sqrt; j += 1) {
			if (number % j == 0) {
				return false;
			}
		}

		return true;
	}

	/**
	 * @param number
	 *            Checked for being square (a product of a number multiplied by
	 *            itself).
	 * @return true if number is square, false otherwise.
	 */
	public static boolean isSquare(int number) {
		if (number < 0) {
			throw new IllegalArgumentException("Error: int cannot be < 0!");
		}

		if (Math.sqrt(number) % 1 == 0) {
			return true;
		}

		return false;
	}

	// Doubles
	/**
	 * @param number
	 *            the decimal number which is rounded to 'decimalPlaces' amount
	 *            of decimal places.
	 * @param decimalPlaces
	 *            the number of decimal places 'number' is rounded to.
	 * @return the rounded decimal number.
	 */
	public static double roundToDecimalPlaces(double number, int decimalPlaces) {
		if (decimalPlaces < 0) {
			throw new IllegalArgumentException("Error: int cannot be < 0!");
		}
		double roundedNumber = (double) Math.round(number
				* power(10, decimalPlaces))
				/ power(10, decimalPlaces);
		return roundedNumber;
	}

	/**
	 * @param number
	 *            the base in the Exponentiation operation.
	 * @param power
	 *            the mantissa in the Exponentiation operation.
	 * @return 'number' * 'number' 'power' amount of times.
	 */
	public static double power(double number, int power) {
		if (power < 0) {
			throw new IllegalArgumentException("Error: int cannot be < 0!");
		}
		double answer = 1;
		for (int j = 0; j < power; j++) {
			answer *= number;
		}
		return answer;
	}

	// Ints
	/**
	 * @param number
	 *            the number whose factors are desired.
	 * @return int[] of all the factors of 'number'.
	 */
	public static int[] factorsOf(int number) {
		if (number < 0) {
			throw new IllegalArgumentException("Error: int cannot be < 0!");
		}

		int half = Math.round(number / 2);
		ArrayList<Integer> factorsList = new ArrayList<Integer>();
		for (int j = 1; j <= half; j++) {
			if (number % j == 0) {
				factorsList.add(j);
			}
		}
		factorsList.add(number);
		int[] factors = new int[factorsList.size()];
		for (int k = 0; k < factorsList.size(); k++)
			factors[k] = factorsList.get(k);
		return factors;
	}

	/**
	 * @param number1
	 *            the first number.
	 * @param number2
	 *            the second number.
	 * @return the Greatest Common Divisor of both 'number1' and 'number2' using
	 *         Euclid's algorithm.
	 */
	public static int gcd(int number1, int number2) {
		if (number1 < 0 || number2 < 0) {
			throw new IllegalArgumentException("Error: int cannot be < 0!");
		}

		if (number2 == 0) {
			return number1;
		}

		return gcd(number2, number1 % number2);
	}

	/**
	 * @param number1
	 *            the first number.
	 * @param number2
	 *            the second number.
	 * @return the lowest common multiple of both 'number1' and 'number2'.
	 */
	public static int lcm(int number1, int number2) {
		return number1 * (number2 / gcd(number1, number2));
	}

	/**
	 * @param number
	 *            whose digits are counted.
	 * @return the number of digits in the number E.g 3.14 = 3 digits (3,1 and
	 *         4).
	 */
	public static int getNumberOfDigits(double number) {
		String digits = Double.toString(number);
		if (digits.endsWith(".0")) {
			digits = digits.substring(0, digits.length() - 2);
		} else {
			digits = digits.replace(".", "");
		}
		return digits.length();
	}

	/**
	 * @param number
	 *            the number to calculate the factorial of (double)
	 * @return the factorial of number (double)
	 */
	public static double factorial(double number) {
		if (number - 1 == 1) {
			return number;
		}

		return number * factorial(number - 1);
	}
	
	/**
	 * @param number
	 *            the number to calculate the factorial of (BigInteger)
	 * @return the factorial of number (BigInteger)
	 */
	public static BigInteger factorial(BigInteger number) {
		if (number.equals(BigInteger.valueOf(2))) {
			return number;
		}

		return number.multiply(factorial(number.subtract(BigInteger.valueOf(1))));
	}

	
	// String
	/**
	 * @param fraction
	 *            which to be 'simplified'
	 * @return 'simplified' fraction as a String E.g "2/4" = "1/2"
	 */
	public static String simplifyFraction(String fraction) {
		String[] parts = fraction.split("/");
		int partOne = Integer.parseInt(parts[0]);
		int partTwo = Integer.parseInt(parts[1]);

		int gcf = gcd(partOne, partTwo);
		StringBuilder fractionBuilder = new StringBuilder();
		String simplifiedPartOne = Integer.toString(partOne / gcf);
		String simplifiedPartTwo = Integer.toString(partTwo / gcf);
		fractionBuilder.append(simplifiedPartOne);
		fractionBuilder.append("/");
		fractionBuilder.append(simplifiedPartTwo);

		return fractionBuilder.toString();
	}
}
