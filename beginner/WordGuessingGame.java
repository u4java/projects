
import java.util.Scanner;
import java.util.Random;

public class WordGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] words = {"java", "programming", "computer", "algorithm", "developer"};

        do {
            playGame(scanner, random, words);
            System.out.print("Do you want to play again? (yes/no): ");
        } while (scanner.next().toLowerCase().startsWith("y"));

        System.out.println("Thank you for playing! Goodbye!");
        scanner.close();
    }

    public static void playGame(Scanner scanner, Random random, String[] words) {
        String wordToGuess = words[random.nextInt(words.length)];
        char[] guessedLetters = new char[wordToGuess.length()];
        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = '_';
        }

        int attempts = 6;
        boolean wordGuessed = false;

        System.out.println("\nWelcome to the Word Guessing Game!");
        System.out.println("Try to guess the word. You have " + attempts + " wrong guesses.");

        while (attempts > 0 && !wordGuessed) {
            // Display current state of the word
            System.out.print("Current word: ");
            for (char c : guessedLetters) {
                System.out.print(c + " ");
            }
            System.out.println("\nAttempts left: " + attempts);

            // Get user's guess
            System.out.print("Enter a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            boolean correctGuess = false;
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guess) {
                    guessedLetters[i] = guess;
                    correctGuess = true;
                }
            }

            if (!correctGuess) {
                attempts--;
                System.out.println("Incorrect guess!");
            }

            // Check if the word is completely guessed
            wordGuessed = true;
            for (char c : guessedLetters) {
                if (c == '_') {
                    wordGuessed = false;
                    break;
                }
            }
        }

        if (wordGuessed) {
            System.out.println("Congratulations! You guessed the word: " + wordToGuess);
        } else {
            System.out.println("Sorry, you're out of attempts. The word was: " + wordToGuess);
        }
    }
}