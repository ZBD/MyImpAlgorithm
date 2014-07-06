public class CombinationSumII {
    List<List<Integer>> answers;
    List<Integer> answer;
    
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        answers = new ArrayList<List<Integer>>();
        answer = new ArrayList<Integer>();
        
        if (target < 0 || num == null || num.length == 0) {
            answers.add(new ArrayList<Integer>());
            return answers;
        }
        
        Arrays.sort(num);
        backtracking(num, 0, target);
        return answers;
    }
    
    private void backtracking(int[] num, int pos, int target) {
        if (target == 0) {
            //a solution found
            answers.add(new ArrayList<Integer>(answer));
            return;
        }
        
        if (pos < num.length && num[pos] <= target) {
            //use num[pos]
            answer.add(num[pos]);
            backtracking(num, pos+1, target-num[pos]);
            //restore answer after backtracking
            answer.remove(answer.size()-1);
            
            //don't use num[pos] and all the number same with num[pos] after pos
            int newPos = pos+1;
            while (newPos < num.length && num[newPos] == num[pos]) {
                newPos++;
            }
            if (newPos < num.length) {
                backtracking(num, newPos, target);
            }
        }
    }
    
}
