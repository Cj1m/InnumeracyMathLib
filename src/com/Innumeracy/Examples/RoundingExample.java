package com.Innumeracy.Examples;

import java.util.Scanner;

import com.Innumeracy.API.Mth;

public class RoundingExample {
	public RoundingExample(){
		receiveInput();
	}
	
	@SuppressWarnings("resource")
	private void receiveInput(){
		System.out.println("_________________________________________________");
		System.out.println("Enter the number you want to be rounded (must be a decimal number).");
		double numberToRound = new Scanner(System.in).nextDouble();
		System.out.println("Now enter the number of decimal places you want the number to be rounded to.");
		int dps = new Scanner(System.in).nextInt();
		System.out.println("__________________CALCULATING____________________");
		displayResult(numberToRound, dps);
	}
	
	private void displayResult(double i, int n){
		double answer = Mth.roundToDecimalPlaces(i, n);
		System.out.println(i +" to " + n + " decimal place(s) = "+ answer);
	}
	
}
