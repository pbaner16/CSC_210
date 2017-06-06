/*
 * File: FindPeaks
 * By: Poulomi Banerjee
 * Date: October 25, 2016
 * 
 * Description: To write a program that scans through an array of data, 
 * finds the peaks based on the criterion defined above, and sorts them 
 * into non-descending order.
 *
 */

/**
 *
 * @author poulomibanerjee
 */
public class FindPeaks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        float [] x = {0.2f, 0.5f, 0.1f, 0.15f, 0.2f, 0.13f, 0.3f, 0.25f, 0.3f, 0.3f, 
                        0.7f, 0.2f, 0.45f, 0.15f, 0.2f, 0.85f, 0.3f, 0.65f, 0.2f, 0.1f};
        float [] peaks = new float[x.length];//declare and intialize peaks array to store values in later code
        int j = 0;//initialize variable to be number of peaks[]
        
        System.out.println("Data array: ");

        for (int i = 0; i <x.length; i++)
        {
             System.out.print(x[i] + "00\t");
             
             if (i == 9) // separates first set of numbers to second set of numbers
             {
                 System.out.println();
             }    
            
        }

        System.out.println("\n");

        System.out.println("5 peaks found:");

        for (int i = 1; i < x.length - 1; i++) //initializing i to 1, i has to be less than the length of the array, update i (post increment)
        {
            if ((x[i] > (2 * x[i-1])) && (x[i] > (2 * x[i+1]))) // basically calculating peaks
            {  
                j++; //increasing integer inside array by 1
                j = i;
                peaks [j] = x[i]; // x[i] represents peaks[i]
                System.out.println(peaks[j]);
            }
        }
        
        //EXTRA CREDIT SECTION ON THE BOTTOM: SORTED PEAKS
        
        System.out.println("\nSorted peaks: ");
        
        for (int i = 0; i < j; i++)
        {
            int index = 0;
            if (peaks[i] < peaks[i+1] && index < (i+1))
            {
                index = i+1;
                x[i] = peaks[i];
                peaks[index] = peaks [i+1];
                System.out.println(peaks[index]);
            }
        } 
    } 
}      
    
 