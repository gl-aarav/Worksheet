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
		 
	 }
	 
	 public askForNumbers()
	 {
		 
	 }
	 
	 public generateNumbers()
	 {
		 
	 }
	 
	 public printWorksheet()
	 {
		 
	 }
 }
