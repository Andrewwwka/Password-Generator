import java.security.SecureRandom;
import java.util.*;
public class PasswordGenerator {
    public static void main(String[] args) {
        int length = 12; // Desired password length
        System.out.println("Generated Password: " + generatePassword(length));
    }
    static char[] generatePassword(int len){
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$";
        String numbers = "1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
        SecureRandom random = new SecureRandom();
        char[] password = new char[len];
        password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
        password[3] = numbers.charAt(random.nextInt(numbers.length()));
        for(int i = 4; i<len ; i++) {
            password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
        }
        Collections.shuffle(Arrays.asList(password));
        return password;
    }

}