
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		//is negative number palindrome?
		if (x < 0) {
			return false;
		}

		int t = 1;
		while ((x / t)/10 > 0) {
			t = t*10;
		}
		if (t == 1) {
			return true;
		}

		while (t > 1) {
			int d1 = x / t;
			int d2 = x % 10;
			if (d1 != d2) {
				return false;
			}
			x = x % t;
			x = x / 10;
			t = t / 100;
		}
		return true;
	}
}