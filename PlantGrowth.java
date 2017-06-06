/*
 * File: PlantGrowth
 * By: Poulomi Banerjee
 * Date: October 13, 2016
 *
 * Description: To create a program to track the growth of a plant
 *
 */
import java.util.Scanner;
//import java.util.Arrays;
/**
 *
 * @author poulomibanerjee
 */
public class PlantGrowth {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner (System.in); // import Scanner object so we have user input
        final int NUMMONTHS = 12; // there are 12 months in a year, so use 12 as a constant
        int [] month = {0,1,2,3,4,5,6,7,8,9,10,11};// create an array and store values in it for months
        int [] avgTemp = {46,48,49,50,51,53,54,55,56,55,51,47}; // create another array for avg Temp (given to us by teacher)
        int [] avgRain = {5,3,3,1,1,0,0,0,0,1,3,4};// create another array for avg Rain (given to us by teacher)
        int [] newGrowth = new int [NUMMONTHS];//stating that newGrowth array has an index of 12
        
        System.out.println("Welcome to the 210 gardening planner!"); //tells the user what the program is
        System.out.print("Enter minimum temperature for plant: ");// asks user to input minimum temperature
        int minTemp = in.nextInt();
        System.out.print("Enter maximum temperature for plant: ");//asks user to input maximum temperature
        int maxTemp = in.nextInt();
        System.out.print("Enter minimum rainfall for plant: ");// asks user to input minimum rainfall
        int minRainFall = in.nextInt();
        System.out.println("Month \t\t Temp \t\t Rain \t\t Growth \t\t Plant Height");//makes columns of each category
        
        int height = 0;// create height variable and initialize it
        int maxHeight = 0; // initializing variable to find max height
        int maxMonth = 0; // initializing variable to find month for max height
        
        for (int i = 0; i < NUMMONTHS; i++) // number of iterations is 12 (0-11)
        {
            System.out.print(month[i]);// prints out month from 0-11
            System.out.print(" \t\t "); // gives space on the same line
            System.out.print(avgTemp[i]);// prints out value of each index for avgTemp array
            System.out.print(" \t\t ");// gives space on the same line
            System.out.print(avgRain[i]);// prints out value of each index for avgRain array
            
            if (avgTemp[i] < minTemp || avgTemp[i] > maxTemp)
            /* if value in avgTemp array is less than minTemp
             * or if value in avgTemp array is greater than maxTemp,
             */    
            {
                newGrowth[i] = -1; //print out value of index of newGrowth array as -1
            }    
            else //otherwise
            {
                newGrowth[i] = avgRain[i] - minRainFall; //the value of the index of newGrowth is avgRain - minRainFall
            }   
            
            System.out.print(" \t\t "); // gives space on the same line
            System.out.print(newGrowth[i]); // prints out value of the index of newGrowth
            System.out.print(" \t\t\t "); //gives space on the same line
            height = height + newGrowth[i]; // height value = old height + new height
            
            if (height < 0) //if height is negative
            {
                height = 0; //height is zero becasue height can't be negative
            }    
            
            System.out.print(height);// prints height
            System.out.println();// gives off space before iterating loop again
            
            if(maxHeight <height) //if maxHeight is less than height during each iteration
            {
                maxHeight = height;// maxHeight would be the newHeight (highest height)
                maxMonth = i; //maxMonth would be the month (iteration) of the highest height
            }  
            
            
        }
        System.out.println("Extra credit follows:");
        System.out.println("Max height= " + maxHeight + " at month " + maxMonth);   
        // prints out highest height and at which month
    }
}
