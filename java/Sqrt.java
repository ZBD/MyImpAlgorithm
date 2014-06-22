
public class Sqrt {
	public int sqrt(int x) {
		if (x <= 0) {
			return 0;
		}
		if (x <= 1) {
			return x;
		}
		int low = 0, high = x;
		//there should be low + 1
		while (low + 1 < high) {
			int mid = low+ (high - low) / 2;
			int tmp = x / mid;
			//mid * mid may be larger than int, so there should be x/mid
			if (tmp == mid) {
				return mid;
			}
			else if (tmp > mid) {
				low = mid;//remember bineary search
			}
			else {
				high = mid;//remember bineary search
			}
		}
		return low;//remember what to return
	}
}