public class SolutionMaxSumContiguousSubarray {
	// DO NOT MODFIY THE LIST. 
	public int maxSubArray(final List<Integer> a) {
	    if (a.isEmpty()) return 0;
	    if (a.size() == 1) return a.get(0);


        int currentMaxSum = 0;
        int sum = 0;
        boolean posNumExists = false;
        
        for (int i = 0; i < a.size(); i++) {
            int num = a.get(i);
            if (num > 0) {
                posNumExists = true;
            }
            
            if (sum + num > 0) {
                sum += num;
            } else {
                sum = 0;
            }
            currentMaxSum = Math.max(currentMaxSum, sum);
        }
        
        // No Positive numbers findall
        if (!posNumExists) {
            currentMaxSum = Integer.MIN_VALUE;
            for (int i = 0; i < a.size(); i++) {
                int num = a.get(i);
                currentMaxSum = Math.max(currentMaxSum, num);
            }
        }
        
        return currentMaxSum;
	}
}
