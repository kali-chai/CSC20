
/**
 * Name: Kali Wilson
 * Description: This program will prompt a user to input five letters, one prompted at a time, then print the stored array of letters to the console. Each entry will be validated to meet the following requirements:
 * - The entry must be a single character.
 * - The entry must be a letter (a-z or A-Z).
 * - The entry must not be a duplicate of any previous entries.
 * Date: 2025.01.27
 * Self-Grade: 5/5; JavaDoc is implemented, code is clean/formatted and contains inline documentation. Methods (all types) correspond to assignment specification. Program runs and provides output as specified.
 * Testimony: I have written the code myself without any unauthorized help. -Kali Wilson
 */

 import java.util.Scanner;

 public class LettersWilson {
     /**
      * Empty class.
      */
 }
 
 @SuppressWarnings("unused")
 class Letters {
 
     public static void main(String[] args) {
         /**
          * Calls the desc method.
          */
         desc();
         /**
          * Declares a char[5].
          */
         char[] letters = new char[5];
         /**
          * Calls the populate method.
          */
         populate(letters);
         /**
          * Calls the print method.
          */
         print(letters);
     }
 
     /**
      * Loops through a given char array and runs comparison, returns true if
      * char input is present, false if char input is not found.
      *
      * @param letters the array of characters to search through
      * @param input the character to search for
      * @return true if the character is found, false otherwise
      */
     public static boolean found(char[] letters, char input) {
         for (int i = 0; i < letters.length; i++) {
             if (letters[i] == input) {
                 return true;
             }
         }
         return false;
     }
 
     /**
      * Prompts user for input, checks if input matches requirements, returns
      * char if requirements met, otherwise reprompts user.
      *
      * @param kb the Scanner object to read user input
      * @return the validated character input
      */
     public static char validateInput(Scanner kb) {
         /**
          * Delares returnable char and boolean to track.
          */
         char firstLetter = ' ';
         boolean done = false;
         /**
          * Loops until valid letter is entered.
          */
         while (!done) {
             /**
              * Prompts user for input.
              */
             System.out.print("Please enter a letter: ");
             /**
              * Stores input, newline to console.
              */
             String input = kb.next();
             System.out.println();
             /**
              * Checks if input is a single character.
              */
             while (input.length() != 1) {
                 System.out.print("You must enter a single letter.\nPlease enter a letter: ");
                 input = kb.next();
                 System.out.println();
             }
             /**
              * Converts input to uppercase, stores single-character String to
              * char.
              */
             input = input.toUpperCase();
             firstLetter = input.charAt(0);
             /**
              * Checks if char firstLetter is a letter; If yes, break loop and
              * return, otherwise returns to top of while(!done).
              */
             if (Character.isLetter(firstLetter)) {
                 done = true;
             } else {
                 System.out.println("You did not enter a letter.");
             }
         }
         /**
          * Returns validated input.
          */
         return firstLetter;
     }
 
     /**
      * Loops through char array, prompts user for input, validates input, checks
      * for duplicacy, stores validated input to array.
      *
      * @param letters the array to populate with validated characters
      */
     public static void populate(char[] letters) {
         Scanner kb = new Scanner(System.in);
         for (int i = 0; i < letters.length; i++) {
             /**
              * Calls validateInput method, checks if char is already in array;
              * If no, stores to array, otherwise decrements loop and runs again.
              */
             char v = validateInput(kb);
             if (!found(letters, v)) {
                 letters[i] = v;
                 System.out.println("Letter added to the array.\nYou have " + (i + 1) + " letters in the array.");
             } else {
                 System.out.println("You have already entered that letter. Try again.");
                 i--;
             }
         }
     }
 
     /**
      * Prints char array to console.
      *
      * @param letters given char array to print.
      */
     public static void print(char[] letters) {
         System.out.println("Here is the list of distinct letters you have entered:");
         for (int i = 0; i < letters.length; i++) {
             System.out.print(letters[i] + " ");
         }
     }
 
     /**
      * Prints description of program to console per assignment instructions.
      */
     public static void desc() {
         for (int i = 0; i < 83; i++) {
             System.out.print("*");
         }
         System.out.println();
         System.out.println("You will be asked to enter letters, upper case and lower case will be considered the same.\nThe program will filter out the repeated letters. Then the program will display the distinct letters entered by the user.");
         for (int i = 0; i < 83; i++) {
             System.out.print("*");
         }
         System.out.println();
     }
 }
 