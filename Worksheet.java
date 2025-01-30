
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
		int problemNumber = 0;
		Scanner in = new Scanner (System.in);
		System.out.println("\n\n\n");
		do
		{
			System.out.print("Enter the number of problems you want: ");
			problemNumber = in.nextInt();
			if (problemNumber <= 0)
				System.out.println("\nYou did not enter a valid input, enter a number greater than 0.");
		} while(problemNumber <= 0);
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
		makeIt();
	}

	public void makeIt()
	{
		Scanner in = new Scanner (System.in);	
		System.out.print("Enter the name of the file you want: ");
		String outFileName = in.nextLine();
		outFileName = outFileName + ".txt";
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
		askForNumbers(output, outFileName);
	}

	public void askForNumbers(PrintWriter output, String fileName)
	{
		Scanner in = new Scanner(System.in);
		int startNum = 0;
		int endNum = 0;
		boolean validInput = false;
		String operation = new String("");

		System.out.print("\nEnter the Start Value: ");
		startNum = in.nextInt();
		System.out.print("Enter the End Value: ");
		endNum = in.nextInt();
		in.nextLine();

		do
		{
			System.out.print("Enter the operation '+' or '-' or mixed: ");
			operation = in.nextLine();

			if (!operation.equals("-") && !operation.equals("+") && !operation.equalsIgnoreCase("mixed"))
				System.out.println("You did not enter in the form of '+' or '-'");

		} while (!operation.equals("-") && !operation.equals("+") && !operation.equalsIgnoreCase("mixed"));

		System.out.println("Go look at \"" + fileName + "\" to see the worksheet!\n\n\n");
		generateNumbers(startNum, endNum,operation, output);
	}


	public void generateNumbers(int start, int end,String operation, PrintWriter output)
	{
		String operate2 = new String ("");
		boolean mixedOrNot = false;
		for (int i = 0; i < firstNumber.length; i++)
		{
			if (operation.equalsIgnoreCase("mixed"))
			{
				int operate = (int)(Math.random() * 2);
				if (operate == 0)
					operate2 = "-";
				else
					operate2 = "+";
				mixedOrNot = true;
			}
			firstNumber[i] = (int)(Math.random() * (end - start)) + start; 
			secondNumber[i] = (int)(Math.random() * (end - start)) + start;
			if (operate2.equals("-"))
				answer[i] = firstNumber[i] - secondNumber[i];
			else
				answer[i] = firstNumber[i] + secondNumber[i];
		}
		printWorksheet(output, start, end, mixedOrNot);
	}


	public void printWorksheet(PrintWriter output, int start, int end, boolean mix)
	{
		output.printf("%115s\n%115s\n\n\n", "Name_______________________","Date________________");
		String operation = new String("");
		boolean print = true;

		for (int i = 1; i <= firstNumber.length; i++) 
		{
			if (answer[i-1] == firstNumber[i-1] - secondNumber[i-1] && mix)
			{
				operation = "-";
				if (print)
				{
					output.println("Addition and Subtraction practice using numbers " + start + " to " + end + ".\n\n");
					print = false;
				}
			}
			else if (answer[i-1] == firstNumber[i-1] + secondNumber[i-1] && mix)
			{
				operation = "+";
				if (print)
				{
					output.println("Addition and Subtraction practice using numbers " + start + " to " + end + ".\n\n");
					print = false;
				}
			}
			else if (answer[i-1] == firstNumber[i-1] + secondNumber[i-1] && !mix)
			{
				operation = "+";
				if (print)
				{
					output.println("Addition practice using numbers " + start + " to " + end + ".\n\n");
					print = false;
				}
			}
			else
			{
				operation = "-";
				if (print)
				{
					output.println("Subtraction practice using numbers " + start + " to " + end + ".\n\n");
					print = false;
				}
			}

			if (i%5 != 0)
				output.printf("%2d) %-20s",i,firstNumber[i-1] + " " + operation + " " + secondNumber[i-1] + " = ");
			else 
				output.printf("%2d) %-20s\n\n\n\n\n\n\n",i,firstNumber[i-1] + " " + operation + " " + secondNumber[i-1] + " = ");
		}

		output.println("\n\n\nAnswer Key:");
		for (int i = 1; i <= firstNumber.length; i++) 
		{

			if (i%5 != 0)
				output.printf("%2d) %-20s",i,answer[i-1]);
			else
				output.printf("%2d) %-20s\n",i,answer[i-1]);
		}

		output.close();
	}
}

