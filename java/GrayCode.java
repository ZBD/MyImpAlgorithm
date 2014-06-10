import java.util.ArrayList;


public class GrayCode {
	//we can do it recursively, noticed that 8 is build on 4 by copy it twice and revert the second part sequence then add 1 at front 
	//n is not the number of numbers, its the number of bits
	public ArrayList<Integer> grayCode(int n) {
		return grayCodePower2(n);
	}

	private ArrayList<Integer> grayCodePower2(int n) {
		ArrayList<Integer> answer;
		if (n < 0) {
			answer = new ArrayList<Integer>();
			return answer;
		}
		if (n == 0) {
			answer = new ArrayList<Integer>();
			answer.add(0);
			return answer; 
		}
		if (n == 1) {
			answer = new ArrayList<Integer>();
			answer.add(0);
			answer.add(1);
			return answer; 
		}

		answer = grayCodePower2(n-1);
		int size = answer.size();
		for (int i=0; i<size; i++) {
			//convert pow
			answer.add(answer.get(size-i-1) + (int)Math.pow(2,n-1));
		}

		return answer;
	}
}