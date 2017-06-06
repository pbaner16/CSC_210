/*
 * File: Vampire (Vampire Hunt Game)
 * By: Poulomi Banerjee
 * Date: 2 October 2016
 * 
 * Description: to write a program that simulates the operation of a Halloween
 * Vampire Hunt game. 
 */
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author poulomibanerjee
 */
public class Vampire {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner (System.in);
        Random rand = new Random();
        int randomX =  rand.nextInt(10); // computer is creating a random x-coordinate for victim
        int randomY =  rand.nextInt(10); // computer is creating a random y-coordinate for victim
        System.out.println("Welcome to the vampire hunt game!");
        System.out.print("Would you like to cheat? (1 for yes, 0 for no): ");
        int num = in.nextInt(2); // User inputs whether or not s/he wants to 
        if (num == 1) // if input value is 1, show location of victim
        {
            System.out.println(randomX + " " + randomY);
        }  
        if (num == 0) // if input value is 0, hide location of victim
        {
            int victimLocation = myRand(randomX,randomY);
        }    
        System.out.println("You start with 5 bloodpoints.\n");
        
        int bloodpoints = 5; // initialize bloodpoints
        int vampHuntLocation = rand.nextInt(2); // create variable for location of vampire
        while (bloodpoints > 0) // bloodpoints has to be greater than 0 in order for the game to keep going
        {
           //bloodpoints = 5; // bloodpoints is initialized to 5 
           System.out.print("Enter your target x and y-coordinates (both 0-9): ");
           int targetX = in.nextInt(10); // user is inserting x-coordinate for victim
           int targetY = in.nextInt(10); // user is inserting y-coordinate for victim
           System.out.println("You are " + findDistance(targetX, targetY, randomX, randomY) +
                                " units away from your victim.");
           
           if (findDistance(targetX, targetY, randomX, randomY) == 0.0) // if guessed location is same as victim location, break loop
           {
               System.out.println("You bit your victim! S/he is now a vampire.\n");
               break;
           }   
           
            switch (vampHuntLocation) 
            {
            // consequence of having a 1 in random digit generator
                case 1:
                    System.out.println("You were grazed by an arrow, oops.");
                    bloodpoints = bloodpoints - 1; // bloodpoints is decreased by 1
                    System.out.println("You have " + bloodpoints + " blood points left.\n");
                    break;
            // consequence of having a 2 in random digit generator
                case 2:
                    System.out.println("You were hit by an arrow, ouch.");
                    bloodpoints = bloodpoints - 2; // bloodpoints is decreased by 2
                    System.out.println("You have " + bloodpoints + " blood points left.\n");
                    break;
                default:
                    System.out.println("You have " + bloodpoints + " blood points left.\n");
                    break;
            }     
           
           if (bloodpoints == 0) // if bloodpoints is 0, break loop
           {
               System.out.println("Sorry, you were shot too many times; game over\n");
               break;
           }    
        }    
    }
    
    public static int myRand (int low, int high) // method to create location for the victim
    {
        return low + (int) ((high - low + 1) * Math.random());
    }
    
    public static double findDistance (int x1, int y1, int x2, int y2) // method to find how many units victim is from vampire
    {
        return (int) Math.sqrt((Math.pow((x1 -x2), 2) + Math.pow((y1 - y2), 2)));
    }        
    
}
