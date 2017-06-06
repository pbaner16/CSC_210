/*
 * File: NestedBMI
 * By: Poulomi Banerjee
 * Date: October 2, 2016
 * 
 * Description: To create a program that would print a table of BMIs based off of 
 * the heights and weights entered, ranging from low height to high height (inclusive),
 * at increments of 3 inches, and for each height, from low weight to high weight
 * (inclusive), at increments of 10 inches.
 */
import java.util.Scanner;

/**
 *
 * @author poulomibanerjee
 */
public class NestedBMI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);

        System.out.print("Enter low height in feet: "); 
        // ask user to enter low height
        int lowHeight = in.nextInt();
        System.out.print("Enter high height in feet: "); 
        // ask user to enter high height
        int highHeight = in.nextInt();

        System.out.print("Enter the low weight in pounds: "); 
        // ask user to enter low weight
        int lowWeight = in.nextInt();

        System.out.print("Enter the high weight in pounds: "); 
        // ask user to enter high weight
        int highWeight = in.nextInt();

        System.out.print("Height: "); // create a "Height" column
        System.out.print("\tWeight: "); // create a "Weight" column
        System.out.print("\tBMI: \n"); // create a "BMI" column
        int feet = (12 * lowHeight); //how to calculate feet in inches

        int inch; // declare inch variable before starting the loop
        float bmi; // declare BMI variable before starting the loop

        if (lowHeight > 0 && highHeight > 0 && lowWeight > 0 && highWeight > 0)
        // if everything (all input) is positive, execute the loop
        {
            for (feet = lowHeight; feet <= highHeight; feet++)
            //outer loop runs the feet input for lowHeight
            {

                for (inch = 0; inch <= 9; inch = inch + 3) 
                //middle loop increments inches by 3
                {
                    System.out.println();
                    if (inch == 3 && feet == highHeight) 
                    //loop goes up until highHeight 
                    {
                        break;
                    }
                    for (int weight = lowWeight; weight <= highWeight; weight = weight + 10)
                    // for loop with increment of 10 was used above - innermost for loop    
                    {
                        // 4.88 is the constant used on feet!
                        bmi = 4.88f * (weight) / (feet * feet); // calculates BMI
                        System.out.print(feet + " " + inch);//prints height in feet and inches
                        System.out.print("\t\t " + weight);// prints weight
                        System.out.print("\t\t");
                        System.out.printf("%.4f", bmi);
                        /*
                         * NOTES:
                         * --prints out BMI for all in-between weights in 
                         * increments of 10
                         * --printf gives the proper decimal values for output
                         */

                        if (bmi > 25) // if BMI > 25, user is overweight
                        {
                            System.out.println("\t\t  overweight");
                        } 
                        else // if BMI < 25, user isn't overweight
                        {
                            System.out.println("\t\t  not overweight");
                        }

                    }

                }

            }
        }
        else 
        {
            System.out.println("Error: Negative values are not accepted.");
            // if input is negative, print error message
        }

    }

}
