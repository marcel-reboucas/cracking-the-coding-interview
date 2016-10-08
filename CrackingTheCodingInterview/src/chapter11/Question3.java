package chapter11;

import java.util.Arrays;

/***
 * Given a sorted array of n integers that has been rotated an unknown 
 * number of times, write code to find an element in the array. You may 
 * assume that the array was originally sorted in increasing order.
 *
 */
public class Question3 {
	
	public static int find(int[] array, int wantedValue) {
		
		if (array.length == 0) { return -1; }
		
		int midValue = array[array.length/2];
		
		if (midValue == wantedValue) {
			return midValue;
		} 
		
		if (array.length == 1) { return -1; }
		
		int firstValue = array[0];
		
		if ((firstValue < midValue && wantedValue >= firstValue && wantedValue < midValue) || 
				(firstValue > midValue && wantedValue <= firstValue && wantedValue < midValue)){
			//search left
			return find(Arrays.copyOfRange(array, 0, array.length/2), wantedValue);
		} else {
			//search right
			return find(Arrays.copyOfRange(array, array.length/2, array.length), wantedValue);
		}
	}
	
	
	public static void main(String[] args) {
		int[] array = new int[]{4,5,6,7,1,2,3};
		
		System.out.println(find(array, 4));
		System.out.println(find(array, 7));
		System.out.println(find(array, 1));
		System.out.println(find(array, 2));
		System.out.println(find(array, 4));
		System.out.println(find(array, 0));
	}

}
