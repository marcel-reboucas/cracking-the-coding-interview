package chapter9;

/***
 * AmagicindexinanarrayA[l...n-l]isdefinedtobeanindexsuchthatA[i] = i. Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.
 * FOLLOW UP
 * What if the values are not distinct?
 * @author Marcel
 *
 */
public class Question3 {
	
	public static int findMagicI(int[] array) {
		
		for (int i = 1; i < array.length; i = array[i]) {
			if (array[i] == i) { return i; }
		}
		
		return -1;
	}

	public static int binarySearch(int[] array, int indexStart, int indexFinish) {
		
		int i = (indexStart + indexFinish)/2;
		
		if (i == array[i]){
			return i;
		} else if (i < array[i]){
			return binarySearch(array, indexStart, i);
		} else {
			return binarySearch(array, i, indexFinish);
		}
	}

	public static void main(String[] args) {
		
		int[] array = new int[]{5,0,1,2,4,4};
		System.out.println(findMagicI(array));
		System.out.println(binarySearch(array,0,array.length-1));
	}
}
