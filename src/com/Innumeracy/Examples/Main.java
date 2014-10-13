package com.innumeracy.examples;
import java.util.Scanner;

import com.innumeracy.api.Mth;


public class Main {
	public static void main(String[] args){
		System.out.println("_________________________________________________");
		System.out.println("Welcome to the Innumeracy Math Library for Java demo!");
		System.out.println("Choose from 1 of the following options:");
		System.out.println("_________________________________________________");
		System.out.println("A: Rounding to n decimal places");
		System.out.println("B: Simplify surds (Surdify)");
		System.out.println("C: Simplify fractions");
		System.out.println("_________________________________________________");
		
		long start = System.currentTimeMillis();
		//System.out.println(Mth.isPrime(2));
		System.out.println(Mth.roundToDecimalPlaces(10.1, 2));
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		
		Scanner sc = new Scanner(System.in);
		switch(sc.nextLine().toLowerCase()){
		case "a":
			new RoundingExample();
			break;
		case "b":
			new SurdifyExample();
			break;
		case "c":
			new SimplifyExample();
			break;
		}
		sc.close();
	}
}
