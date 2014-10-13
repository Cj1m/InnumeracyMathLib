package com.innumeracy.api;

import java.util.ArrayList;

public class Mth {
	//Booleans
	public static boolean isPalindromic(int a) {
		String reversed = new StringBuilder(Integer.toString(a)).reverse()
				.toString();
		String normal = Integer.toString(a);
		return normal.equals(reversed);
	}

	public static boolean isPrime(int i) {
		int half = Math.round(i / 2);
		for (int j = half; j >= 2; j--) {
			if (i % j == 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean isSquare(int i) {
		if (i % 2 != 0 && i != 1)
			return false;

		int half = i / 2;
		if (i == 1)
			half = 1;

		for (int j = 0; j <= half; j++) {
			if (j * j == i)
				return true;
		}
		return false;
	}
	
	
	//Doubles
	public static double roundToDecimalPlaces(double i, int n) {
		double roundedNumber = (double) Math.round(i * power(10, n))
				/ power(10, n);
		return roundedNumber;
	}

	public static double power(double i, int n) {
		double answer = 1;
		for (int j = 0; j < n; j++) {
			answer *= i;
		}
		return answer;
	}
	
	public static double squarerroot(double i){
		double half = i / 2;
		for(double j = half; j > 0; j-=0.01){
			j = Mth.roundToDecimalPlaces(j, 2);
			if(j*j==i){
				return j;
			}
		}
		return 0;
	}
	
	
	//Ints
	public static int[] factorsOf(int i) {
		int half = Math.round(i / 2);
		ArrayList<Integer> factorsList = new ArrayList<Integer>();
		for (int j = 1; j <= half; j++) {
			if (i % j == 0)
				factorsList.add(j);
		}
		factorsList.add(i);
		int[] factors = new int[factorsList.size()];
		for (int k = 0; k < factorsList.size(); k++)
			factors[k] = factorsList.get(k);
		return factors;
	}

	public static int hcf(int a, int b) {
		int[] factorsOfA = factorsOf(a);
		int[] factorsOfB = factorsOf(b);
		int hcf = 0;

		for (int i = factorsOfA.length - 1; i >= 0; i--) {
			for (int j = factorsOfB.length - 1; j >= 0; j--) {
				if (factorsOfA[i] == factorsOfB[j]) {
					hcf = factorsOfA[i];
					return hcf;
				}
			}
		}
		return hcf;
	}

	public static int lcm(int a, int b) {
		return a * (b / hcf(a, b));
	}

	public static int getDigits(double i) {
		String digits = Double.toString(i);
		if (digits.endsWith(".0")) {
			digits = digits.substring(0, digits.length() - 2);
		} else {
			digits = digits.replace(".", "");
		}
		return digits.length();
	}
	
	
	//String
	public static String simplifyFraction(String a) {
		String[] parts = a.split("/");
		int partOne = Integer.parseInt(parts[0]);
		int partTwo = Integer.parseInt(parts[1]);

		int hcf = hcf(partOne, partTwo);
		StringBuilder fractionBuilder = new StringBuilder();
		String simplifiedPartOne = Integer.toString(partOne / hcf);
		String simplifiedPartTwo = Integer.toString(partTwo / hcf);
		fractionBuilder.append(simplifiedPartOne);
		fractionBuilder.append("/");
		fractionBuilder.append(simplifiedPartTwo);

		return fractionBuilder.toString();
	}
}
