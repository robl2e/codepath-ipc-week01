public class SolutionRomanToInteger {
    public static Map<String, Integer> CONVERT_MAP = new HashMap<String, Integer>() {{
        put("I", 1);
        put("V", 5);
        put("X", 10);
        put("L", 50);
        put("C", 100);
        put("D", 500);
        put("M", 1000);
    }};
    
	public int romanToInt(String a) {
	    if (a == null || a.length() == 0) return 0;
	    
	    int sum= 0;
	    int prevNum = 0;
	    
	    // Handle First Entry
	    prevNum = CONVERT_MAP.get(Character.toString(a.charAt(0)));
	    sum = prevNum;
	    
	    for (int i = 1; i < a.length(); i++) {
	        String roman = Character.toString(a.charAt(i));
	        int num = CONVERT_MAP.get(roman);
	        
	        if (prevNum < num) {
	            sum -= prevNum;
	            sum += num - prevNum;
	        } else {
	            sum += num;
	        }
	        
	        prevNum = num; //set new previous.
	    }
	    return sum;
	}
}
