import java.util.List;


public class InsertIntervalBinarySearch {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        //one naive way, we can append the newInterval to the end of intervals and merge all the interleaving intervals. This method, we dont need the intervals to be sorted and disjoint. 

	    //however the intervals are sorted and disjoint, so we can do it more fast and simple.
	
	    //firt where to insert, search according to start and end, use Binary Search to speed up.
	    int startIndex = findInsertIndexByStart(intervals, newInterval);
	    int endIndex = findInsertIndexByEnd(intervals, newInterval);
	

        if (startIndex <= endIndex) {
        	// the newInterval overlapping with intervals from startIndex to endIndex
            mergeAndInsert(intervals, newInterval, startIndex, endIndex);
        }
        //else, the newInterval is contained by an old one, no need to insert
        
        return intervals;
    }
    
	private void mergeAndInsert(List<Interval> intervals, Interval newInterval, int startIndex, int endIndex) {
		if (endIndex < startIndex) {
			return;
		}
		
		if (startIndex < intervals.size()) {
		    newInterval.start = Math.min(newInterval.start, intervals.get(startIndex).start);
	        if (endIndex < intervals.size()) {
		        if (intervals.get(endIndex).start <= newInterval.end) {
			        newInterval.end = Math.max(newInterval.end, intervals.get(endIndex).end);
		        }
            }
            int i = endIndex < intervals.size() ? endIndex : intervals.size() - 1;
            for (; i>=startIndex; i--) {
            	intervals.remove(i);
            }
            intervals.add(startIndex, newInterval);
        }
        else {
        	intervals.add(newInterval);
        }

    }

	private int findInsertIndexByStart(List<Interval> intervals, Interval newInterval) {
		return binarySearch(intervals, newInterval.start, false);
    }
	
	private int findInsertIndexByEnd(List<Interval> intervals, Interval newInterval) {
		return binarySearch(intervals, newInterval.end, false);
	}

	private int binarySearch(List<Interval> intervals, int val, boolean usingStart) {
		int low = 0, high = intervals.size() - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2; //using (low + high) / 2 may overflow 
			int midValue = usingStart ? intervals.get(mid).start : intervals.get(mid).end;
			if (midValue == val) {
				return mid;
            }
            else if (midValue < val) {
                low = mid + 1;	
            }
            else {
            	high = mid-1;
            }
        }
        return low;
    }
	
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
}