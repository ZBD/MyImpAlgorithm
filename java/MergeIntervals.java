import java.util.*;


public class MergeIntervals {
	/**
	 * Definition for an interval.
	 * public class Interval {
	 *     int start;
	 *     int end;
	 *     Interval() { start = 0; end = 0; }
	 *     Interval(int s, int e) { start = s; end = e; }
	 * }
	 */
	    public List<Interval> merge(List<Interval> intervals) {
	        //how to use Collections.sort 
	        //how to write your own sort
	        
	        if (intervals == null || intervals.size() <= 1) {
	            return intervals;
	        }
	        
	        Collections.sort(intervals, new Comparator<Interval>() {
	            @Override
				public int compare(Interval i1, Interval i2) {
	                if (i1.start < i2.start) {
	                    return -1;
	                }
	                else if (i1.start == i2.start) {
	                    return i1.end - i2.end;
	                }
	                else 
	                    return 1; 
	            }
	        });
	        
	        int i=1;
	        while (i < intervals.size()) {
	            if (isOverlapping(intervals.get(i-1), intervals.get(i))) {
	                merge(intervals, i-1);
	            }
	            else {
	                i++;
	            }
	        }
	        return intervals;
	    }
	    
	    private boolean isOverlapping(Interval i1, Interval i2) {
	        //here because the intervals are sorted, we are sure that i1.start < i2.start || (i1.start == i2.start && i1.end < i2.end)
	        if (i1.end < i2.start) {
	            return false;
	        }
	        else {
	            //i1.end >= i2.start
	            return true;
	        }
	    }
	    
	    private void merge(List<Interval> intervals, int index) {
	        //here we are sure that interval at index are overlapping with intervals at index+1, and they are sort
	        intervals.get(index).end = Math.max(intervals.get(index).end, intervals.get(index+1).end);
	        intervals.remove(index+1);
	    }
	}

class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
}
