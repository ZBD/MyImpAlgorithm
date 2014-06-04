
public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int A[], int B[]) {
		// a naive way is to merge the 2 array in to 1, then find the median, o(m+n)
		// consider there is no same numbers
		// a nother way is to use binary search in A[] && B[], to find the number which is greater than (m+n) / 2 numbers in AB
		// if m + n is odd, then the number is median, other wise, the number is the large on of the 2 numbers we need to caclulate
		// the median. We do the binary search again to find the small one greater than (m+n-1)/2 numbers in AB
		// suppose A[i] should greater than k numbers in AB, A[i] is greater than i items in A, so A[i] need to greater than k - i numbers in B,
		// so B[k-i-1] <= A[i] <= B[k-i],  if not, A[i] is not the number we want, 
		// if A[i] < B[k-i-1], A[i] is greater less than k-i numbers in B, so A[i] is greater less than k numbers in AB, we need increase A[i], so search in right part in A
		// if A[i] > B[k-i], A[i] is greater more than k-i numbers in B, so A[i] is greater more than k numbers in AB, we need to decrease A[i], so search in left part in A
		// if not find in A, then must fint it in B


		// corner case A is null or A is empty
		if (A == null || A.length == 0) {
			if (B == null || B.length == 0) {
				return 0;
			}
			else {
				return B.length % 2 == 0 ? (B[B.length / 2] + B[B.length / 2 - 1]) / 2.0 : B[B.length / 2];
			}
		}

		if (B == null || B.length == 0) {
			// A is not null, because if A is null, it will return already
			return A.length % 2 == 0 ? (A[A.length / 2] + A[A.length / 2 - 1]) / 2.0 : A[A.length / 2];
		}

		//A != null && B != null
		int length = A.length + B.length;
		if (length % 2 == 0) {
			//find the one greater than length/2 and length/2-1
			return (findKthNumber(A, B, length/2) + findKthNumber(A, B, length/2-1)) / 2.0;

		}
		else {
			//find the one greater than length/2
			return findKthNumber(A, B, length/2);
		}
	}

	private int findKthNumber(int A[], int B[], int k) {
		//try to find that in A

		//make sure j-1 >=0 
		int l = 0, r = Math.min(A.length-1, k), m = 0;
		while (l <= r) {
			m = (l + r) / 2;
			int j = k-m;
			//make sure j-1 >=0 

			//consider out of boundry j
			if (j == 0) {
				if (A[m] <= B[j]) {
					return A[m];
				}
				else {
					r = m - 1;
				}
			}
			else if (j == B.length) {
				if (A[m] >= B[j-1]) {
					return A[m];
				}
				else {
					l = m + 1;
				}
			}
			else if (j > B.length) {
				l = m + 1;
			}
			else if (A[m] >= B[j-1] && A[m] <= B[j]) {
				return A[m];
			}
			else if (A[m] < B[j-1]) {
				l = m + 1;
			}
			else {
				r = m - 1;
			}
		}

		//not find in A, try to find in B
		l = 0; 
		r = Math.min(B.length-1, k);
		m = 0;
		while (l <= r) {
			m = (l + r) / 2;
			int j = k - m;
			//make sure j-1 >=0 
					if (j == 0) {
						if (B[m] <= A[j]) {
							return B[m];
						}
						else {
							r = m - 1;
						}
					}
					else if (j == A.length) {
						if (B[m] >= A[j-1]) {
							return B[m];
						}
						else {
							l = m + 1;
						}
					}
					else if (j > A.length) {
						l = m + 1;
					}
					else if (B[m] >= A[j-1] && B[m] <= A[j]) {
						return B[m];
					}
					else if (B[m] < A[j-1]) {
						l = m + 1;
					}
					else {
						r = m - 1;
					}
		}

		//unreachable if input are valid
		return Integer.MAX_VALUE;
	}
}