package com.innumeracy.examples;

import java.util.Scanner;

import com.innumeracy.api.Mth;

public class SurdifyExample {
	public SurdifyExample() {
		receiveInput();
	}

	private void receiveInput() {
		System.out.println("_________________________________________________");
		System.out
				.println("Enter the surd you want to be surdified (root is implied).");
		Scanner sc = new Scanner(System.in);
		int surd = sc.nextInt();
		sc.close();
		System.out.println("__________________CALCULATING____________________");
		displayResult(surd);
	}

	private void displayResult(int surd) {
		System.out.println("Result: " + calculateResult(surd));
	}

	private String calculateResult(int surd) {
		int[] factorsOfSurd = Mth.factorsOf(surd);
		int squareNumber = 0;
		int thatOtherNumber = 0;
		for (int i = factorsOfSurd.length - 1; i >= 0; i--) {
			if (Mth.isSquare(factorsOfSurd[i])) {
				squareNumber = factorsOfSurd[i];
				thatOtherNumber = surd / squareNumber;
				break;
			}
		}
		StringBuilder surdBuilder = new StringBuilder();

		if (squareNumber != 0) {
			squareNumber = (int) Math.sqrt(squareNumber);
			
			if(squareNumber != 0){
				surdBuilder.append(squareNumber);
			}
			if (thatOtherNumber != 1) {
				surdBuilder.append("(square root)");
				surdBuilder.append(thatOtherNumber);
			}
		} else {
			surdBuilder.append("(square root)");
			surdBuilder.append(surd);
		}
		return surdBuilder.toString();
	}
}
