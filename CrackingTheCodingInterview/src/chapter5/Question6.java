package chapter5;

/***
 * Write a program to swap odd and even bits in an integer with as few instructions 
 * as possible(e.g.,bit 0 and bit 1 are swapped, bit2 and bit 3 are swapped, and so on).
 * @author Marcel
 *
 */
public class Question6 {
	
	public static int swap(int number) {
		
		int oddsMask = Integer.parseInt("1010101010101010101010101010101", 2);
		int evenMask = Integer.parseInt("0101010101010101010101010101010", 2);
		
		int odds = (number & oddsMask) << 1;
		int evens = (number & evenMask) >> 1;
		
		return odds | evens;
	}

public static void main(String[] args) {
		
		String aString = "010110";
		
		int a = Integer.parseInt(aString, 2);
		
		int mixed = swap(a);
		
		System.out.println(aString);
		System.out.println(Integer.toBinaryString(mixed));
		
	}
}
