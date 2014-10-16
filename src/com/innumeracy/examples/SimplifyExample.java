package com.innumeracy.examples;

import java.util.Scanner;

import com.innumeracy.api.Mth;

public class SimplifyExample {
	public SimplifyExample() {
		receiveInput();
	}

	private void receiveInput() {
		System.out.println("_________________________________________________");
		System.out.println("Enter the fraction you want simplified.");
		Scanner sc = new Scanner(System.in);
		String fraction = sc.nextLine();
		sc.close();
		System.out.println("__________________CALCULATING____________________");
		displayResult(fraction);
	}
	
	private void displayResult(String fraction){
		System.out.println("Result: " + calculateResult(fraction));
	}
	
	private String calculateResult(String fraction){
		return Mth.simplifyFraction(fraction);
	}
}
