public class SolutionWaveArray {
	public ArrayList<Integer> wave(ArrayList<Integer> a) {
	    if (a.isEmpty() || a.size() == 1) return a;
	    
	    Collections.sort(a);
	    ArrayList<Integer> list = new ArrayList<>();
	    
	    for (int i = 0; i+1 < a.size(); i+=2) {
	        int num = a.get(i);
	        int next = a.get(i+1);
	        list.add(next);
	        list.add(num);
	    }
	    
	    // isOdd just append last num
	    if (a.size() % 2 !=0) {
	        list.add(a.get(a.size()-1));
	    } 
	    
	    return list;
	}
}
