package bullscows;

public class Grader {
    private String secretNumber;
    private int cows = 0;
    private int bulls = 0;

    public Grader(String secretNumber) {
        this.secretNumber = secretNumber;
    }

    public boolean grade(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == secretNumber.charAt(i)) bulls++;
            else for (int j = 0; j < input.length(); j++) {
                if (input.charAt(i) == secretNumber.charAt(j)) cows++;
            }
        }
        System.out.print("Grade: ");
        if (cows == 0 && bulls == 0) System.out.print("None");
        if (bulls > 0) System.out.print(bulls + (bulls > 1 ? " bulls" : " bull"));
        if (cows > 0 && bulls > 0) System.out.print(" and ");
        if (cows > 0) System.out.print(cows + (cows > 1 ? " cows" : " cow"));
        System.out.println();
        if (bulls == secretNumber.length()) return true;
        else {
            bulls = 0;
            cows = 0;
            return false;
        }
    }
}
