/*
 * File: CA (Cellular Automation)
 * By: Poulomi Banerjee
 * Date: November 8, 2016
 *
 * Description: to create a cellular automation using arrays and making the values
 * of each index within the array either a 0 or 1 (depending on user)
 * 
 */
import java.util.Scanner;
/**
 *
 * @author poulomibanerjee
 */
public class CA {    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner (System.in);
        System.out.println("Welcome to the cellular automation simulation!");
        int numOfCells;
   
        System.out.print("Enter number of cells(<= 80): ");
        numOfCells = in.nextInt(); //prompt user to type the length of the cell array
        int [] cells = new int [numOfCells]; // creates array for cells and the size of the array
        if (numOfCells <= 80)
        {    
            System.out.print("Enter number of time steps: ");
            int timeSteps = in.nextInt(); //the amount of rows that are being displayed with #
            System.out.print("Enter the index of occupied cells (negative index to end): ");
            int indexPlural = 1;  
            
            while (indexPlural >= 0 ) // the index number user has inputted is greater than 0
            {
                indexPlural = in.nextInt(); 
                if (indexPlural >= 0) // if the number is negative, don't use it as an index to the array
                {
                    cells[indexPlural] = 1;
                } 
            }  
            
            for (int i = 0; i < numOfCells; i++)
            {
               System.out.print(i % 10); // printing numbers from 0-9 on a single line
            }
            System.out.println("");
            
            displayCells(cells); //displays initial time step
            
            for (int i = 0; i <= timeSteps; i++)
            {
                updateCells(cells); //displays #'s as well as updating the cells
                // *displayCells is called inside updateCells*
            }    
        }
    }
    
    public static void displayCells (int [] cells)
    {
        for (int i = 0; i < cells.length; i++)
        {
            if (cells[i] == 0) // if value is 0,
            {
                System.out.print(" "); // print space
            }    
            if (cells[i] == 1) // if value is 1,
            {
                System.out.print("#"); // print #
            }    
        }  
        System.out.println(); // entering a new line after displayCells is fully run
    } 
    
    public static void updateCells (int[] cells)
    {
       int index = 0;
       int [] temp = new int [cells.length]; // creating new array called temp and sizing it to cells array
       System.arraycopy(cells, 0, temp, 0, cells.length); //copy cells array into temp array
       
       for(int i = 1; i < cells.length - 1; i++)
       {
           index = i; 
           if (temp[i-1] == 1 && temp[i] == 1 && temp[i+1] == 1)
           {
               cells [i] = 0; //new cell is 0
           }   
           if (temp[i-1] == 1 && temp[i] == 1 && temp[i+1] == 0)
           {
               cells [i] = 1; //new cell is 1
           }  
           if (temp[i-1] == 1 && temp[i] == 0 && temp[i+1] == 1)
           {
               cells [i] = 1; //new cell is 1
           } 
           if (temp[i-1] == 1 && temp[i] == 0 && temp[i+1] == 0)
           {
               cells [i] = 0; //new cell is 0
           }
           if (temp[i-1] == 0 && temp[i] == 1 && temp[i+1] == 1)
           {
               cells [i] = 1; //new cell is 1
           }
           if (temp[i-1] == 0 && temp[i] == 1 && temp[i+1] == 0)
           {
               cells [i] = 1; //new cell is 1
           }    
           if (temp[i-1] == 0 && temp[i] == 0 && temp[i+1] == 1)
           {
               cells [i] = 1; //new cell is 1
           }
           if (temp[i-1] == 0 && temp[i] == 0 && temp[i+1] == 0)
           {
               cells [i] = 0; //new cell is 0
           }    
        }
        displayCells(cells); // calling displayCells inside updateCells so I can just call updateCells in main
    }        
    
}

