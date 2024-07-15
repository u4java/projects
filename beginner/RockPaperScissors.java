
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] choices = {"Rock", "Paper", "Scissors"};
        int playerScore = 0;
        int computerScore = 0;

        System.out.println("Welcome to Rock Paper Scissors!");
        System.out.println("Enter your choice: (1) Rock, (2) Paper, (3) Scissors, or (0) to quit");

        while (true) {
            System.out.print("\nYour choice: ");
            int playerChoice = scanner.nextInt();

            if (playerChoice == 0) {
                break;
            }

            if (playerChoice < 1 || playerChoice > 3) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            int computerChoice = random.nextInt(3) + 1;

            System.out.println("You chose: " + choices[playerChoice - 1]);
            System.out.println("Computer chose: " + choices[computerChoice - 1]);

            int result = (playerChoice - computerChoice + 3) % 3;

            switch (result) {
                case 0:
                    System.out.println("It's a tie!");
                    break;
                case 1:
                    System.out.println("You win!");
                    playerScore++;
                    break;
                case 2:
                    System.out.println("Computer wins!");
                    computerScore++;
                    break;
            }

            System.out.println("Current Score - You: " + playerScore + ", Computer: " + computerScore);
        }

        System.out.println("\nFinal Score:");
        System.out.println("You: " + playerScore);
        System.out.println("Computer: " + computerScore);

        if (playerScore > computerScore) {
            System.out.println("Congratulations! You win the game!");
        } else if (playerScore < computerScore) {
            System.out.println("Computer wins the game. Better luck next time!");
        } else {
            System.out.println("It's a tie game!");
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}