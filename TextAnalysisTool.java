import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class TextAnalysisTool {

    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // User Input: Prompt the user to enter a paragraph or lengthy text
        System.out.println("Please enter a paragraph or a lengthy text:");
        String text = scanner.nextLine();

        // Character Count: Calculate and display the total number of characters
        int charCount = text.length();
        System.out.println("Total number of characters: " + charCount);

        // Word Count: Split the text into words and count them
        String[] words = text.split("\\s+");
        int wordCount = words.length;
        System.out.println("Total number of words: " + wordCount);

        // Most Common Character: Calculate the frequency of each character and find the most common one
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char c : text.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
            }
        }

        char mostCommonChar = ' ';
        int maxCount = 0;
        for (Map.Entry<Character, Integer> entry : charFrequency.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostCommonChar = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        System.out.println("Most common character: " + mostCommonChar);

        // Character Frequency: Ask for a character and display its frequency
        System.out.println("Enter a character to find its frequency:");
        char inputChar = Character.toLowerCase(scanner.next().charAt(0));
        int charFrequencyCount = charFrequency.getOrDefault(inputChar, 0);
        System.out.println("Frequency of '" + inputChar + "': " + charFrequencyCount);

        // Word Frequency: Ask for a word and display its frequency
        System.out.println("Enter a word to find its frequency:");
        scanner.nextLine(); // Consume newline
        String inputWord = scanner.nextLine().toLowerCase();

        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            String cleanedWord = word.toLowerCase();
            wordFrequency.put(cleanedWord, wordFrequency.getOrDefault(cleanedWord, 0) + 1);
        }
        int wordFrequencyCount = wordFrequency.getOrDefault(inputWord, 0);
        System.out.println("Frequency of '" + inputWord + "': " + wordFrequencyCount);

        // Unique Words: Calculate and display the number of unique words
        Set<String> uniqueWords = new HashSet<>();
        for (String word : words) {
            uniqueWords.add(word.toLowerCase());
        }
        System.out.println("Number of unique words: " + uniqueWords.size());

        // Close the scanner to prevent resource leaks
        scanner.close();
    }
}
