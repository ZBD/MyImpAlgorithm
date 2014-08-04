public class TwoSum {
    //using 2 pointers
    
    class MyNumber {
        public int val;
        public int index;
        MyNumber(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
    
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length <= 1) {
            return null;
        }
        
        MyNumber[] myNum = getMyNumber(numbers);
        Arrays.sort(myNum, new Comparator<MyNumber>() {
            @Override
            public int compare(MyNumber n1, MyNumber n2) {
                return n1.val - n2.val;
            }
        });
        
        int[] answer = {-1, -1};
        int l=0, r=myNum.length-1;
        while (l <= r) {
            if (myNum[l].val + myNum[r].val == target) {
                answer[0] = Math.min(myNum[l].index, myNum[r].index);
                answer[1] = Math.max(myNum[l].index, myNum[r].index);
                return answer;
            }
            else if (myNum[l].val + myNum[r].val < target) {
                l++;
            }
            else {
                r--;
            }
        }
        
        return answer;
    }
    
    private MyNumber[] getMyNumber(int[] num) {
        MyNumber[] myNum = new MyNumber[num.length];
        
        for (int i=0; i<num.length; i++) {
            myNum[i] = new MyNumber(i+1, num[i]);    
        }
        
        return myNum;
    }
    
    
    //using hashmap
    public int[] twoSum2(int[] numbers, int target) {
        if (numbers == null || numbers.length <= 1) {
            return null;
        }
        
        List<Integer> answer = new ArrayList<Integer>();
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        List<Integer> list;
        for (int i=0; i<numbers.length; i++) {
            if (map.get(target - numbers[i]) == null) {
                if ((list = map.get(numbers[i])) == null) {
                    list = new ArrayList<Integer>();
                    list.add(i);
                    map.put(numbers[i], list);
                }
                else {
                    list.add(i);
                }
            }
            else {
                list = map.get(target - numbers[i]);
                for (int pair : list) {
                    answer.add(pair+1);
                    answer.add(i+1);
                }
            }
        }
        int[] arrayAnswer = new int[answer.size()];
        for (int i=0; i<answer.size(); i++) {
            arrayAnswer[i] = answer.get(i);
        }
        return arrayAnswer;
    }
}