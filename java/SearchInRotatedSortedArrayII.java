
public class SearchInRotatedSortedArrayII {
	public boolean search(int[] A, int target) {
		if (A == null || A.length == 0) {
			return false;
		}

		int l = 0, h = A.length-1;
		while (l <= h) {
			int m = l + (h-l)/2;
			if (A[m] == target) {
				return true;
			}
			else if (A[l] < A[m]) {
				//pivot is not in l..m
				if (A[l] <= target && target < A[m]) {
					h = m - 1;
				}
				else {
					l = m + 1;
				}
			}
			else if (A[h] > A[m]) {
				//pivot is not in m..h
				if (A[m] < target && target <= A[h]) {
					l = m + 1;
				}
				else {
					h = m - 1;
				}
			}
			else {
				//we don't know whether pivot is in l..h
				if (A[l] == target) {
					return true;
				}
				else if (A[h] == target) {
					return true;
				}
				else {
					l++;
					h--;
				}
			}
		}
		return false;
	}
}
