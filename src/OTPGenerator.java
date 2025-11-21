import java.security.SecureRandom;

public class OTPGenerator {
    public String generateNumericOTP(int length) {
        String numbers = "1234567890";
        SecureRandom random = new SecureRandom();
        StringBuilder otp = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            otp.append(numbers.charAt(random.nextInt(numbers.length())));        
        }
        return otp.toString();
    }
    public OTPRecord generateOTPRecord(int length) {
        String otpCode = generateNumericOTP(length);

        long creationTime = System.currentTimeMillis();

        return new OTPRecord(otpCode, creationTime);
        }
    }


