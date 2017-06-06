/*
 * File: Life (Project 8)
 * By: Poulomi Banerjee
 * Date: November 17, 2016
 *
 * Description: to write a Java program that implements Conway’s Game of Life,
 * a simple cellular automaton discussed in class, by using two dimensional
 * arrays.
 */
import java.util.Scanner;
/**
 *
 * @author poulomibanerjee
 */
public class Life {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        int countStep = 1;
        System.out.println("Please enter list of (i,j) pairs for populated cells");
        System.out.println("(negative i or j to quit): ");
        int [][] coordinates = new int [10][10];
        int userCoordinatesX = in.nextInt(); // user input for first coordinate of array
        int userCoordinatesY = in.nextInt(); // user input for second coordinate of array
        
        while(userCoordinatesX >= 0 && userCoordinatesY >= 0){ // if coordinates are greater than 0...
            if(userCoordinatesX >= 0 && userCoordinatesY >= 0){ //if coordinates are greater than 1, it is considered an index of array
                coordinates[userCoordinatesX][userCoordinatesY]= 1;
            }
            //making sure that the loop iterates while coordinates are greater than 1
            userCoordinatesX = in.nextInt(); // each coordinate for X value is being accounted for as index of array
            userCoordinatesY = in.nextInt(); // each coordinate for Y value is being accounted for as index of array
            
        }
        
        System.out.print("Enter the number of time steps: ");
        int timeStep = in.nextInt();
        
        System.out.println("Initial Grid: ");
        displayGrid(coordinates); //displays initial grid
        System.out.println();
        
        while(countStep <= timeStep){

            System.out.println("Time Step " + countStep); 
            updateGrid(coordinates); //displays shape for each time step
            countStep++; // updates countStep
            System.out.println(); // creates space after each timeStep grid
        }
    }
    
    public static void displayGrid (int mat [][]){  

        for (int i = 0; i < 10; i++){ 
            System.out.print(i); //prints row of 0-9
        } 
        
        System.out.println();
        for(int i = 0; i < 10;i++){
            for(int j = 0; j< 10; j++){
               if(mat[i][j] == 0){
                   System.out.print(" "); // if array value is 0, print space
               }
               if(mat[i][j] == 1){
                   System.out.print("#"); // if array value is 1, print #
               }
            }
        System.out.println(i); //prints columns of 0-9
        }
        
    }
    
    public static void updateGrid (int mat [][]){
       int[][]temp = new int[10][10];
      
       for(int i = 0; i <10; i++){
           System.arraycopy(mat[i], 0, temp[i], 0, temp.length); //copy mat to temp array
       }
       for(int i = 1; i < 9;i++){
           for(int j = 1; j< 9; j++){
               int countNeighbors = 0; //initialize countNeighbors to 0
               
               /* the following 8 if statements are rules to how to update  
                * countNeighbors
                */
               if(mat[i-1][j]==1){
                   countNeighbors++;
               }
               if(mat[i+1][j]==1){
                   countNeighbors++;
               }
               if(mat[i][j-1]==1){
                   countNeighbors++;
               }
               if(mat[i][j+1]==1){
                   countNeighbors++;
               }
               if(mat[i-1][j-1]==1){
                   countNeighbors++;
               }
               if(mat[i+1][j+1]==1){
                   countNeighbors++;
               }
               if(mat[i-1][j+1]==1){
                   countNeighbors++;
               }
               if(mat[i+1][j-1]==1){
                   countNeighbors++;
               }
               
               /* The following if/else if statements are made to show what 
                * happens when countNeighbors is a certain number
                */
               if(mat[i][j]==0 && countNeighbors == 3){
                   temp[i][j] = 1;        
               }
               else if(mat [i][j] ==1 && (countNeighbors <=1 || countNeighbors >= 4)){
                   temp[i][j] = 0;
               }
           } 
           
       }
       for(int i = 0; i <10; i++){
           System.arraycopy(temp[i], 0, mat[i], 0, mat.length); //copy temp back to mat
       }
       displayGrid(mat); // display mat
        
    }
    
}

