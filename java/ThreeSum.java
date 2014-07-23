import java.util.*;


public class ThreeSum {
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		//use set to de duplicate
		Set<List<Integer>> set = new HashSet<List<Integer>>();

		if (num == null || num.length < 3) {
			return lists;
		}


		//sort num
		Arrays.sort(num);

		//select 1 number from num, denote as num[i], do 2 sum in the rest(num[i+1...n], -num[i])
		//because we don't want duplicate triplets, so it is enough to do 2 sum in num[i+1...n]
		for (int i=0; i<num.length-2; i++) {
			List<List<Integer>> tmp = twoSum(num, i, set);
			for (List<Integer> list : tmp) {
				if (!set.contains(list)) {
					set.add(list);
					lists.add(list);
				}
			}
		}

		return lists;
	}

	private List<List<Integer>> twoSum(int[] num, int i, Set<List<Integer>> set) {
		//num[i] as target, do 2 sum in the num[i+1 .. n]
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		int target = -num[i];
		int l = i+1, r = num.length - 1;
		while (l < r) {
			if (num[l] + num[r] == target) {
				//found one;
				List<Integer> tmp = new ArrayList<Integer>();
				tmp.add(num[i]);
				tmp.add(num[l]);
				tmp.add(num[r]);
				if (!set.contains(tmp)) {
					list.add(tmp);
				}
				l++;
				r--;
			}
			else if (num[l] + num[r] < target) {
				l++;
			}
			else {
				r--;
			}
		}
		return list;
	}
}