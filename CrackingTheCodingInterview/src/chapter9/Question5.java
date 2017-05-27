package chapter9;

import java.util.ArrayList;
import java.util.List;

/***
 * Write a method to compute all permutations of a string
 */

public class Question5 {

	public static List<String> generatePermutations(String str) {

		if (str == null) {
			return null;
		}

		if (str.length() == 1) {
			List<String> permutations = new ArrayList<String>();
			permutations.add(str);
			return permutations;
		} else {
			String letter = str.substring(0, 1);
			String rest = str.substring(1, str.length());
			return getPermutationsForString(letter, generatePermutations(rest));
		}
	}

	public static List<String> getPermutationsForString(String letter, List<String> current) {

		List<String> permutations = new ArrayList<String>();

		for (String str : current) {
			for (int i = 0; i < str.length() + 1; i++) {
				permutations.add(new StringBuilder(str).insert(i, letter).toString());
			}
		}

		return permutations;
	}

	public static void main(String[] args) {
		String str = "abcde";

		System.out.println(generatePermutations(str));
	}
}
