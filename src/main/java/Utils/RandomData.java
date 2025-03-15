package Utils;

import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

public class RandomData {

    //generate random first name for user registration page
    public String generateRandomFirstName() {
        String[] firstWord = {"Johnny", "Jani", "Bobby", "First", "Michael", "Paul", "Morgan"};
        String[] lastWord = {"Smith", "Johnson", "Beam", "Don", "Willy", "Pil", "West"};

        Random random = new Random();
        String firstName = firstWord[random.nextInt(firstWord.length)];
        String lastName = lastWord[random.nextInt(lastWord.length)];

        return firstName + " " + lastName;
    }

    //generate random last name for user registration page
    public String generateRandomLastName(){
        String[] firstWord = {"Moore", "Leo", "Noah", "Lee", "Martin"};
        String[] lastWord = {"Wilson", "Taylor", "Garcia", "Harris"};

        Random random = new Random();
        String firstName = firstWord[random.nextInt(firstWord.length)];
        String lastName = lastWord[random.nextInt(lastWord.length)];

        return firstName + " " + lastName;
    }

    //generate random username for user registration page
    public String generateRandomUsername(){
        return "User_" + UUID.randomUUID().toString().substring(0, 8);
    }

    //generate random password for user registration page
    public String generateRandomPassword() {
        // Define character sets
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";

        // Combine all the character sets
        String allCharacters = uppercaseLetters + lowercaseLetters + digits;

        // Specify the length of the password (minimum 8 characters)
        int passwordLength = 8; // You can change this length

        // Use SecureRandom for better randomness
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        // Ensure the password contains at least one uppercase letter, one lowercase letter, and one number
        password.append(uppercaseLetters.charAt(random.nextInt(uppercaseLetters.length())));
        password.append(lowercaseLetters.charAt(random.nextInt(lowercaseLetters.length())));
        password.append(digits.charAt(random.nextInt(digits.length())));

        // Fill the rest of the password with random characters from all sets
        for (int i = 3; i < passwordLength; i++) {
            password.append(allCharacters.charAt(random.nextInt(allCharacters.length())));
        }

        // Shuffle the password to randomize the order of characters
        return password.toString();
    }
}
