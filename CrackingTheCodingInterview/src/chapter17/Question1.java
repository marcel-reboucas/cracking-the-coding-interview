package chapter17;

import java.util.Arrays;

public class Question1 {
	
	public static void swapInPlace(int[] array, int indexA, int indexB) {
		
		if (array == null || indexA < 0 || indexB < 0 || indexA >= array.length || indexB >= array.length) {
			return;
		}
		
		array[indexA] = array[indexA] + array[indexB];
		array[indexB] = array[indexA] - array[indexB];
		array[indexA] = array[indexA] - array[indexB];
	}

	public static void main(String[] args) {
		
		int[] array = new int[]{1,2,3,4};
		
		swapInPlace(array, 1, 3);
		
		System.out.println(Arrays.toString(array));
	}
}
