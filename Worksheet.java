
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
 * askOperate()
 * 	 - asks the user for the operation
 * 	askForNumbers()
 *   - asks the user for 2 numbers: First Number and Last Number 	 
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
		final int problemNumber = 20;
		firstNumber = new int[problemNumber];
		secondNumber = new int[problemNumber];
		answer = new int[problemNumber];
	}

	public static void main(String[] args)
	{
		Worksheet ws = new Worksheet();
		ws.runIt();
	}

	public void runIt()
	{
		PrintWriter output = makeIt();
		askForNumbers();
		printWorksheet(output);
	}

	public PrintWriter makeIt()
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
		return output;
	}

	public void askForNumbers()
	{
		Scanner in = new Scanner(System.in);
		int startNum = 0;
		int endNum = 0;
		boolean validInput = false;
		String operation = new String("");

		while (!validInput) 
		{
			System.out.print("Enter the Start Value: ");
			startNum = in.nextInt();
			System.out.print("Enter the End Value: ");
			endNum = in.nextInt();
			do
			{
				System.out.print("Enter the operation '+' or '-' or mixed: ");
				in.nextLine();
				operation = in.nextLine();
				if (!operation.equals("-") && !operation.equals("+") && !operation.equalsIgnoreCase("mixed"))
					System.out.println("You did not enter in the form of '+' or '-'");
				
			} while (!operation.equals("-") && !operation.equals("+") && !operation.equalsIgnoreCase("mixed"));
			
			if (startNum < endNum) 
				validInput = true;
			else 
				System.out.println("End value must be greater than start value. Please try again.");
		}
		generateNumbers(startNum, endNum,operation);
	}


	public void generateNumbers(int start, int end,String operation)
	{
		String operate2 = new String ("");
		for (int i = 0; i < firstNumber.length; i++)
		{
			if (operation.equalsIgnoreCase("mixed"))
			{
				int operate = (int)(Math.random() * 2);
				System.out.println(operate);
				if (operate == 0)
					operate2 = "-";
				else
					operate2 = "+";
			}
			firstNumber[i] = (int)(Math.random() * (end - start)) + start; 
			secondNumber[i] = (int)(Math.random() * (end - start)) + start;
			if (operate2.equals("-"))
				answer[i] = firstNumber[i] - secondNumber[i];
			else
				answer[i] = firstNumber[i] + secondNumber[i];
		}
	}


	public void printWorksheet(PrintWriter output)
	{
		output.printf("%100s\n%100s\n\n\n", "Name_______________________","Date________________");
		String operation = new String("");
		
		output.println("Problems starting from " );
		for (int i = 1; i <= firstNumber.length; i++) 
		{
			if (answer[i-1] == firstNumber[i-1] - secondNumber[i-1])
				operation = "-";
			else
				operation = "+";
				
			if (i%5 != 0)
				output.printf("%d) %-20s",i,firstNumber[i-1] + " " + operation + " " + secondNumber[i-1] + " = ");
			else 
				output.printf("%d) %-20s\n\n\n\n",i,firstNumber[i-1] + " " + operation + " " + secondNumber[i-1] + " = ");
		}
		
		output.println("\n\n\nAnswer Key:");
		for (int i = 1; i <= firstNumber.length; i++) 
		{
				output.printf("%d) %s\n",i,answer[i-1]);
		}

		output.close();
	}
}

