public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        if (num == null || num.length < 3) {
            //ask interviewer
            return -1;
        }
        
        Arrays.sort(num);
        int closest = target-1;
        for (int i=0; i<num.length-2 && closest != target; i++) {
            int tmp = twoSum(num, i, target, closest, i == 0);
            if (i == 0 || tmp != closest) {
                closest = tmp; 
            }
        }
        return closest;
    }
    
    
    private int twoSum(int[] num, int pos, int target, int closest, boolean firstTime) {
        int newTarget = target - num[pos];
        int l = pos+1, r = num.length - 1;
        while (l < r) {
            if (num[l] + num[r] == newTarget) {
                return target;
            }
            else if (num[l] + num[r] < newTarget) {
                if (firstTime || Math.abs(target - closest) > Math.abs(num[l] + num[r] - newTarget)) {
                    closest = num[l] + num[r] + num[pos];
                    firstTime = false;
                }
                l++;
            }
            else {
                if (firstTime || Math.abs(target - closest) > Math.abs(num[l] + num[r] - newTarget)) {
                    closest = num[l] + num[r] + num[pos];
                    firstTime = false;
                }
                r--;
            }
        }
        return closest;
    }
}