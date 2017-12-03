public class SolutionAToI {
	public int atoi(final String a) {
	    if (a == null || a.isEmpty()) return 0;
	    
	    char firstDigit = a.charAt(0);
	    if (!isValid(firstDigit)) return 0;
	    
	    boolean isNegative = isNeg(firstDigit);
	    boolean isPlus = isPlusSign(firstDigit);
	    if (a.length() == 1 && (isNegative || isPlus)) return 0; 
	    
	    int startIndex = isNegative || isPlus ? 1 : 0;
	    String str = sanitizeStr(a, startIndex);
	    
	    double sum = 0; // handle larget Int calculations
	    
	    int power = str.length()-1;
	    for (int i=0; i < str.length(); i++) {
	       char digit = str.charAt(i);
	       double num = calcNum(digit, power);
            sum += num;
            power--;	               
	    }
	    
	    if (sum > Integer.MAX_VALUE) {
	        if (isNegative) return Integer.MIN_VALUE;
	        else return Integer.MAX_VALUE;
	    }
	    
	    if (isNegative) {
	        sum = sum * -1;
	    }
	    return (int) sum;
    }
    
    public static double calcNum(char digit, int power) {
        int num = toIntFrom(digit);
        double hundred = Math.pow(10, power);
	    double completeNum = num * hundred;
	    return completeNum;
    }
    
    // Looking for digits
    public static String sanitizeStr(String a, int startIndex) {
        for (int i = startIndex; i < a.length(); i++) {
            char digit = a.charAt(i);
            if (!isValid(digit)) {
                return a.substring(startIndex, i);
            }
        }
        return a.substring(startIndex);
    }
    
    public static boolean isNeg(char digit) {
        return digit == '-';
    }
    
    public static boolean isPlusSign(char digit) {
        return digit == '+';
    }
    
    public static boolean isDigit(char digit) {
	    if (digit == '0' ||
	        digit == '1' ||
	        digit == '2' ||
	        digit == '3' ||
	        digit == '4' ||
	        digit == '5' ||
	        digit == '6' ||
	        digit == '7' ||
	        digit == '8' ||
	        digit == '9') {
	        return true;
	    }
	    return false;
	}
    
	public static boolean isValid(char digit) {
	    if (isPlusSign(digit) || isNeg(digit) || isDigit(digit)) {
	        return true;
	    }
	    return false;
	}
	
	public static int toIntFrom(char digit) {
	    return digit - '0';
	}
}
