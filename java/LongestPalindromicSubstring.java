

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		if (s.length() == 1) {
			return s;
		}

		boolean[][] isPal = new boolean[s.length()][s.length()];
		isPal[0][0] = true;
		int max = 0;
		int startIndex = 0;
		for (int i=1; i<s.length(); i++) {
			isPal[i][i] = true;
			isPal[i-1][i] = s.charAt(i-1) == s.charAt(i);
			if (isPal[i-1][i]) {
				max = 1;
				startIndex = i-1;
			}
		}


		//isPal[i][j] = isPal[i+1][j-1] ? s.charAt(i) == s.charAt(j) : false;   j-1 >= i+1 
				for (int size = 2; size<s.length(); size++) {
					for (int i=0; i<s.length() - size; i++) {
						isPal[i][i+size] = isPal[i+1][i+size-1] ? s.charAt(i) == s.charAt(i+size) : false;
						if (isPal[i][i+size]) {
							max = size;
							startIndex = i;
						}
					}
				}

				return s.substring(startIndex, startIndex+max+1);
	}
}
