public class SolutionReverseTheString {
    
	public String reverseWords(String a) {
	    if (a == null || a.length() == 0) return a;
	    
	    String sanitized = a.trim();
	    String[] words = sanitized.split("\\s+");
	    
	    StringBuilder sb = new StringBuilder();
	    
	    for (int i = words.length - 1; i >= 0; i--) {
	        String word = words[i];
            sb.append(word);
            sb.append(" ");
	    }
	    
	    return sb.toString().trim();
	}
}
