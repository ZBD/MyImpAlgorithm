import java.util.*;


public class Subsets {
	public List<List<Integer>> subsets(int[] S) {
		if (S == null || S.length == 0) {
			return new ArrayList<List<Integer>>();
		}

		Arrays.sort(S);

		return subsets(S, 0);
	}

	private List<List<Integer>> subsets(int[] S, int pos) {
		List<List<Integer>> solutions = new ArrayList<List<Integer>>();
		if (pos == S.length) {
			solutions.add(new ArrayList<Integer>());
			return solutions;
		}

		List<List<Integer>> tmp = subsets(S, pos+1);
		for (List<Integer> list : tmp) {
			List<Integer> newList = new ArrayList<Integer>(list);
			newList.add(0, S[pos]);
			solutions.add(list);
			solutions.add(newList);
		}
		return solutions;
	}
}