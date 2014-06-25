import java.util.*;


public class PalindromePartitioning {
	    public List<List<String>> partition(String s) {
	        List<List<String>> result = dfsPartition(s);
	        return result == null ? new ArrayList<List<String>>() : result;
	    }
	    
	    public boolean isPalindrome(String s) {
	        int head = 0, tail = s.length() - 1;
	        while( head < tail) {
	            if (s.charAt(head) != s.charAt(tail)) {
	                return false;
	            }
	            head++;
	            tail--;
	        }
	        return true;
	    }
	    
	    private List<List<String>> dfsPartition(String s) {
	        if (s == null || s.equals("")) {
	            return null;
	        }
	        
	        int length = s.length();
	        List<List<String>> result  = new ArrayList<List<String>>();
	        for (int i=length-1; i>=0; i--) {
	            if (isPalindrome(s.substring(i))) {
	                List<List<String>> tmp = dfsPartition(s.substring(0, i));
	                addWord(s.substring(i), tmp, result);
	            }
	        }
	        return result;
	    }
	    
	    private void addWord(String w, List<List<String>> arr, List<List<String>> result) {
	        //I use return too much, is that a good practice?
	        if (w == null || w.equals("")) {
	            return;
	        }
	        
	        if (result == null) {
	            //print something
	            return;
	        }
	        
	        if (arr == null) {
	            ArrayList<String> tmp = new ArrayList<String>();
	            tmp.add(w);
	            result.add(tmp);
	            return;
	        }
	        
	        int size = arr.size();
	        for (int i=0; i<size; i++) {
	            arr.get(i).add(w);
	            result.add(arr.get(i));
	        }
	        
	        return;
	    }
	}