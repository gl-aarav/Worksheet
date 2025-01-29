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
		int operation = askForNumbers();
		printWorksheet(output, operation);
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

	public int askForNumbers()
	{
		Scanner in = new Scanner(System.in);
		int startNum = 0;
		int endNum = 0;
		boolean validInput = false;

		while (!validInput) 
		{
			System.out.print("Enter the Start Value: ");
			startNum = in.nextInt();
			System.out.print("Enter the End Value: ");
			endNum = in.nextInt();
			if (startNum < endNum) 
			{
				validInput = true;
			} 
			else 
			{
				System.out.println("End value must be greater than start value. Please try again.");
			}
		}
		int operation = generateNumbers(startNum, endNum);
		return operation;
	}


	public int generateNumbers(int start, int end)
	{
		int operation = 0;
		for (int i = 0; i < firstNumber.length; i++)
		{
			operation = (int)(Math.random() * 2) + 1;  
			firstNumber[i] = (int)(Math.random() * (end - start)) + start; 
			secondNumber[i] = (int)(Math.random() * (end - start)) + start;
			if (operation == 1)
				answer[i] = firstNumber[i] - secondNumber[i];
			else
				answer[i] = firstNumber[i] + secondNumber[i];
			operation = 0;
		}
		return operation;
	}


	public void printWorksheet(PrintWriter output, int operation)
	{
		String operation2 = new String("");
		if(operation == 1)
			operation2 = "-";
		else
			operation2 = "+";

		for (int i = 1; i <= firstNumber.length; i++) 
		{
			if (i%5 != 0)
				output.printf("%-20s\t\t", firstNumber[i-1] + " " + operation2 + " " + secondNumber[i-1] + " = " + answer[i-1]);
			else 
				output.printf("%s\n", firstNumber[i-1] + " " + operation2 + " " + secondNumber[i-1] + " = " + answer[i-1]);
			System.out.println();
		}

		output.close();
	}
}

