/*
 * File: MapNumbers (Project 10)
 * By: Poulomi Banerjee
 * Date: December 9, 2016
 *
 * Description: To write a program that prompts the user to enter a 7-digit 
 * phone numbers, and finds the 3- and 4-letter words that map to the phone 
 *  number, according to the restrictions outlined earlier. 
 */
import java.util.Scanner;
/**
 *
 * @author poulomibanerjee
 */
public class MapNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        Scanner input = new Scanner(System.in);

	// prompt user for dictionary file
	System.out.print("Enter name of dictionary file: ");
	String fName = input.nextLine();
        

	// instantiate PhoneMapper for 3-letter words from dictionary file
	PhoneMapper myMap3 = new PhoneMapper(fName, 3);

	// initial test code
	System.out.print("Enter a test word (3 letters): ");
	String s = input.nextLine();
	String testNum = myMap3.findTelNum(s);
	System.out.println("Test word maps to " + testNum);
	
	// instantiate PhoneMapper for 4-letter words from dictionary file

        PhoneMapper myMap4 = new PhoneMapper(fName, 4);


	// prompt user for phone number
	System.out.print("Enter telephone number ");
	System.out.print("(7 digits, no 0's or 1's, q to quit): ");

	String telNum = input.nextLine();
	while (! telNum.equals("q")) {  // process each non-negative number
	    // extract first 3 digits
	    String firstPart = telNum.substring(0,3);
	    
	    // get words for first 3 digits and display
	    String [] results = myMap3.findWords(firstPart);

	    System.out.println("Options for first 3 digits:");
            
	    for (int i=0; i< myMap3.numWords; i++) {
                
		System.out.println(results[i]);
	    }
            myMap3.numWords = 0;
	    
	    // extract last 4 digits
            String lastPart =telNum.substring(3,7);

	    // get words for last 4 digits and display
            String [] otherResults = myMap4.findWords(lastPart);

	    System.out.println("Options for last 4 digits:");
            
	    for (int i=0; i<myMap4.numWords; i++) {
		System.out.println(otherResults[i]); //putting 4 letter words in array
	    }
            myMap4.numWords =0;


	    // prompt user for phone number
	    System.out.print("Enter telephone number ");
	    System.out.print("(7 digits, no 0's or 1's, q to quit): ");
	    telNum = input.nextLine();
	} // end while 
      
    }
}

class PhoneMapper {
    final int MAXWORDS = 20000; // max number of words from dictionary
    String [] wordList = new String [MAXWORDS]; // list of dictionary words
    int numWords = 0; // number of words of correct length
    String fileInput = null; // extracted from dictionary
    public int tracker = 0;
    public String [] string_list = new String [tracker];
    
    PhoneMapper(String fileName, int wordLength) throws Exception {
	// fileName: name of dictionary file
        
        fileInput = fileName;
	// wordLength: length of words to extract
        numWords = wordLength;
	// read dictionary file and
	// add each word of length wordLength to wordList[]
        
        java.io.File file = new java.io.File(fileName); 
        Scanner in = new Scanner(file);
        while(in.hasNext()){
            String line = in.nextLine();
            if(line.length()==wordLength){
                wordList[tracker]= line; // putting words in wordList method
                tracker++;
            }
        }
    }

    // return array of words mapped to num
    String [] findWords(String num) {
        String [] string_list = new String [tracker];
        numWords = 0;
	for (int i=0; i<tracker; i++){
            String line = wordList[i]; //line adds to array
            String words = findTelNum(line);
            if (num.equals(words)){
                string_list [numWords] = line; //puts numbers into array
                numWords++;
            }
            
        }
	return string_list;
    }

    // returns telephone number that inStr maps to
    String findTelNum(String inStr)
    {
        char [] cHAR = new char [inStr.length()];
        for(int i =0; i<inStr.length();i++){
            char ch = inStr.charAt(i);
            if((ch == 'a') || (ch == 'b') || (ch == 'c')){
                ch = '2';
                
            }
            if((ch == 'd') || (ch == 'e') || (ch == 'f')){
                ch = '3';
            }
            if((ch == 'g') || (ch == 'h') || (ch == 'i')){
                ch = '4';
            }
            if((ch == 'j') || (ch == 'k') || (ch == 'l')){
                ch = '5';
            }
            if((ch == 'm') || (ch == 'n') || (ch == 'o')){
                ch = '6';
            }
            if((ch == 'p') || (ch == 'q') || (ch == 'r') || (ch == 's')){
                ch = '7';
            }
            if((ch == 't') || (ch == 'u') || (ch == 'v')){
                ch = '8';
            }
            if((ch == 'w') || (ch == 'x') || (ch == 'y') || (ch == 'z')){
                ch = '9';
            }   
            cHAR [i]= ch;
        }
        
        String phone_number = new String (cHAR);
	return phone_number; //returns array of phone number
	
    }
    
}
    
