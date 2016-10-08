package chapter9;

/***
 * A child is running up a staircase with n steps, and can hop either 1 step, 2 steps, 
 * or 3 steps at a time. Implement a method to count how many possible ways the child 
 * can run up the stairs.
 *
 */
public class Question1 {
	
	// n = 1, x = 1
	// n = 2, x = 2
	// n = 3, x = 4
	// n = 4, x = 7
	public static int[] cache = new int[100];
	
	public static int countPossibleWays(int n) {
		
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else {
			return countPossibleWays(n-1) + countPossibleWays(n-2) + countPossibleWays(n-3);  //O(nˆ3)
		}
	}
	
	public static int cachedCountPossibleWays(int n) {
		
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else {
			
			if (cache[n] != 0) { 
				return cache[n]; 
			}
			
			int value = cachedCountPossibleWays(n-1) + cachedCountPossibleWays(n-2) + cachedCountPossibleWays(n-3);
			cache[n] = value;
			return value;
		}
	}
	
	public static void main(String[] args) {
		
		//int ways = countPossibleWays(5);
		int cachedWays = cachedCountPossibleWays(20);
		System.out.println(cachedWays);
	}
}
