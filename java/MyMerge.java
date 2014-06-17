import java.io.*;
import java.util.*;

//
public class MyMerge {

	public File merge(File f1, File f2, int m) throws Exception{
		File sorted1 = sort(f1, "sort1", m);
		File sorted2 = sort(f2, "sort2", m);

		return merge(sorted1, sorted2, "merged");

	}    

	private File merge(File f1, File f2, String filename) throws Exception{
		BufferedReader in1 = new BufferedReader(new FileReader(f1));
		BufferedReader in2 = new BufferedReader(new FileReader(f2));
		PrintWriter output = new PrintWriter(filename);
		String newLine1 = in1.readLine();
		String newLine2 = in2.readLine();
		while ((newLine1 != null) || (newLine2 != null)) {
			if (newLine1 == null) {
				output.println(newLine2);
				newLine2 = in2.readLine();
			}
			else if (newLine2 == null) {
				output.println(newLine1);
				newLine1 = in1.readLine();
			}
			else {
				if (newLine1.compareTo(newLine2) < 0) {
					output.println(newLine1);
					newLine1 = in1.readLine();
				}
				else {
					output.println(newLine2);
					newLine2 = in2.readLine();
				}
			}
		}

		//append the left into result

		in1.close();
		in2.close();
		output.close();
		return new File(filename);
	}

	private File sort(File f1, String filename, int m) throws Exception{
		//validate the input

		Queue<String> minHeap = new PriorityQueue<String>();

		BufferedReader input = new BufferedReader(new FileReader(f1));
		PrintWriter output = new PrintWriter(filename);
		String newLine;
		while ((newLine = input.readLine()) != null) {
			if (minHeap.size() == m) {
				output.println(minHeap.poll());
			}
			minHeap.offer(newLine);
		}

		while (minHeap.size() != 0) {
			output.println(minHeap.poll());
		}

		input.close();
		output.close();

		return new File(filename);
	}


	public static void main(String[] args) throws Exception{
		MyMerge test = new MyMerge();
		String filename1 = args[1];
		String filename2 = args[2];
		int m = Integer.parseInt(args[3]);
		test.merge(new File(filename1), new File(filename2), m);
	}


}