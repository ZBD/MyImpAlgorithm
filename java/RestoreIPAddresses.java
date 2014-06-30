import java.util.*;

public class RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
		List<String> answer = new ArrayList<String>();

		if (s == null || s.length() < 4 || s.length() > 12) {
			return answer;
		}

		int length = s.length();
		//need to deal with 0, 0 cannot be at the beginning
		for (int i=1; i<length-2; i++) {
			if (i > 3) {
				break;
			}
			String sub1 = s.substring(0,i);

			if (checkValid(sub1)) {
				for (int j=i+1; j<length-1; j++) {
					if (j-i > 3) {
						break;
					}
					String sub2 = s.substring(i,j);
					if (checkValid(sub2)) {
						for (int k=j+1; k<length; k++) {
							if (k-j > 3) {
								break;
							}
							//Integer.parseInt
							String sub3 = s.substring(j,k);
							if (checkValid(sub3)) {
								String sub4 = s.substring(k);
								if (checkValid(sub4)) {
									answer.add(sub1 + "." + sub2 + "." + sub3 + "." + sub4);
								}
							}
						}
					}
				}
			}
		}

		return answer;
	}

	private boolean checkValid(String s) {
		if (s == null || s.length() < 1 || s.length() > 3) {
			return false;
		}
		if (s.length() != 1 && s.charAt(0) == '0') {
			return false;
		}
		return Integer.parseInt(s) < 256;
	}
}