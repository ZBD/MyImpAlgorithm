import java.util.ArrayList;

public class Combinations {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result;
        if (n <= 0 || k<0 || n < k) {
            result = new ArrayList<ArrayList<Integer>>();
            return result;
        }
        
        return combine(n, 1, k);
    }
    
    private ArrayList<ArrayList<Integer>> combine(int n, int pos, int k) {
        ArrayList<ArrayList<Integer>> result;
        
        if (k == 0) {
        	 result = new ArrayList<ArrayList<Integer>>();
        	 ArrayList<Integer> tmp = new ArrayList<Integer>();
        	 result.add(tmp);
             return result;
        }

        if ( pos + k - 1 == n) {
            result = new ArrayList<ArrayList<Integer>>();
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            for (int i=pos; i<=n; i++) {
                tmp.add(i);
            }
            result.add(tmp);
            return result;
        }
        
        //add pos
        result = combine(n, pos+1, k-1);
        for (int i=0; i<result.size(); i++) {
            result.get(i).add(0, pos);
        }
        
        //not add pos
        ArrayList<ArrayList<Integer>> tmp = combine(n, pos+1, k);
        for (int i=0; i<tmp.size(); i++) {
            result.add(tmp.get(i));
        }
        return result;
    }
    
    private void printAnswer(ArrayList<ArrayList<Integer>> answer) {
    	System.out.println('[');
    	for (int i=0; i<answer.size(); i++) {
    		System.out.print('[');
    		for (int j=0; j<answer.get(i).size(); j++) {
    			System.out.print(answer.get(i).get(j)+",");
    		}
    		System.out.println("],");
    	}
    	System.out.println(']');
    }
    
    public static void main(String args[]) {
    	Combinations solution = new Combinations();
    	ArrayList<ArrayList<Integer>> answer = solution.combine(4, 2);
    	solution.printAnswer(answer);
    }
}
