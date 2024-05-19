import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        boolean playAgain = true;
        int totalScore = 0;
        
        while (playAgain) {
            int targetNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean correctGuess = false;
            int maxAttempts = 10;
            
            System.out.println("A new round has started! Guess the number between 1 and 100.");
            System.out.println("You have a maximum of " + maxAttempts + " attempts.");
            
            while (attempts < maxAttempts && !correctGuess) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;
                
                if (guess == targetNumber) {
                    correctGuess = true;
                    totalScore += maxAttempts - attempts + 1; // Higher score for fewer attempts
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                } else if (guess < targetNumber) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }
            }
            
            if (!correctGuess) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + targetNumber);
            }
            
            System.out.println("Your current score is: " + totalScore);
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }
        
        System.out.println("Thank you for playing! Your final score is: " + totalScore);
        scanner.close();
    }
}
