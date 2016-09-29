package chapter5;

/***
 * You are given two 32-bit numbers, N and M, and two bit positions, i and j.
 * Write a method to insert M in to N such that M starts at bit j and ends at bit i.
 * You can assume that the bits j through i have enough space to fit all of M.
 * That is,if M=10011, you can assume that there are at least 5 bits between j and i. 
 * You would not, for example,have j-3 and i=2,because M could not fully fit between 
 * bit 3 and bit 2.
 * EXAMPLE:
 * Input: N = 1000000000 (512), M = 10011, i = 2, j = 6 Output: N = 10001001100
 * @author Marcel
 *
 */
public class Question1 {
	
	public static int insertInto (int n, int m, int i, int j) {
		
	
		// 1. set i to j to 0
		// 2. create a bitint like 100000000000
		// 3. or them.
		
		// 1. set i to j to 0
		int clearingMask = ~0; // 11111111111
		clearingMask = clearingMask << (j + 1); // 11110000000
		int rightSide = (1 << i) - 1; // 000000000011
		clearingMask = clearingMask | rightSide;  //11110000011
		
		// 2. create a bitint like 100000000000
		int clearedN = n & clearingMask;
		
		int mInPosition = m << i; // 0000001001100
		
		//3. or them.
		int inserted = clearedN | mInPosition;
		
		return inserted;
	}

	public static void main(String[] args) {
		
		String nString = "1000000000";
		String mString = "0000010011";
		
		int n = Integer.parseInt(nString, 2);
		int m = Integer.parseInt(mString, 2);
		
		int mixed = insertInto(n,m,2,6);
		
		System.out.println(nString);
		System.out.println(mString);
		System.out.println(Integer.toBinaryString(mixed));
	}
}
