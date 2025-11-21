import java.security.SecureRandom;

public class PasswordGenerator {
    
    public static char[] generatePassword(int len, boolean includeSymbols) { 
        
        // 1. Define Character Sets 
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$%^&*()_+-=[]{};:'\",.<>/?"; // Expanded symbol set
        String numbers = "1234567890";
        
        // 2. Build the combined pool
        String combinedChars = capitalCaseLetters + lowerCaseLetters + numbers;
        if (includeSymbols) {
            combinedChars += specialCharacters;
        }

        SecureRandom random = new SecureRandom();
        char[] password = new char[len];

        // 3. Guarantee complexity (Handle edge case where len < required chars)
        int mandatoryCount = 3; // L, C, N
        if (includeSymbols) {
            mandatoryCount = 4; // L, C, N, S
        }
        
        
        if (len < mandatoryCount) {
             throw new IllegalArgumentException("Password length must be at least " + mandatoryCount + " characters.");
        }
        
        // Add mandatory characters to ensure strength
        password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        password[2] = numbers.charAt(random.nextInt(numbers.length()));
        
        int nextIndex = 3;
        if (includeSymbols) {
            password[3] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
            nextIndex = 4;
        }
        
        // Fill the rest of the array randomly
        for(int i = nextIndex; i < len; i++) {
            password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
        }

        for (int i = 0; i < len; i++) {
            int j = random.nextInt(len); // Random index from 0 to len-1
            char temp = password[i];
            password[i] = password[j];
            password[j] = temp;
        }
        
        return password;
    }
}