package Matala;
import java.util.LinkedList;
/**
 * In this class you can find:
 * 1. Iterative sorting merger algorithm no Recursive.
 * 2. A merging algorithm without the use of additional memory depending on the size of the input.
 * 3. Merge an array of linked lists.
 * 4. An algorithm that returns the maximum difference between two adjacent members in the array. 
 * @important Please note the comment that lists @code
 * @author Niv Kotek
 * @I.D 208236315
 * @category: Task 2 - Data structures.
 */
public class Ex2 {
/////////////////////////////////////////////////////////Q3A\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	/**
	 * This algorithm is an iterative merge sort.
	 * The algorithm divides the array into small sub-arrays to the end.
	 * The algorithm is on the same idea of recursive merge sorting
	 * @code The idea for the algorithm "mergeSort2" was taken from a Website :https://www.geeksforgeeks.org/iterative-merge-sort/!!!
     * @param arr - Input array
	 */
	public static void mergeSort2(int[] arr) {
		int high, mid;
		for (int i = 1; i < arr.length; i = 2 * i) {//Divides the array
			for (int j = 0; j < arr.length - 1; j = j + 2 * i) {//Divides the array into sub-arrays
				high = j + 2 * i < arr.length ? j + 2 * i : arr.length;//What's bigger
				mid = j + i < arr.length ? j + i : arr.length;//What's bigger
				mergeSort_2(arr, j, mid, high);//merge
			}

		}
	}

	/**
	 * The algorithm merges according to the middle of the array
	 * @code Algorithm "mergeSort_2" taken from the lecture!!!
	 * @param arr - Input array
	 * @param low  - Beginning of the array
	 * @param mid  - The middle of the array
	 * @param high - End of array
	 */
	private static void mergeSort_2(int[] arr, int low, int mid, int high) {//O(n)
		int[] temp = new int[high - low];
		int i = low, j = mid, k = 0;
		while (i < mid && j < high) {//Which number is larger
			if (arr[j] < arr[i]) 
				temp[k++] = arr[j++];
			 else 
				temp[k++] = arr[i++];
		}
		while (i < mid)//Continue in the loop
			temp[k++] = arr[i++];
		while (j < high)//Continuation of the loop
			temp[k++] = arr[j++];
		for (int p = 0; p < high - low; p++) {//Put inside the array
			arr[p + low] = temp[p];
		}
	}

/////////////////////////////////////////////////////////Q3B\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	/**
	 * This algorithm merges two sorted arrays without the use of memory.
	 * The merger is for natural numbers.
	 * The merger is from [low, mid] and [high, 1 + mid]
	 * The algorithm saves 2 numbers on the same number.
	 * @param arr     - Input array
	 * @param low     - Beginning of the array
	 * @param mid     - The middle of the array
	 * @param high    - End of array
	 * @param max_num - The maximum value
	 */
	public static void merge2(int[] arr, int low, int mid, int high, int max_num) {// O(n)
		mid++;
		int tamp = 0;
		int j = 0;
		int zero = 0;
		high = mid;
		while (low != high) {// O(n)
			if (mid == arr.length)//If the middle has come to an end
				break;
			if (arr[mid] == 0)//If it is zero
				zero++;
			if (arr[low] > max_num )
				tamp = arr[low] % max_num;
			else
				tamp = arr[low];

			if (tamp <= arr[mid]) {//Which number is larger
				if (j > low)
					arr[j] = arr[j] + (tamp * max_num);//Put 2 numbers within one number
				low++;
				j++;
			} else {
				if (j > low)
					arr[j] = arr[j] + (arr[mid] * max_num);
				else
					arr[low] = arr[low] + (arr[mid] * max_num);//Put 2 numbers within one number
				mid++;
				j++;
			}
		}
		while (low != high) {// O(n) - If the loop came out ahead of time
			tamp = arr[low] % max_num;
			arr[j] = tamp;
			j++;
			low++;
		}

		j = 0;
		tamp = 0;
		while (j < arr.length) {// O(n) - Delete the numbers you do not need
			if (zero > 0 ) {
				arr[j] = 0;
				zero--;
			}
			if (arr[j] > max_num )
				arr[j] = arr[j] / max_num;
			j++;
		}

	}

/////////////////////////////////////////////////////////Q3C\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	/**
	 * This algorithm is a kind of array of linked lists.
	 * A recursive and iterative algorithm can be found
	 * @param arr - Input array
	 * @return - Sort a linked list
	 */
	public static LinkedList<Integer> join(LinkedList<Integer>[] arr){
		join_Recursion(arr);
		return arr[0];
	}
	/**
	 * This algorithm divides the array into two at a time,
	 * And finally sorts them out
	 * @code An idea for an algorithm "join_Recursion" was taken from the lecture
	 * @param a - Input array
	 */
	private static void join_Recursion(LinkedList<Integer>[] a) {//O(M*N)
		if(a.length > 1) {
			LinkedList<Integer>[]first =new LinkedList[a.length/2];
			LinkedList<Integer>[]second =new LinkedList[a.length - a.length/2];
			for(int i=0; i<a.length/2; i++)//Divides the array
				first[i] = a[i];
			for(int i=0; i<a.length - a.length/2; i++)//Divides the array
				second[i] = a[a.length/2 + i];
			join_Recursion(first);//O(M*log(M))
			join_Recursion(second);//O(M*log(M))
			LinkedList<Integer>temp = merge_ll(first[0], second[0]);//O(M*N) - Merging
				a[0] = temp;
		}
	}
	/**
	 * This algorithm sorts out an array of iteratively linked lists 
	 * Algorithm each time dividing the array into sub-arrays.
	 * @param arr Input array
	 * @return Sort a linked list
	 */
	private static LinkedList<Integer> join_Iterative(LinkedList<Integer>[] arr) {//O(M*n*log(M)*log(M))	
		for (int i = 1; i < arr.length; i = 2 * i) {// O(log(M)
			for (int j = 0; j < arr.length - 1; j = j + 2 * i) {//O(log(M)
				arr[j] = merge_ll(arr[j], arr[j + i]);// O(n*M)
			}

		}

		return arr[0];
	}
	/**
	 * This algorithm sorts out two linked lists. 
	 * @code An idea for an algorithm "merge_ll" was taken from the lecture 
	 * @param a - A linked list
	 * @param b - A linked list
	 * @return Sort a linked list
	 */

	private static LinkedList<Integer> merge_ll(LinkedList<Integer> a, LinkedList<Integer> b){// O(n)
		LinkedList<Integer> c = new LinkedList<Integer>();
		int i = 0, j = 0;
		int a_size=a.size(),b_size=b.size();
		while (i < a_size && j < b_size){// O(n)
			if (a.getFirst() < b.getFirst()){//What's bigger
				c.add(a.pop());
				i++;
			}
			else {
				c.add(b.pop());
				j++;
			}
		}

		while (i < a_size){//Continue the loop
			c.add(a.pop());
			i++;
		}
		while (j < b_size){// O(n)
			c.add(b.pop());
			j++;
		}
		return c;
	}
	
	

///////////////////////////////////////////////////////// Q4\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	/**
	 * This algorithm returns the maximum difference between two adjacent numbers in the array.
	 * It uses counting sort because the numbers are between 0 and the size of the array
	 * @param arr - Input array
	 * @return counting_sort array
	 */

	public static int diff(int[] arr) {//O(n)
		int maxValue = arr[0];
		for (int i = 1; i < arr.length; i++)//O(n) - Find the maximum number
			if (arr[i] > maxValue)
				maxValue = arr[i];
		int[] newarr = new int[arr.length];
		counting_sort(arr, newarr, maxValue);//O(n+n)=O(n) - Sort an array by the maximum number
		int max = 0;
		for (int i = 0; i < newarr.length - 1; i++)//O(n) - Find the maximum difference between 2 numbers
			if (newarr[i + 1] - newarr[i] > max)
				max = newarr[i + 1] - newarr[i];
		return max;
	}

	/**
	 * This algorithm is counting sort.
	 * This algorithm is useful because the maximum number is up to the array size
	 * @code Algorithm "counting_sort" taken from the lecture!!!
	 * @param arr - Input array
	 * @param newarr   - Input new array
	 * @param maxValue - The maximum value
	 */

	private static void counting_sort(int[] arr, int[] newarr, int maxValue) {//O(n+maxValue)
		int[] counts = new int[maxValue + 1];
		for (int i = 0; i < arr.length; i++)
			counts[arr[i]]++;//Count the number of numbers
		int tamp = 0;
		for (int i = 0; i < counts.length; i++)
			for (int j = 0; j < counts[i]; j++)
				newarr[tamp++] = i;//In an array in order
	}

}
