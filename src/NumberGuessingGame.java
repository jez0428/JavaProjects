import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    private int secretNumber;

    public NumberGuessingGame() {
        Random random = new Random();
        secretNumber = random.nextInt(100) + 1; // Generate a random number between 1 and 100 (inclusive)
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean win = false;
        int numberOfTries = 0;

        while (!win) {
            System.out.print("Guess a number from 1 to 100: ");
            try {
                int guess = scanner.nextInt();
                numberOfTries++;

                if (guess == secretNumber) {
                    win = true;
                } else if (guess < secretNumber) {
                    System.out.println("Your guess is too low");
                } else {
                    System.out.println("Your guess is too high");
                }

                int difference = Math.abs(secretNumber - guess);
                if (difference == 0) {
                    break;
                } else if (difference <= 5) {
                    System.out.println("You're very close!");
                } else if (difference <= 10) {
                    System.out.println("You're getting closer!");
                } else {
                    System.out.println("You're far from the secret number.");
                }
            } catch (InputMismatchException e) {
                // Clear the input buffer
                scanner.nextLine();
                System.out.println("Invalid input! Please enter a valid integer.");
            }
        }

        scanner.close(); // Closing the Scanner object after it's no longer needed

        System.out.println("Congratulations! You guessed the correct number.");
        System.out.println("The secret number was " + secretNumber);
        System.out.println("It took you " + numberOfTries + " tries.");
    }

    public static void main(String[] args) {
        NumberGuessingGame game = new NumberGuessingGame();
        game.playGame();
    }
}
