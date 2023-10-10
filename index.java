import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Task 1: Create and shuffle an array
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7};
        Collections.shuffle(Arrays.asList(numbers));
        System.out.println("Shuffled Array: " + Arrays.toString(numbers));

        // Task 2: Convert Roman number to integer
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a Roman Number (e.g., IX): ");
        String romanNumber = scanner.nextLine().toUpperCase();
        int result = romanToInteger(romanNumber);
        System.out.println("Roman to Integer: " + result);

        // Task 3: Check if the input is a pangram
        System.out.print("Enter a sentence to check if it's a pangram: ");
        String sentence = scanner.nextLine().toLowerCase();
        boolean isPangram = isPangram(sentence);
        if (isPangram) {
            System.out.println("The input is a pangram.");
        } else {
            System.out.println("The input is not a pangram.");
        }
    }

    // Function to convert a Roman number to an integer
    public static int romanToInteger(String s) {
        // Define a mapping of Roman numerals to integers
        java.util.Map<Character, Integer> romanMap = java.util.Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);
        
        int result = 0;
        int prevValue = 0;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = romanMap.get(s.charAt(i));
            if (currentValue >= prevValue) {
                result += currentValue;
            } else {
                result -= currentValue;
            }
            prevValue = currentValue;
        }
        
        return result;
    }

    // Function to check if a sentence is a pangram
    public static boolean isPangram(String sentence) {
        boolean[] alphabet = new boolean[26]; // A-Z
        for (char c : sentence.toCharArray()) {
            if (Character.isLetter(c)) {
                alphabet[c - 'a'] = true;
            }
        }
        
        for (boolean letter : alphabet) {
            if (!letter) {
                return false; // Not all letters are present
            }
        }
        
        return true; // All letters are present
    }
}
