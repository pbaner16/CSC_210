/*
 * File: BMI Project
 * By:Poulomi Banerjee
 * Date: September 13, 2016
 * 
 * Description: The purpose of this project is to create a program in which the 
 * computer can calculate a person's BMI just by inputting their weight and height.
 */
import java.util.Scanner;
/**
 *
 * @author poulomibanerjee
 */
public class Bmi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* 
         * insert Scanner object so that there is a user input whenever
         * users NEED to input something
         */
        Scanner in = new Scanner (System.in);
        
        // Ask user to input height in feet and inches
        System.out.println("Please enter height in feet and inches:");
        int height; // the height of the user
        int feet = in.nextInt(); // height is broken down into feet and
        int inch = in.nextInt(); // height is broken down into inches
        height = (12 * feet) + inch; // computes height in feet and inches                             
                                     
        // Ask user to input weight in pounds
        System.out.println("Please enter weight in pounds:");
        int weight = in.nextInt(); // User inputs weight in pounds   
        
        // Calculate and print BMI
        float bmi = 703f * (weight)/(height * height); // this line calculates BMI
        // Note: The 'f' after 703 indicates that 703 is a float number
        System.out.println("BMI = " + bmi); // this line prints BMI on console
        
        // Remember: If BMI is greater than 25, you are considered overweight!
        if (bmi > 25) // reads: "If BMI is over 25..."
        {    
            System.out.println("You are overweight."); // "Then you are overweight"
        } 
        else // reads: "Otherwise, if BMI is less than 25..."
        {
            System.out.println("You are not overweight."); // "Then you aren't overweight"
        } 
    }
    
}
