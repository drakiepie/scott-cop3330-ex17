package org.example;
import java.util.Scanner;

/*
 *  UCF COP3330 Summer 2021 Exercise 17 Solution
 *  Copyright 2021 Drake Scott
 */

public class exercise17 {
    public static double bacCalc(int numDrinks, double W, int gender, double hoursSince){
        double r = (gender==1)?0.73:0.66;
        double BAC = (numDrinks * 5.14 / W * r) - 0.015 * hoursSince;
        return BAC;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your weight in pounds: ");
        double weight = input.nextDouble();

        System.out.print("Enter your gender (1 for male, 2 for female): ");
        int gender = input.nextInt();
        while((gender != 1) && (gender != 2)){
            System.out.print("Invalid gender selection. Enter 1 for male, 2 for female: ");
            gender = input.nextInt();
        }

        System.out.print("How much alcohol have you consumed? (in ounces)");
        int numDrinks = input.nextInt();
        System.out.print("How many hours ago was your last drink? ");
        double hoursSince = input.nextDouble();

        double yourBAC = bacCalc(numDrinks, weight, gender, hoursSince);

        System.out.println("Your BAC is " + yourBAC + ".");

        String condition = (yourBAC <= 0.08)?"":"not ";
        String outputString = "it is " + condition + "legal for you to drive.";

        System.out.println(outputString);
    }
}
