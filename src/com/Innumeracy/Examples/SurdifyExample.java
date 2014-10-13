package com.Innumeracy.Examples;

import java.util.Scanner;

import com.Innumeracy.API.Mth;

public class SurdifyExample {
	public SurdifyExample() {
		receiveInput();
	}

	@SuppressWarnings("resource")
	private void receiveInput() {
		System.out.println("_________________________________________________");
		System.out
				.println("Enter the surd you want to be surdified (root is implied).");
		int surd = new Scanner(System.in).nextInt();
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
			squareNumber = (int) Mth.squarerroot(squareNumber);
			
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
