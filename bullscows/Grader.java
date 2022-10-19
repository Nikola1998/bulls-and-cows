package bullscows;

class Grader {
    private final String secretCode;
    private int cows = 0;
    private int bulls = 0;

    public Grader(String secretNumber) {
        this.secretCode = secretNumber;
    }

    public boolean grade(String input) {
        checkHowManyBullsAndCows(input);
        printGrade();
        return checkIfVictorious();
    }

    private void checkHowManyBullsAndCows(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == secretCode.charAt(i)) bulls++;
            else for (int j = 0; j < input.length(); j++) {
                if (input.charAt(i) == secretCode.charAt(j)) cows++;
            }
        }
    }

    private void printGrade() {
        System.out.print("Grade: ");
        if (cows == 0 && bulls == 0) System.out.print("None");
        if (bulls > 0) System.out.print(bulls + (bulls > 1 ? " bulls" : " bull"));
        if (cows > 0 && bulls > 0) System.out.print(" and ");
        if (cows > 0) System.out.print(cows + (cows > 1 ? " cows" : " cow"));
        System.out.println();
    }

    private boolean checkIfVictorious() {
        if (bulls == secretCode.length()) return true;
        else {
            bulls = 0;
            cows = 0;
            return false;
        }
    }
}
