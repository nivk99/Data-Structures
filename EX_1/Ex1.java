import java.util.Arrays;
/**
 * In this class you can find 2 algorithms for finding a sum of two numbers or
 *  three in an array of integers.
 * @author: Niv Kotek.
 * @I.D: 208236315.
 * @category: Task 1 - Data structures.
 */

public class Ex1 {	
	
	/////////////////////////// Q4A\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	/**
	 * This algorithm uses binary search and a recursive function.
     * The binary search finds the position of the sum in the array.
     * The recursive function divides the array by 2 and 
     * checks if there are two numbers that the sum is equal.
	 * @param a=Array.
	 * @param s=Sum.
	 * @return True or False.
	 */	
	public static boolean pairs(int[] a, int s) {// O(n)
		int middle = (s) / 2;
		int bin = (Arrays.binarySearch(a, middle));// (O(Log(n))
		if (bin < 0)
			bin = (bin * (-1)) - 1;
		return recursionPairs(a, s, bin - 1, bin);// O(n)
	}

	private static boolean recursionPairs(int[] a, int s, int left, int right) {// O(n)
		if (left == -1 || right == a.length)//Stop expression
			return false;
		if (a[left] + a[right] == s)//If a sum of two numbers is found
			return true;
		if (a[left] + a[right] < s)//If the sum is large
			right = right + 1;
		else
			left = left - 1;//If the sum is less
		return recursionPairs(a, s, left, right);
	}

	/////////////////////////// Q4B\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	/**
	 *  This algorithm uses binary search and a recursive function.
	 *  The binary search finds the position of the sum in the array.
	 *  The algorithm assumes that instead of i one of three numbers in the array is equal to the sum,
	 *  and checks by a recursive function whether there are 2 other numbers in the array that are equal to the sum
	 * @param a=Array.
	 * @param s=Sum.
	 * @return True or False.
	 */
	public static boolean triples(int[] a, int s) {// O(n^2)
		int sum, middle, bin;
		for (int i = 0, n = a.length; i < n; i++) {// n*[(n)+(Log(n)]
			sum = s - a[i];
			middle = (sum) / 2;
			bin = (Arrays.binarySearch(a, middle));// (O(Log(n))
			if (bin < 0)
				bin = (bin * (-1)) - 1;
			if (recursionTriples(a, sum, bin - 1, bin, i))// O(n)
				return true;

		}

		return false;

	}

	private static boolean recursionTriples(int[] a, int s, int left, int right, int not_index) {// O(n)
		if (left == not_index)//If equal to an index you do not want to search
			left = left - 1;

		if (right == not_index)//If equal to an index you do not want to search
			right = right + 1;

		if (left == -1 || right == a.length)//Stop expression
			return false;

		if (a[left] + a[right] == s)//If a sum of two numbers is found
			return true;

		if (a[left] + a[right] < s)//If the sum is large
			right = right + 1;

		else {
			left = left - 1;//If the sum is less
		}
		return recursionTriples(a, s, left, right, not_index);
	}

}
