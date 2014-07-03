
public class BestTimetoBuyandSellStockIII {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1) {
			return 0;
		}

		int length = prices.length;


		//we can do this by o(n) same as I
		//break the day into 2 timeslots
		//think about what will happen a new price come in
		int[] part1 = new int[length];
		int[] part2 = new int[length];

		int vally = prices[0];


		for (int i=1; i<length; i++) {
			vally = Math.min(vally, prices[i]);
			part1[i] = Math.max(part1[i-1], prices[i] - vally);
		}

		int peak = prices[length-1];
		for (int i=length-2; i>=0; i--) {
			peak = Math.max(peak, prices[i]);
			part2[i] = Math.max(part2[i+1], peak - prices[i]);
		}

		int answer = 0;
		for (int i=0; i<length; i++) {
			answer = Math.max(answer, part1[i]+part2[i]);
		}
		return answer;
	}
}