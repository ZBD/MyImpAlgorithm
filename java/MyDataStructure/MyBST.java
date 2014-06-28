import java.util.*;


class MyClass {  
	public static boolean isPowerOfTwo(int a) {
		if (a <= 0) {
			return false;
		}

		while (a > 1) {
			if ((a / 2 > 0) && (a % 2 == 1)) {
				return false;
			}
			a /= 2;
		}    

		return true; 
	}


	public static void main(String[] args) {
		System.out.println(MyClass.isPowerOfTwo(0));
		System.out.println(MyClass.isPowerOfTwo(1));
		System.out.println(MyClass.isPowerOfTwo(2));
		System.out.println(MyClass.isPowerOfTwo(3));
		System.out.println(MyClass.isPowerOfTwo(16));
		System.out.println(MyClass.isPowerOfTwo(18));
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}

public class MyBST {
	public static TreeNode buildBalancedBST(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}

		return buildBalancedBST(arr, 0, arr.length-1);
	}

	public static TreeNode buildBalancedBST(int[] arr, int start, int end) {
		if (start > end) {
			return null;
		}
		else if (start == end) {
			return new TreeNode(arr[start]);
		}

		int mid = start + (end - start) / 2;
		TreeNode node = new TreeNode(arr[mid]);
		node.left = buildBalancedBST(arr, start, mid-1);
		node.right = buildBalancedBST(arr, mid+1, end);

		return node;
	}

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 6, 8, 10, 15};
		TreeNode root = MyBST.buildBalancedBST(arr);
		//check whether root is balanced BST
	}
}

//		Given unsorted array
//		Output an array sorted in this fashion: s1 <= s2 >= s3 <= s4 …
//
//		Sort array
//		pick the smallest in the remain append to the new array, pick largest in the remain append to new array. Keep doing this until there is no element left.
//		O(n log n) 


class FashionSort {
	public static int[] fashionSort(int[] arr) {
		if (arr == null || arr.length == 0) {
			return arr;
		}

		int[] output = new int[arr.length];

		Arrays.sort(arr);

		int s = 0, l = arr.length-1, pos = 0;
		while (s <= l) {
			output[pos++] = arr[s++];
			if (s <= l) {
				output[pos++] = arr[l--];
			}
		}

		return output;
	}

	// It is wrong
//	public static void fashionSortInPlace(int[] arr) {
//		if (arr == null || arr.length == 0) {
//			return;
//		}
//
//		Arrays.sort(arr);
//
//		int pos = 0, l = arr.length-1, small = arr[0];
//		int mid = arr.length / 2;
//		while (pos < arr.length - 1) {
//			arr[pos] = small;
//			small = arr[pos+1];
//			arr[pos+1] = arr[l--];
//			pos += 2;
//		}
//	}

	// test case
	// 1 2 3 4 5 6 7 8 9 10        mid = 5,
	// 1 <= 10 >= 2 <= 9 >= 3 <= 8 >= 4 <= 7 >= 5 <= 6

	/* pos = 2
		   arr: 1 10
		   small: 2
	 */
	// 1 2 3 4   mid = 1;
	// 1 <= 4 >= 2 <= 3
	/* pos = 0
		   arr:
		   small:
	 */

	public static void main(String[] args) {
		int[] test = {1,2,3,4,5,6,7,8,9,10,11};
		int[] output = FashionSort.fashionSort(test);
//		fashionSortInPlace(test);
		for (int a : test) {
			// check the test manually
			System.out.print(a + " ");
		}
	}
}
