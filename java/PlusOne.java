
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            int[] answer = new int[1];
            answer[0] = 1;
            return answer;
        }
        
        int j = digits.length-1;
        while (j>=0 && digits[j] == 9) {
            digits[j--] = 0;

        }
        if (j < 0) {
            int[] answer = new int[digits.length+1];
            answer[0] = 1;
            return answer;
        }
        else {
            digits[j]++;
            return digits;
        }
    }
}