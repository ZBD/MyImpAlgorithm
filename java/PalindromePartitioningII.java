
public class PalindromePartitioningII {
	public int minCut(String s) {
		//validate the input
		if (s == null || s.length() <= 1) {
			return 0;
		}

		int len = s.length();
		//isPal[i][j] = true means s.substring(i, j+1) is palindrome 
		boolean[][] isPal = getIsPalMatrix(s);


		// it is O(n^3), too slow,  you can simplify the equations
		// //minCut[i][j] denotes the min cuts we need to cut the s.substring(i, j+1);
		// //minCut[i][j] = minCut[i][k-1] + 1 + minCut[k][j] if isPal[i][j] == false
		// //             = 0 if isPal[i][j] == true
		// int[][] minCut = new int[len][len];
		// for (int l=2; l<=len; l++) {
		//     for (int i=0; i+l<=len; i++) {
		//         int j = i+l-1;
		//         if (isPal[i][j]) {
		//             minCut[i][j] = 0;
		//         }
		//         else {
		//             minCut[i][j] = j-i;
		//             for (int k=i+1; k<=j; k++) {
		//                 minCut[i][j] = Math.min(minCut[i][j], minCut[i][k-1] + 1 + minCut[k][j]);
		//             }
		//         }
		//     }
		// }
		// return minCut[0][len-1];

		//minCut[i] means the min cuts we need to cut the s.substring(0, i+1);
		//minCut[0] = 0;
		//minCut[i] = 0 if isPal[0][i]
		//          = min(minCut[j] + 1 if isPal[j+1][i]) 

		//if the string is a palindrome, return 0 
		if (isPal[0][len-1]) {
			return 0;
		}

		//DP minCut
		int[] minCut = new int[len];
		for (int i=1; i<len; i++) {
			if (isPal[0][i]) {
				minCut[i] = 0;
			}
			else {
				minCut[i] = i;
				for (int j=0; j<i; j++) {
					if (isPal[j+1][i]) {
						minCut[i] = Math.min(minCut[i], minCut[j]+1);
					}
				}
			}
		}
		return minCut[len-1];
	}

	private boolean[][] getIsPalMatrix(String s) {
		int len = s.length();
		boolean[][] isPal = new boolean[len][len];

		//DP
		//calculate isPal
		//base case1
		//sub string length is 1
		for (int i=0; i<len; i++) {
			isPal[i][i] = true;
		}
		//base case 2
		//sub string length is 2
		for (int i=1; i<len; i++) {
			isPal[i-1][i] = s.charAt(i-1) == s.charAt(i);
		}

		//sub string lenth is k
		//pay attention to the calculate sequence
		for (int k=3; k<=len; k++) {
			for (int i=0; i+k<=len; i++) {
				isPal[i][i+k-1] = s.charAt(i) == s.charAt(i+k-1) ? isPal[i+1][i+k-2] : false;
			}
		}

		return isPal;
	}
}