package com.Innumeracy.Examples;

import java.util.Scanner;

import com.Innumeracy.API.Mth;

public class SimplifyExample {
	public SimplifyExample() {
		receiveInput();
	}

	@SuppressWarnings("resource")
	private void receiveInput() {
		System.out.println("_________________________________________________");
		System.out.println("Enter the fraction you want simplified.");
		String fraction = new Scanner(System.in).nextLine();
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
