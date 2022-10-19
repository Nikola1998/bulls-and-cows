package bullscows;

import java.util.Random;

class RandomNumberGenerator {
    private final Random random = new Random();

    public String generateSecretCode(int length, int possibleCharacters) {
        StringBuilder result = new StringBuilder();
        int randomNumber;
        boolean found = false;
        for (int i = 0; i < length; i++) {
            while (!found) {
                if (possibleCharacters <= 10) {
                    randomNumber = random.nextInt(possibleCharacters) + 48;
                } else {
                    if (random.nextBoolean()) {
                        randomNumber = random.nextInt(10) + 48;
                    } else {
                        randomNumber = random.nextInt(possibleCharacters - 11) + 97;
                    }
                }
                if (result.indexOf("" + (char) randomNumber) == -1) {
                    result.append((char) randomNumber);
                    found = true;
                }
            }
        }
        return result.toString();
    }
}
