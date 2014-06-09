
public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() <=1) {
			return s == null ? 0 : s.length();
		} 

		boolean[] exists = new boolean[256];
		int i=0, j=1, max = 1;
		exists[s.charAt(0)] = true;
		while (j < s.length()) {
			if (exists[s.charAt(j)]) {
				max = Math.max(max, j - i);
				while (s.charAt(i) != s.charAt(j)) {
					exists[s.charAt(i)] = false;
					i++;
				}
				i++;
				j++;
			}
			else {
				exists[s.charAt(j)] = true;
				j++;
			}
		}

		//remember to update at last
		max = Math.max(max, j - i);

		return max;
	}
}