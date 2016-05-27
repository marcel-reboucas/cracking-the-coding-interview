package chapter1;

import java.util.HashMap;
import java.util.Map;
/**
 * Given two strings, write a method to decide if one is a 
 * permutation of the other.
 * 
 * Possible improvements after seeing the solution:
 * - returning early if the string lengths are different
 * - instead of comparing the char maps, just sort each string and compare
 * 	 the strings
 */
public class Question3 {
	
	static boolean isPermutation(String str1, String str2) {

		Map<Integer, Integer> charMap1 = generateCharMap(str1);
		Map<Integer, Integer> charMap2 = generateCharMap(str2);

		return charMap1.equals(charMap2);
	}

	static Map<Integer, Integer> generateCharMap (String str) {

		Map<Integer, Integer> charMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < str.length(); i++) {
			
			int value = str.charAt(i);
			Integer mappedValue = charMap.get(value);
			
			if (mappedValue == null) {
				charMap.put(value, 1);
			} else {
				charMap.put(value, mappedValue+1);
			}
		}
		return charMap;
	}
	
	public static void main(String[] args) {	
		
		System.out.println(isPermutation("aba", "aab"));
		System.out.println(isPermutation("a", "aa"));
		System.out.println(isPermutation("abaac", "aabca"));
		System.out.println(isPermutation("abaqwe", "qweazzz"));
		
	}
}
