public class SolutionPalindromeString {
    static final int TRUE = 1;
    static final int FALSE = 0;
    
	public int isPalindrome(String a) {
	    if (a == null || a.length() == 0) return FALSE;
	    if (a.length() == 1) return TRUE;
	    if (a.isEmpty()) return TRUE;
	    
	    int head = 0;
	    int tail = a.length()-1;
	    
	    while (head <= tail) {
	        char headLetter = a.charAt(head);
	        while(!isAlphaNumeric(headLetter) && head < a.length()-1) {
	            head++;
	            headLetter = a.charAt(head);
	        }
	        
	        char tailLetter = a.charAt(tail);
	        while(!isAlphaNumeric(tailLetter) && tail > 0) {
	            tail--;
	            tailLetter = a.charAt(tail);
	        }
	        
	        headLetter = Character.toLowerCase(headLetter);
	        tailLetter = Character.toLowerCase(tailLetter);

            if (!isAlphaNumeric(headLetter) && !isAlphaNumeric(tailLetter)) {
                return TRUE;
            } else if (headLetter != tailLetter) {
	            return FALSE;
	        } else {
	            head++;
	            tail--;
	        }
	    } 
        return TRUE;
	}
	
	private boolean isAlphaNumeric(char letter) {
	    return Character.isLetter(letter) || Character.isDigit(letter);
	}
}
