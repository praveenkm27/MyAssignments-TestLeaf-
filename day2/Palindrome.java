package week1.day2;

import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        // Prompting the user to enter a number
        System.out.print("Enter a number: ");
        int input = scanner.nextInt();

        // Printing the result of palindrome check
        if (isPalindrome(input)) {
            System.out.println("The number " + input + " is a palindrome.");
        } else {
            System.out.println("The number " + input + " is not a palindrome.");
        }

        // Closing the scanner object
        scanner.close();
    }

    public static boolean isPalindrome(int input) {
        // Variable to store the original number
        int originalNumber = input;

        // Variable to store the reversed number
        int output = 0;

        // Reversing the digits of the input number
        for (int i = input; i > 0; i = i / 10) {
            int rem = i % 10; // Getting the last digit
            output = output * 10 + rem; // Constructing the reversed number
        }

        // Comparing the original number with the reversed number
        return originalNumber == output;
    }
}

