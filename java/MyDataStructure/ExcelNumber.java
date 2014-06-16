package MyDataStructure;

public class ExcelNumber {

	//what's the range of the number, is int big enough?
	public static int excelToNumber(String s) throws Exception {
		if (s == null || s.isEmpty()) {
			//what to return here? 0 or throw an expection?
			return 0;
		}	
		
		s = s.toUpperCase();
		int result = 0;
		for (char c : s.toCharArray()) {
			if (c >= 'A' && c <= 'Z') {
				result = result*26 + (c - 'A' + 1);	//not +=
			}
			else {
				//what if the input string is not a valid excel string?
				throw new Exception("Input: '" + s +"' is not a valid excel string");
			}
		}
		return result;
	}

	//this is hard, write the equations first, num(n) += num(n-1)*26 + (c - 'A' + 1), so c = 'A' + (num(n) - 1) % 26, num(n-1) = (num(n) - 1) / 26
	public static String numberToExcel(int num) {
		if (num <= 0) {
			//what if the input num is non positive
			return "";
		}

		StringBuilder sb = new StringBuilder();
		while (num > 0) {
			char c = (char) ('A' + ((num - 1)%26)); //should cast to char, because int size is > char
			sb.append(c); //remember StringBuilder.insert(offset, char);
			num = (num-1) / 26;
		}

		return sb.reverse().toString();
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(ExcelNumber.excelToNumber("DEADBEEF")); //how about overflow?
		System.out.println(ExcelNumber.numberToExcel(428));
	}
}