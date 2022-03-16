package Ex4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * In this class you can find a subset algorithm according to the target sum.
 * This algorithm runs at best at (n * log (n)) and at worst at (n ^ 2). This
 * algorithm uses a table data structure. This algorithm also uses merge sorting
 * that I took from the lecture.
 * 
 * @author Niv kotek @I.D 208236315
 */

public class Ex4 {
	public static List<int[]> ThreeSum(int[] arr, int target) {
		HashSet<Integer> hash = new HashSet<Integer>();
		List<int[]> ans = new LinkedList<int[]>();
		// This loop checks if there are numbers that are larger than target
		// and also that all the numbers in the array are different. O(n)
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < target)
				hash.add(arr[i]);
		}

		int[] new_arr = new int[hash.size()];
		Iterator<Integer> iter = hash.iterator();
		int j = 0;
		// This loop takes all the good values and puts them in a new array.O(n)
		while (iter.hasNext()) {
			new_arr[j++] = iter.next();
			iter.remove();
		}
		merge_sort(new_arr);// Sort by merge sort (O(n*log(n))
		// Finds the largest value that can be in the first index (O(Log(n))
		int bin = (Arrays.binarySearch(new_arr, target / 3));
		if (bin < 0)
			bin = (bin * (-1)) - 1;
		// This loop runs up to the largest value that can be in the first index
		// and finds all 3 sub-arrays in size
		for (int i = 0; i < bin; i++) {
			int k = target - new_arr[i];
			int ind = new_arr[i];
			new_arr[i] += target;
			three_sum(new_arr, k, ans, ind);
			new_arr[i] -= target;
		}

		return ans;
	}

     //This algorithm uses a table data structure.
      //	I took the algorithm idea from the lesson
	private static void three_sum(int[] nums, int target, List<int[]> lsum, int not) {// O(n)
		HashMap<Integer, Integer> map = new HashMap<>();
		//This loop checks all possible keys
		for (int i = 0; i < nums.length; i++) {
			int[] ans = new int[3];
			if (map.containsKey(target - nums[i])) {
				ans[2] = nums[i];
				ans[1] = nums[map.get(target - nums[i])];
				ans[0] = not;
				//Checks if the array is sorted
				if (ans[0] > ans[1] || ans[0] > ans[2] || ans[1] > ans[2]) {
					return;
				}
				lsum.add(ans);
			} else {
				map.put(nums[i], i);
			}
		}
	}

	/**
	 * The algorithm sorts the array by merging arrays at a speed of (n * log (n))
	 * The algorithm splits the two arrays and merges them according to the value.
	 * The code of the algorithm from the lecture.
	 * 
	 * @param a= Array
	 */
	private static void merge_sort(int[] a) {
		if (a.length > 1) {
			int[] first = new int[a.length / 2];
			int[] second = new int[a.length - a.length / 2];

			for (int i = 0; i < a.length / 2; i++)
				first[i] = a[i];
			for (int i = 0; i < a.length - a.length / 2; i++)
				second[i] = a[a.length / 2 + i];

			merge_sort(first);
			merge_sort(second);

			int[] temp = merge(first, second);
			for (int i = 0; i < a.length; i++)
				a[i] = temp[i];
		}
	}

	// O(n)
	//This function sorts two arrays
	private static int[] merge(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];
		int i = 0, j = 0, k = 0;
		while (i < a.length && j < b.length)
			if (a[i] < b[j])
				c[k++] = a[i++];
			else
				c[k++] = b[j++];

		while (i < a.length)
			c[k++] = a[i++];
		while (j < b.length)
			c[k++] = b[j++];

		return c;
	}

}