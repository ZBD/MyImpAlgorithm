
public class NextPermutation {
    public void nextPermutation(int[] num) {
        if (num == null || num.length <= 1) {
            return;
        }
        
        //find the largest index k that num[k] < num[k+1],  so i from k+1..to end, num[i] >= num[i+1], if not, then it is the largest one
        int k = findSwap1(num);
        
        if (k == -1) {
            //what to return, it is the largest, so reverse it to return the smallest
            reverse(num, 0);
            return;
        }
        //find the largest index j that num[k] < num[j], so i from j+1 to end, num[i] <= num[k] and num[k] >= num[i] >= num[i+1]
        //                                              so i from k+1..j-1, num[i] >= num[i+1], num[i] >= num[j] > num[k] > num[i] >= num[i+1]
        int j = findSwap2(num, k);
        
        //swap index k and index j, 
        swap(num, k, j);
        
        //reverse k+1...to end;   k+1 .. end is descending, reverse it makes it acseding
        reverse(num, k+1);
    }
    
    
    private int findSwap1(int[] num) {
        int k = num.length-2;
        while (k>=0 && num[k] >= num[k+1]) {
            k--;
        }
        return k;
    }
    
    private int findSwap2(int[] num, int k) {
        int j = num.length - 1;
        //it is garenteed because num[k] < num[k+1];
        while (num[k] >= num[j]) {
            j--;
        }
        return j;
    }
    
    private void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
    
    private void reverse(int[] num, int i) {
        int j = num.length-1;
        while (i < j) {
            swap(num, i++, j--);
        }
    }
}
