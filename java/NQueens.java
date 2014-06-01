import java.util.*;


public class NQueens {
	    List<String[]> solutions;  
	    int[] position;
	    
	    public List<String[]> solveNQueens(int n) {
	        //use arraylist to new
	        solutions = new ArrayList<String[]>();
	        position = new int[n];
	        if (n == 0) {
	            //ask interviewer what suppose to return in this corner case
	            solutions.add(new String[0]);
	            return solutions;
	        }
	        
	        if (n == 1) {
	            String[] s = new String[1];
	            s[0] = "Q";
	            solutions.add(s);
	            return solutions;
	        }
	        
	        dfs(0, n);
	        return solutions;
	    }
	    
	    //place th th of n queens
	    private void dfs(int th, int n) {
	        int i=0;
	        while (i < n) {
	            if (valid(i, th)) {
	            	
	                //valid---put th queen at column i;
	                position[th] = i;
	                printSolution(th, n);
	                if (th == n) {
	                    //solution found
	                    String[] s = new String[n];
	                    StringBuilder sb = new StringBuilder();
	                    //do not use i, i has already defined;
	                    for (int k=0; k<n; k++) {
	                        sb.append(".");
	                    }
	                    for (int k=0; k<n; k++) {
	                        //remember StringBuilder basic method
	                        sb.setCharAt(position[k], 'Q');
	                        s[k] = sb.toString();
	                        sb.setCharAt(position[k], '.');
	                    }
	                    solutions.add(s);
	                }
	                else 
	                    dfs(th+1, n);
	            }
	            i++;
	        }
	    }
	    
	    private void printSolution(int th, int n) {
	    	System.out.println("==========");
            String[] s = new String[n];
            StringBuilder sb = new StringBuilder();
            //do not use i, i has already defined;
            for (int k=0; k<n; k++) {
                sb.append(".");
            }
            for (int k=0; k<=th; k++) {
                //remember StringBuilder basic method
                sb.setCharAt(position[k], 'Q');
                s[k] = sb.toString();
                sb.setCharAt(position[k], '.');
            }
            for (int i=0; i<=th; i++) {
            	System.out.println(s[i]);
            }
	    }
	    
	    private boolean valid(int pos, int th) {
	        for (int i=0; i<th; i++) {
	            if (position[i] == pos) {
	                return false;
	            }
	            if (pos - position[i] == th - i || pos - position[i] == i - th) {
	                return false;
	            }
	        }
	        return true;
	    }
	    
	    //static should always before void
	    public static void main(String[] args) {
	    	NQueens q = new NQueens();
	    	System.out.println(q.solveNQueens(4).toString());
	    }
	}