package chapter1;

/**
 * 
 * Write a method to replace all spaces in a string with'%20'. You may assume
 * that the string has sufficient space at the end of the string to hold the
 * additional characters, and that you are given the "true" length of the
 * string. (Note: if implementing in Java, please use a character array so that
 * you can perform this operation in place.) EXAMPLE Input: "Mr John Smith
 * Output: "Mr%20John%20Smith"
 *
 * Possible improvements after seeing the solution: - instead of using shifts,
 * which are expensive and not optimal, it would be better to use two arrays:
 * calculate the size of the new array based on the number of the spaces and
 * just run through it with one pass.
 */
public class Question4 {

	static void shiftRight(char[] charArray, int startingPosition, int positions) {
		int arraySize = charArray.length;
		if (startingPosition > arraySize || positions > (arraySize - startingPosition)) {
			return;
		}

		for (int i = arraySize - 1; i >= startingPosition + positions; i--) {
			charArray[i] = charArray[i - positions];
			charArray[i - positions] = ' ';
		}
	}

	static String replaceWithPercentage20(String str) {
		char[] charArray = str.toCharArray();

		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == ' ') {
				shiftRight(charArray, i + 1, 2);
				charArray[i] = '%';
				charArray[i + 1] = '2';
				charArray[i + 2] = '0';
				i = i + 2;
			}
		}
		return new String(charArray);
	}

	public static void main(String[] args) {
		System.out.println(replaceWithPercentage20("Mr John Smith    "));
	}
}
