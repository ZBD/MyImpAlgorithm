
public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		//To see whether it has a solution or not, check the total sum of gain is no less than 0
		int total = 0;
		int max = -1;
		int index = -1;
		int answer = -1;
		int[] gain = new int[gas.length*2];
		for (int i=0; i<gas.length; i++) {
			gain[i] = gas[i] - cost[i];
			total += gain[i];
		}

		if (total < 0) 
			return -1;

		//It's a circular route, so expand the list 2*length - 1
		//The problem transfer to find the largest num section, the largest num section's begin index is the answer if it is greater than 0
		total = -1;
		for (int i=0; i<gas.length*2-1; i++) {
			int j = i % gas.length;
			if (total < 0 && gain[j] >= 0)  {
				index = j;
				total = gain[j];
			} 
			else {
				total += gain[j];
			}
			if (total > max) {
				max = total;
				answer = index;
			}
		}

		if (max < 0) 
			return -1;
		else 
			return answer;

	}
}
