/*
 * Aarav Goyal
 * 1/27/2025
 * Worksheet.java
 * 
 * Pseudocode:
 *  import Scanner & java.io
 * 	Create 3 field variables: firstNumber[], secondNumber[], answer[]
 * 	
 * 	runIt()
 * 	 - fake main to run the methods
 * 	makeIt()
 * 	 - creates the file
 * 	askForNumbers()
 *   - Ask the user for 2 numbers: First Number and Last Number 	 
 * 	generateNumbers()
 * 	 - generate the problems and calculate the answer
 * 	printWorksheet()
 * 	 - prints the problems, name, date, answer key to the Worksheet 
 * 	 - uses PrintWriter
 */ 
 
 import java.util.Scanner;
 import java.io.*;

 public class Worksheet
 {
	
	 private int[] firstNumber;
	 private int[] secondNumber;
	 private int[] answer;
	
	 public Worksheet()
	 {
		 firstNumber = new int[20];
		 secondNumber = new int[20];
		 answer = new int[20];
	 }
	 
	 public static void main(String[] args)
	 {
		 Worksheet ws = new Worksheet();
		 ws.runIt();
	 }
	 
	 public void runIt()
	 {
		 makeIt();
		 askForNumbers();
		 generateNumbers();
		 printWorksheet();
	 }
	 
	 public void makeIt()
	 {
		 String outFileName = new String("Worksheet.txt");
		 PrintWriter output = null;
		 File outFile = new File(outFileName);
			try
			{
				output = new PrintWriter(outFile);
			}
			catch (IOException e)
			{
				System.err.println("\n\n\nERROR: Cannot create " + outFileName + " file.\n\n\n");
				System.exit(2);
			}
	 }
	 
	 public void askForNumbers()
	 {
		 Scanner in = new Scanner(System.in);
		 int startNum = 0;
		 int endNum = 0;
		 System.out.print("Enter the Start Number: ");
		 startNum = in.nextInt();
		 System.out.print("Enter the last Number: ");
		 endNum= in.nextInt();
	 }
	 
	 public void generateNumbers()
	 {
		 
	 }
	 
	 public void 	printWorksheet()
	 {
		 
	 }
 }
