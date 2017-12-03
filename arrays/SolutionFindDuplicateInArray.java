public class SolutionFindDuplicateInArray {
    
    static final int NONE = -1;
	// DO NOT MODIFY THE LIST
	public int repeatedNumber(final List<Integer> a) {
	    if (a.isEmpty()) return NONE;
	    if (a.size() == 1) return NONE;
	    

        Set<Integer> set = new HashSet(); 
    
	    for (Integer num : a) {
	        boolean isAdded = set.add(num);
	        if (!isAdded) return num;
	    }

 	    return NONE;
	}

}
