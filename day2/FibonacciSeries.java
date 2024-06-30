package week1.day2;

import java.util.Scanner;

public class FibonacciSeries {

    public static void main(String[] args) {
        // Creating a Scanner object to read input from the user
        Scanner scan = new Scanner(System.in);
        
        // Prompting the user to enter the range for the Fibonacci series
        System.out.print("Enter the range: ");
        int inputRange = scan.nextInt();
        
        System.out.println("The Fibonacci series for the range " + inputRange + " is:");
        
        // Calling the method to print the Fibonacci series
        printFibonacciSeries(inputRange);
        
        // Closing the scanner object
        scan.close();
    }

    
    public static void printFibonacciSeries(int n) {
        // Initializing the first two numbers of the Fibonacci series
        int firstNumber = 0, secondNumber = 1;
        
        // Loop to print the Fibonacci series
        for (int i = 0; i < n ; i++) {
            // Printing the current number
            System.out.print(firstNumber + " ");
            
            // Calculating the next number in the series
            int nextNumber = firstNumber + secondNumber;
            
            // Updating the numbers for the next iteration
            firstNumber = secondNumber;
            secondNumber = nextNumber;
        }
    }
}
