
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}

		int i=0;
		while (commonAt(i, strs)) {
			i++;
		}
		return strs[0].substring(0, i);
	}

	private boolean commonAt(int pos, String[] strs) {
		if (pos >= strs[0].length()) {
			return false;
		}

		char c = strs[0].charAt(pos);
		for (int i=1; i<strs.length; i++) {
			//consider out of range
			if (pos >= strs[i].length()) {
				return false;
			}
			if (c != strs[i].charAt(pos)) {
				return false;
			}
		}
		return true;
	}
}