import java.util.*;


public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> solutions = new ArrayList<List<Integer>>();
		if (candidates == null || candidates.length == 0) return solutions;

		Arrays.sort(candidates);

		return combinationSumRec(candidates, 0, target);
	}

	//recursively
	private List<List<Integer>> combinationSumRec(int[] nums, int pos, int target) {
		List<List<Integer>> solutions = new ArrayList<List<Integer>>();

		if (pos >= nums.length) {
			return solutions;
		}
		else if (nums[pos] == target) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(nums[pos]);
			solutions.add(list);
			return solutions;
		}
		else if (nums[pos] < target) {
			//use the nums[pos], 
			List<List<Integer>> tmp = combinationSumRec(nums, pos, target-nums[pos]);
			for (List<Integer> list : tmp) {
				list.add(0, nums[pos]);
				solutions.add(list);
			}

			//don't use the nums[pos], so it skips all the number same with nums[pos]
			int i = pos+1;
			while (i < nums.length && nums[i] == nums[i-1]) i++;
			if (i < nums.length) {
				tmp = combinationSumRec(nums, i, target);
				solutions.addAll(tmp);
			}
		}

		return solutions;
	}

//	//iteratively is so hard
//	private List<List<Integer>> combinationSumIter(int[] candidates, int target) {
//
//		Map<Integer, List<List<Integer>>> solutionMap = new HashMap<Integer, List<List<Integer>>>();
//		solutionMap.put(0, new ArrayList<List<Integer>>());
//
//		for (int num : candidates) {
//			int newTarget = target;
//			List<List<Integer>> solutions = new ArrayList<List<Integer>>();
//			List<Integer> solution = new ArrayList<Integer>();
//			while (newTarget >= 0) {
//				List<List<Integer>> tmp = solutionMap.get(newTarget);
//				if (tmp != null) {
//					for (List<Integer> list : tmp) {
//						List<Integer> newSolution = new ArrayList<Integer>(solution);
//						newSolution.addAll(list);
//						solutions.add(newSolution);
//					}
//				}
//				solution.add(num);
//				newTarget -= num;
//			}
//		}
//	}
}