public class SolutionPascalTriangle {
	public ArrayList<ArrayList<Integer>> generate(int a) {
	    ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
	    if (a == 0) return matrix;
	    
	    ArrayList<Integer> firstRow = new ArrayList<Integer>();
	    firstRow.add(1);
	    matrix.add(firstRow);
	    // a = 5
	    // 
	    for (int r = 1; r < a; r++) {
	        ArrayList<Integer> prevRow = matrix.isEmpty() ? null : matrix.get(r-1);
	        
	        int numCol = r+1;
	        
	        ArrayList<Integer> curRow = new ArrayList<Integer>();
	        
	        for (int c = 0; c < numCol; c++) {
                int col = isOutOfBounds(c, prevRow.size()) ? 0 : prevRow.get(c);
                int pCol = isOutOfBounds(c-1, prevRow.size()) ? 0 : prevRow.get(c-1);
                int sum = col + pCol;
                curRow.add(sum);
	        }
	        matrix.add(curRow);
	    }
	    return matrix;
	}
	
	public boolean isOutOfBounds(int index, int len) {
	    return index < 0 || index >= len;
	}
}