public class Main {
    public static void main(String[] args) {
        System.out.println("--- Password Generation Test ---");
        int passwordLength = 12;
        boolean includeSymbols = true;
        
        char[] password = PasswordGenerator.generatePassword(passwordLength, includeSymbols);
        String passwordString = new String(password);

        System.out.println("Length Requested " + passwordLength);
        System.out.println("Generated Password: " + passwordString);
        System.out.println("Confirmed Length: " + passwordString.length());

        System.out.println("-------------------------------");

        System.out.println("--- OTP Generation and Validation Test ---");
        OTPGenerator otpGenerator = new OTPGenerator();
        int otpLength = 6;
        int expiryMinutes = 1;

        OTPRecord otpRecord = otpGenerator.generateOTPRecord(otpLength);

        System.out.println("Generated OTP: " + otpRecord.otpCode());
        System.out.println("OTP Creation Time: " + otpRecord.creationTime());
        System.out.println("Expiry Time (minutes): " + expiryMinutes);

        boolean isValid = TimeBasedValidator.isOTPValid(otpRecord.creationTime(), expiryMinutes);
        System.out.println("Is OTP Valid? " + isValid);

        long waitTimeMillis = (long)expiryMinutes * 60 * 1000 + 2000;

        try {
            System.out.println("\n--- Simulating time passage: Waiting " + waitTimeMillis / 1000 + " seconds... ---");
            Thread.sleep(waitTimeMillis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        boolean isValidLater = TimeBasedValidator.isOTPValid(otpRecord.creationTime(), expiryMinutes);
        System.out.println("Is OTP Valid After Wait? " + isValidLater);

        System.out.println("-------------------------------");
    }   
    
}
