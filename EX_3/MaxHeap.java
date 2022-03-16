package Ex4;

import java.util.Arrays;
/**
 * 
 * @author Niv kotek
 * @ I.D 208236315
 * In this disease one can see the two functions that need to be done.
 * The functions are at the end of this class
 * 1.mergeTwoHeaps
 * 2.getMinHeap
 *
 */
public class MaxHeap {
	int[] arr;
	int last;
	int size;

	public MaxHeap(int size) {
		this.size = size;
		arr = new int[size];
		last = -1;
	}

	public boolean Add(int data) {
		if (last == size - 1)
			return false;
		arr[++last] = data;
		Heapify_Up(last);
		return true;
	}

	private void Heapify_Up(int pos) {
		if (pos == 0)
			return;
		int parent = (int) (Math.floor((pos - 1) / 2));
		if (arr[pos] > arr[parent]) {
			swap(arr, pos, parent);
			Heapify_Up(parent);
		}

	}

	private void swap(int[] arr, int from, int to) {
		int tmp = arr[from];
		arr[from] = arr[to];
		arr[to] = tmp;
	}

	public int Delete() {
		if (last != 0) {
			int tmp = arr[0];
			swap(arr, 0, last--);
			Heapify_down(0);
			return tmp;
		} else if (last == 0) {
			int tmp = arr[0];
			last = -1;
			return tmp;
		} else {
			return Integer.MAX_VALUE;
		}
	}

	private void Heapify_down(int pos) {
		int left, right;
		left = 2 * pos + 1;
		right = 2 * pos + 2;
		if ((left == last) && ((arr[pos] < arr[left]))) {
			swap(arr, pos, left);
			return;
		}
		if ((right == last) && (arr[right] > arr[left]) && (arr[pos] < arr[right])) {
			swap(arr, pos, right);
			return;
		} else if ((right == last) && (arr[right] < arr[left]) && (arr[pos] < arr[left])) {
			swap(arr, pos, left);
			return;
		}
		if (left >= last || right >= last) {
			return;
		}
		if ((arr[left] > arr[right]) && (arr[pos] <= arr[left])) {
			swap(arr, pos, left);
			Heapify_down(left);
		} else if (arr[pos] < arr[right]) {
			swap(arr, pos, right);
			Heapify_down(right);
		}
	}

	public static void HeapSort(int[] arr) {
		MaxHeap h = new MaxHeap(arr.length);
		for (int i = 0; i < arr.length; i++) {
			h.Add(arr[i]);
		}
		for (int i = 0; i < arr.length; i++) {
			h.Delete();
		}
		for (int i = 0; i < arr.length; i++)
			arr[i] = h.arr[i];
	}
    //This function merges 2 MaxHeap at runtime of O (n + m).
	//This function builds a new MaxHeap and adds to MaxHeap
	public static MaxHeap mergeTwoHeaps(MaxHeap h1, MaxHeap h2) {
		MaxHeap h12=new MaxHeap(h1.size+h2.size);
		//Adds values
		for (int i = 0; i < h1.arr.length; i++) 
			h12.Add(h1.arr[i]);
		//Adds values
		for (int i = 0; i < h2.arr.length; i++) 
			h12.Add(h2.arr[i]);
		
		return h12;
	}
	
    //This algorithm builds a sorted array at runtime of O (n * log (n)).
	//This algorithm adds new values and then deletes them
	public static int[] getMinHeap(MaxHeap h) {
		MaxHeap h1 = new MaxHeap(h.arr.length);
		//Adds values
		for (int i = 0; i < h.arr.length; i++) 
			h1.Add(h.arr[i]);
		//Deletes values
		for (int i = 0; i < h.arr.length; i++) 
			h1.Delete();
		
		return h1.arr;
	}
}