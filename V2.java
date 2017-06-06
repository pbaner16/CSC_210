/*
 * File: Vampire Hunt Game Revisited
 * By: Poulomi Banerjee
 * Date: November 30, 2016
 *
 * Description: To create a program  that revisits the Vampire Hunt game,
 * rewriting it in an object-oriented style
 */
import java.util.Scanner;
/**
 *
 * @author poulomibanerjee
 */
public class V2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
	char [][] grid = new char [10][10];

	// initialize vampire
	System.out.print("Enter (i, j) for vampire: ");
	int newI = input.nextInt();
	int newJ = input.nextInt();
	Creature vampire = new Creature('V', newI, newJ);

	// initialize human
        System.out.print("Enter (i, j) for human: ");
	newI = input.nextInt();
	newJ = input.nextInt();
        Creature human = new Creature('H', newI, newJ);

	// check whether human can move
	System.out.print("Would you like human to move? (0: no, 1: yes): ");
	int isMove = input.nextInt();

	// update and display grid
	clearGrid(grid);
	vampire.display(grid); //call display method of vammpire object
        human.display(grid); // call display method of human object
	drawGrid(grid);
	System.out.println("Vampire at: " + vampire.getI() +
			   " " + vampire.getJ()); // shows vampire coordinates
        System.out.println("Human at: " + human.getI() + " " + human.getJ()); // shows human coordinates

	// get next user command
	System.out.print("Enter command (0 to quit): ");
	int command = input.nextInt();
	
	while (command != 0) { // while not quit
	    clearGrid(grid);
	    vampire.update(command); //calls update(int c) method for vampire object
	    vampire.display(grid); // calls display method of vampire object
	    // if vampire and human are on same square,
	    // vampire bites human, game ends
            if(sameSquare(vampire, human)==true){ // use sameSquare method
               System.out.println("You bit the human!");
               System.exit(0); // if you enter 0, quit the program
            }
            else{

	    // if game does not end
	    // human makes random move
	    // display human on grid
	    // if vampire and human are on same square,
	    // human sacrificed himself, game ends
            if(isMove != 0){
               human.update(); // updates human
                // displays human on grid along with vampire
               if(sameSquare(vampire, human)==true){ // use sameSquare method
                   System.out.println("Human sacraficed itself!");
                   System.exit(0); // if you enter 0, quit the program
               }
               
            }
            human.display(grid);
               drawGrid(grid);
               System.out.println("Vampire at: " + vampire.getI() +
                                   " " + vampire.getJ()); // repors location of vampire
               System.out.println("Human at: " + human.getI() + " " + human.getJ());// reports location of human
               System.out.print("Enter command (0 to quit): ");
               command = input.nextInt();
            } // while (command != 0)
	
        }
    }
    public static void clearGrid(char [][] g){ // displays grid
	for (int i=0; i<g.length; i++) {
	    for (int j=0; j<g.length; j++) {
		g[i][j] = '.';
	    }
	}
    }
    public static void drawGrid(char [][] g) { //writes out rows and columns from 0-9
	System.out.println("0123456789");
	for (int i=0; i<g.length; i++) {
	    for (int j=0; j<g.length; j++) {
		System.out.print(g[i][j]);
	    }
	    System.out.println(i);
	}
    }

    public static boolean sameSquare(Creature c1, Creature c2) { // mentions if coordinates of c1 == c2
        // if c1 and c2 have identical (i, j) coordinates, return true
        // else return false
        return (c1.getI() == c2.getI() && c1.getJ() == c2.getJ());
    }
	
}

class Creature {
    // display character for creature
    private char pic;

    // (i, j) coordinates for creature
    private int i = 0;
    private int j = 0;

    private boolean canMove = true; // can creature move?

  
    Creature(char c, int nI, int nJ) {
	// set display character to c
	pic = c;
	// set position to (nI, nJ)
        setIJ(nI, nJ);
        
    }

    public void setIJ(int nI, int nJ) {
	// set (i, j) coordinates for creature
	// if new coordinates are invalid, leave current position unchanged
        if(nI > 9 || nI < 0 || nJ > 9 || nJ < 0){
           System.out.print("Invalid position change; position set to (" + nI + " , " + nJ +")");
        }
        else{
           i = nI;
           j = nJ;
        }
    }

    public void setMoving(int n) {
	if (n == 0)
	   canMove = false; // if n is 0, creature can't move
	else
	   canMove = true;
    }

    public int getI() {
	return i;
    }

    public int getJ() {
	return j;
    }

    public void update() {
	// random position update; call update with random argument 1-4
        int choice = (int)(1 + 4*(Math.random()));
        update(choice); // call the update method and put choice as an argument
    }

    public void update(int c) {

	// if canMove, update position according to user command c
	// 1: j-- (left)
	// 2: i++ (down)
	// 3: i-- (up)
	// 4: j++ (right)
        if (canMove == true){
            if(c == 1){
                setIJ(i, j-1);
            }
            if(c == 2){
                setIJ(i+1, j);
            }
            if(c == 3){
                setIJ(i-1, j);
            }
            if(c == 4){
                setIJ(i, j+1);
            }
        }

    }

    public void display(char [][] g) {
	g[i][j] = pic;
    }
    

}
    

