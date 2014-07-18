
public class Candy {
	private int[] ratings;

	public int candy(int[] ratings) {
		if (ratings.length == 0) {
			return 0;
		}
		else if (ratings.length == 1) {
			return 1;
		}

		this.ratings = ratings;

		int[] candy = new int[ratings.length];
		int tip = 0, vally = 0;
		for (int i=0; i<ratings.length; i++) {
			if (isVally(i)) {

				candy[i] = 1;
				vally = i;
				for (int j=i-1; j>tip; j--) {
					// 	if (ratings[j] > ratings[j+1])
						candy[j] = candy[j+1] + 1;
					// 	else 
						// 		candy[j] = candy[j+1];
				}
				if (tip != vally) {
					if (tip == 0) {
						// 	if (ratings[tip] > ratings[tip + 1]) {
						candy[tip] = candy[1] + 1;
						// 	}
						// 	else candy[tip] = 1;
					}
					else {
						//this is wrong, because tip may be equal to one of them
						int a=0, b=0;
						// 	if (ratings[tip] > ratings[tip - 1]) {
						a = candy[tip - 1] + 1;
						// 	}
						//this is nesscesary because tip+1 can also be tip as well, the rating is same with tip, so tip no need to greater than tip+1
						if (ratings[tip] > ratings[tip + 1]) {
							b = candy[tip + 1] + 1;
						}
						candy[tip] = max(a,b);
					}
				}
				while (i<ratings.length && isVally(i)) {
					candy[i] = 1;
					vally = i;
					i++;
				}
				//climb hill to find new tip
				while (i<ratings.length && !isTip(i)) {
					i++;
				}
				tip = i;
				if (vally != tip) {
					for (int j=vally+1; j<tip; j++) {
						// 	if (ratings[j] > ratings[j-1])
						candy[j] = candy[j-1] + 1;
						// 	else 
						// 		candy[j] = candy[j-1];
					}
					if (tip < ratings.length) {
						candy[tip] = tip - vally + 1;
					}
				}
			}
		}
		int answer = 0;
		for (int i=0; i<ratings.length; i++) {
			answer += candy[i];
		}
		return answer;
	}

	public int max(int a, int b) {
		return a > b ? a : b;
	}

	public boolean isVally(int i) {
		if (i == 0) {
			return ratings[0] <= ratings[1];
		} 
		else if (i == (ratings.length - 1)) {
			return ratings[ratings.length - 1] <= ratings[ratings.length - 2];
		}
		else {
			return (ratings[i-1] >= ratings[i]) && (ratings[i] <= ratings[i+1]);
		}
	}

	public boolean isTip(int i) {
		if (i == 0) {
			return ratings[0] > ratings[1];
		}
		else if (i == (ratings.length - 1)) {
			return ratings[ratings.length-1] > ratings[ratings.length-2];
		}
		else {
			return ((ratings[i-1] < ratings[i]) && (ratings[i] >= ratings[i+1])) || ((ratings[i-1] <= ratings[i]) && (ratings[i] > ratings[i+1]));
		}
	}

}