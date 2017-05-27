package chapter11;

/***
 * You are given two sorted arrays, A and B, where A has a large enough buffer at
 * the end to hold B. Write a method to merge B into A in sorted order.
 *
 */
public class Question1 {

	public static void shiftRight(int[] array, int position) {
		if (position < 1 || position > array.length - 1) {
			return;
		}

		for (int i = array.length - 1; i > position; i--) {
			array[i] = array[i - 1];
			array[i - 1] = 0;
		}
	}

	public static void mergeArrays(int[] arrayA, int[] arrayB) {
		int aIndex = 0;
		
		for (int number : arrayB) {
			while (aIndex < arrayA.length) {
				if (number < arrayA[aIndex]) {
					shiftRight(arrayA, aIndex);
					arrayA[aIndex] = number;
					break;
				} else {
					aIndex++;
				}
			}
		}
	}

	public static void main(String[] args) {

		int[] arrayA = new int[] { 1, 3, 4, 6, 8, 0, 0, 0 };
		int[] arrayB = new int[] { 2, 5, 7 };

		mergeArrays(arrayA, arrayB);

		for (int i : arrayA) {
			System.out.print(Integer.toString(i) + " ");
		}
	}
}
