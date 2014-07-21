
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		//you should ask is the number considered alphanumeric characters, yes.

		if (s == null) {
			return true;
		}
		//string is length() not length
		if (s.length() <= 1) {
			return true;
		}
		//toLowerCase(), toCharArray() not to Array()
		char[] sch = s.toLowerCase().toCharArray();
		int head = 0, tail = sch.length-1;
		while (head < tail) {
			while (head<tail && !check(sch[head])) {
				head++;
			}
			while(head<tail && !check(sch[tail])) {
				tail--;
			}
			if (head<tail) {
				if (sch[head] != sch[tail]) 
					return false;
				head++;
				tail--;
			}
		}
		return true;
	}

	private boolean check(char c) {
		if (c >= 'a' && c <= 'z') {
			return true;
		}
		else if (c >= '0' && c<='9') {
			return true;
		}
		else {
			return false;
		}
	}
}