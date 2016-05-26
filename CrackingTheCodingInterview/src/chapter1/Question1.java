package chapter1;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement an algorithm to determine if a string has all unique 
 * characters. What if you cannot use additional data structures?
 */
public class Question1 {
	
	private static boolean isUnique(String str) {
		
		Map<Character, Boolean> uniqueness = new HashMap<Character, Boolean>();
		
		for (char c : str.toCharArray()) {
			
			if (uniqueness.get(c) != null) {
				return false;
			}
			
			uniqueness.put(c, true);
		}
		
		return true;
	}
	
	private static boolean isUniqueWithoutDataStructure(String str) {
		
		boolean[] uniqueness = new boolean[256];
		
		for (int i = 0; i < str.length(); i++) {
			int value = str.charAt(i);
			
			if (uniqueness[value]) {
				return false;
			}
			uniqueness[value] = true;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		
		String[] testStrings = {"abcd", "aabc", "a1s3","alsda"};
		
		for (String str : testStrings) {
			System.out.println(str + ": " + isUnique(str));
			System.out.println(str + ": " + isUniqueWithoutDataStructure(str));
		}
	}

}
