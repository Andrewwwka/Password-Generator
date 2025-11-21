public class TimeBasedValidator {
    public static boolean isOTPValid(long storedTimestamp, int expiryMinutes) {
        long expiryMillis = (long) expiryMinutes * 60 * 1000;
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - storedTimestamp;
        return elapsedTime <= expiryMillis;
    }
    
}
