package bullscows;

import java.util.Scanner;

public class GameConsole {
    private final int MAX_DIGITS = 36;
    private final Scanner scanner = new Scanner(System.in);
    private int secretLength;
    private int inputPossible;

    public void gameStart() {
        inputSecretLength();
        inputPossibleCharacters();
        gameStartAnnouncement();
        continueTheGameUntilFinishing();
    }

    private void continueTheGameUntilFinishing() {
        var rng = new RandomNumberGenerator();
        var grader = new Grader(rng.generateSecretCode(secretLength, inputPossible));
        int turn = 1;

        while (true) {
            System.out.println("Turn " + turn + ":");
            String input = scanner.nextLine();
            if (input.length() == secretLength) {
                if (grader.grade(input)) {
                    System.out.println("Congratulations! You guessed the secret code.");
                    break;
                }
                turn++;
            } else System.out.println("Error: incorrect length. You need to type " + secretLength + " amount of characters.");
        }
    }


    private void inputSecretLength() {
        System.out.println("GameConsole the length of the secret code:");

        if (scanner.hasNextInt()) secretLength = scanner.nextInt();
        else {
            System.out.println("Error: \"" + scanner.nextLine() + "\" isn't a valid number.");
            System.exit(0);
        }

        if (secretLength <= 0 || secretLength > MAX_DIGITS) {
            System.out.println("Error.");
            System.exit(0);
        }

    }

    private void inputPossibleCharacters() {
        System.out.println("GameConsole the number of possible symbols (max: " + MAX_DIGITS + ") in the code:");
        while (true) {
            inputPossible = scanner.nextInt();
            if (inputPossible > secretLength && inputPossible <= MAX_DIGITS) break;
            else if (inputPossible < secretLength) {
                System.out.println("Error: it's not possible to generate a code with a length of " + secretLength + " with " + inputPossible + " unique symbols.");
                System.exit(0);
            } else if (inputPossible > MAX_DIGITS) {
                System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
                System.exit(0);
            }
        }
    }

    private void gameStartAnnouncement() {
        System.out.print("The secret is prepared: ");
        for (int i = 0; i < secretLength; i++) {
            System.out.print("*");
        }
        if (inputPossible > 10) {
            System.out.println(" (0 - 9, a - " + ((char) (97 + inputPossible - 11)) + ")");
        } else System.out.println(" (0 - " + (inputPossible - 1) + ")");
    }
}
