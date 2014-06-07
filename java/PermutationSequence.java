
public class PermutationSequence {
	public String getPermutation(int n, int k) {
		if (k <= 0) {
			return null;
		}

		int total = 1;
		for (int i=2; i<=n; i++)
			total *= i;
		if (k > total) {
			return null;
		}

		boolean[] flag = new boolean[10];
		flag[0] = true;
		for (int i=1; i<=n; i++) {
			flag[i] = false;
		}
		for (int i=n+1; i<=9; i++) {
			flag[i] = true;
		}
		return getPermutation(n, k, flag);
	}

	private String getPermutation(int n, int k, boolean[] flag) {
		int total = 1;
		for (int i=2; i<n; i++) {
			total *= i;
		}

		//should have bracekets
		int group = (k-1) / total;

		if (k % total == 0) {
			//update flag
			int j = 0;
			int count = 0;
			while (count <= group) {
				j++;
				while (flag[j] == true) {
					j++;
				}
				count++;
			}
			flag[j] = true;

			String result = "" + j;
			for (int i=9; i>=1; i--) {
				if (flag[i] == false) {
					result += i;
				}
			}
			return result;
		}
		else {
			//update flag
			int j = 0;
			int count = 0;
			while (count <= group) {
				j++;
				while (flag[j] == true) {
					j++;
				}
				count++;
			}
			flag[j] = true;
			String right = getPermutation(n-1, k%total, flag);
			flag[j] = false;
			return j + right;
		}
	}
}
