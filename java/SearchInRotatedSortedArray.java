public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }
        
        int l = 0, h = A.length - 1;
        while (l <= h) {
            int m = l + (h-l)/2;
            if (A[m] == target) {
                return m;
            }
            else if (A[l] <= A[m]) {
                //pivot is not in l..m
                if (A[l] <= target && target < A[m]) {
                    //target is in l..m-1
                    h = m - 1;
                }
                else {
                    //target is in m+1..h
                    l = m + 1;
                }
            }
            else {
                //pivot is in l..m
                //pivot is not in m..h
                if (A[m] < target && target <= A[h]) {
                    //target is in m+1..h
                    l = m + 1;
                }
                else {
                    //target is in l..m-1
                    h = m -1;
                }
            }
        }
        
        return -1;
        
    }
}