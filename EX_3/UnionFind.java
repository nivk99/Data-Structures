package Ex4;

import java.awt.Point;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**This class unifies points by angular distance.
 * This class uses the structure of both Union and Hash.
 * You can find all the functions in this class.
 * @important Some of the codes I took from the lecture
 * @author Niv kotek
 * @I.D 208236315
 *
 */

public class UnionFind {
	Point[] elements;//All points
	int[] id;//Group number
	int[] size;//Group weight
	double angle;//Angle value
	private HashSet<Integer> hash;//Group number
	
    //This function builds the class while running O (N)
	public UnionFind(int size, double angle) {
		this.elements = Ex4Utils.generateRandomArray(size);//Random points
		this.angle = angle;//Group weight
		this.id = new int[size];//Group number
		this.size = new int[size];//Group weight
		doisJoin();//O (N)
		
		//UnionByAngularDist(new Point(50, 50));//***For testing***
	}
	//The function attaches the angles to the group
	public void doisJoin() {
		HashSet<Integer> has = new HashSet<Integer>();//Group number
		//This loop initializes the whole group
		for (int i = 0; i < id.length; i++)
			id[i] = i;
		//This loop puts one weight per group
		for (int i = 0; i < this.size.length; i++)
			this.size[i] = 1;
		//Put the whole group on
		for (int i = 0; i < id.length; i++)
			has.add(this.id[i]);
		this.hash = has;
	}

	/**
	 * The function finds which group you are in.
	 * Run time is log (n)
	 * It can also be said that at best she ran at a time of O (1)
	 * @important I took the code from the lecture.
	 * @param p = Index for finding a group
	 * @return Group
	 */
	public int Find(int p) {
		if (id[p] == p)
			return p;
		else
			return Find(id[p]);
	}
	

	/**
	 * This function unites two groups.
	 * The union is carried out according to the highest weight.
	 * Function run time is log (n)
	 * It can be said that at best she ran at a time of O (1)
	 * @important I took the code from the lecture.
	 * @param ind1=Index of the group1
	 * @param ind2=Index of the group2
	 */
	public void Union(int ind1, int ind2) {
		int group_p = Find(ind1);//Finds which group it is in
		int group_q = Find(ind2);//Finds which group it is in
		//Finds the highest weight
		if (size[group_p] > size[group_q]) {
			this.hash.remove(group_q);
			id[group_q] = group_p;
			size[group_p] += size[group_q];
		} else {
			this.hash.remove(group_p);
			id[group_p] = group_q;
			size[group_q] += size[group_p];
		}

	}
	/**
	 * This function increases the angle in d and unites the groups as required.
	 * Run time of this function is O (Number of foreign groups)
	 * @param d=Increasing the angle
	 */
	public void increaseAngle(int d) {
		Iterator<Integer> iterator = this.hash.iterator();
		int[] arr = new int[hash.size()];
		int index = 0;
		//The loop puts all the groups in an array.O(groups)
		while (iterator.hasNext()) {
			arr[index++] = iterator.next();
			iterator.remove();
		}
		this.hash.clear();
		int group1=0,group2=0,group3=0,j = -1,range1=0,range2=0,temp=0; 
		//This loop unites the groups by range
		for (int i = 0; i < arr.length; i++) {
			group1 = arr[i];//The first group
			hash.add(group1);//Adds the group
			if (i + 1 >= arr.length) 
				break;
			group2 = arr[++i];//The second group
			//Finds the range of each group
			 range1 = (int) ((++j + (group2 - group1)) * (this.angle)) + d;
			 range2 = (int) ((++j + (group2 - group1)) * this.angle);
			this.id[group2] = group1;//changes id
			//Finds the highest weight
			if (this.size[group1] > this.size[group2])
				size[group1] += size[group2];
			else {
				 temp = size[group1];
				size[group1] = size[group2];
				size[group2] = temp;
				size[group1] += size[group2];

			}
			//If the range is small
			if (range1 < range2 && (i + 1) < arr.length) {
				 group3 = arr[++i];//The third group
				this.id[group3] = group1;//changes id
				//Finds the highest weight
				if (this.size[group1] > this.size[group3])
					size[group1] += size[group3];
				else {
					 temp = size[group1];
					size[group1] = size[group3];
					size[group3] = temp;
					size[group1] += size[group3];

				}

			}
		}
		this.angle += d;
	}

	/**
	 * This algorithm unites the groups according to the angular distance of the
	 * point p. This algorithm uses HashSet. This algorithm does track compression.
	 * This algorithm runs at a speed of O (n)
	 */

	public void UnionByAngularDist(Point p) {
		this.hash.clear();
		int[] arr = new int[this.size.length];
		// Put in another value array; O(size)
		for (int i = 0; i < arr.length; i++)
			arr[i] = -1;
		// Uses HashSet structure
		HashSet<Integer> has = new HashSet<Integer>();
		double temp;
		int ind;
		// Create new groups according to angles;O(elements)
		for (int i = 0; i < elements.length; i++) {
			temp = Ex4Utils.angleFrom(elements[i], p);
			ind = (int) (temp / angle);
			has.add(ind);// O(1)
			hash.add(ind);// O(1)
		}
		// Adds the groups at the beginning of the given array;O(arr)
		for (int i = 0; i < arr.length; i++) {
			temp = Ex4Utils.angleFrom(elements[i], p);// Finds the angular distance
			ind = (int) (temp / angle);// Calculates the group that should be
			if (has.contains(ind)) {
				// Switching between values
				Point po = this.elements[ind];
				this.elements[ind] = this.elements[i];
				this.elements[i] = po;
				arr[ind] = ind;
				has.remove(ind);// O(1)
			}
			if (has.isEmpty()) // O(1)
				break;
		}
		// Adds the boys of the teams; O(arr)
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == -1) {
				temp = Ex4Utils.angleFrom(elements[i], p);// Finds the angular distance
				ind = (int) (temp / angle);// Calculates the group that should be
				arr[i] = ind;
				size[ind]++;
			}
		}
		this.id = arr;
	}

}