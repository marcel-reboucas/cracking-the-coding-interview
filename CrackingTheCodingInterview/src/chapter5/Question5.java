package chapter5;

/***
 * Write a function to determine the number of bits required to convert integer
 * A to integer B.
 *
 */
public class Question5 {

	public static int bitsRequired(int a, int b) {
		return Integer.bitCount(a ^ b);
	}

	public static void main(String[] args) {

		String aString = "1000000000";
		String bString = "0000010011";

		int a = Integer.parseInt(aString, 2);
		int b = Integer.parseInt(bString, 2);

		int mixed = bitsRequired(a, b);

		System.out.println(aString);
		System.out.println(bString);
		System.out.println(mixed);
	}
}
