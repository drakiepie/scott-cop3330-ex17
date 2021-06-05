package org.example;
import java.util.Scanner;

/*
 *  UCF COP3330 Summer 2021 Exercise 17 Solution
 *  Copyright 2021 Drake Scott
 */

public class exercise17 {

    static Scanner input = new Scanner(System.in);

    //method to calculate bac using the given formula.
    public static double bacCalc(double numDrinks, double W, double gender, double hoursSince){
        double r = (gender==1)?0.73:0.66;
        return (numDrinks * 5.14 / W * r) - 0.015 * hoursSince;
    }

    //method to prevent user from entering non-numeric values.
    public static double numericInputOnly(){
        while(true){
            try {
                return Double.parseDouble(input.nextLine());
            }
            catch(NumberFormatException e){
                System.out.print("Invalid input, please enter a number: ");
            }
        }
    }

    public static void main(String[] args){

        System.out.print("Enter your weight in pounds: ");
        double weight = numericInputOnly();

        System.out.print("Enter your gender (1 for male, 2 for female): ");
        double gender = numericInputOnly();
        while((gender != 1) && (gender != 2)){
            System.out.print("Invalid gender selection. Enter 1 for male, 2 for female: ");
            gender = input.nextDouble();
        }

        System.out.print("How much alcohol have you consumed? (in ounces)");
        double numDrinks = numericInputOnly();

        System.out.print("How many hours ago was your last drink? ");
        double hoursSince = numericInputOnly();

        double yourBAC = bacCalc(numDrinks, weight, gender, hoursSince);

        System.out.println("Your BAC is " + yourBAC + ".");

        String condition = (yourBAC <= 0.08)?"":"not ";
        String outputString = "it is " + condition + "legal for you to drive.";

        System.out.println(outputString);
    }
}
