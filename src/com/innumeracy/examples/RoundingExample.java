package com.innumeracy.examples;

import java.util.Scanner;

import com.innumeracy.api.Mth;

public class RoundingExample {
	public RoundingExample(){
		receiveInput();
	}
	
	private void receiveInput(){
		System.out.println("_________________________________________________");
		System.out.println("Enter the number you want to be rounded (must be a decimal number).");
		Scanner sc = new Scanner(System.in);
		double numberToRound = sc.nextDouble();
		sc.close();
		System.out.println("Now enter the number of decimal places you want the number to be rounded to.");
		Scanner sc2 = new Scanner(System.in);
		int dps = sc2.nextInt();
		sc2.close();
		System.out.println("__________________CALCULATING____________________");
		displayResult(numberToRound, dps);
	}
	
	private void displayResult(double i, int n){
		double answer = Mth.roundToDecimalPlaces(i, n);
		System.out.println(i +" to " + n + " decimal place(s) = "+ answer);
	}
	
}
