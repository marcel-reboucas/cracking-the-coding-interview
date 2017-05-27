package chapter9;

import java.util.HashSet;
import java.util.Set;

/***
 * Implement an algorithm to print all valid (i.e., properly opened and closed)
 * combinations of n-pairs of parentheses.
 */
public class Question6 {

	public static String par = "()";

	public static Set<String> generatePairsOfParentheses(int n) {

		Set<String> permutations = new HashSet<String>();

		if (n <= 0) {
			return permutations;
		} else if (n == 1) {
			permutations.add(par);
			return permutations;
		} else {
			return getPermutationsForString(generatePairsOfParentheses(n - 1));
		}
	}

	public static Set<String> getPermutationsForString(Set<String> current) {

		Set<String> permutations = new HashSet<String>();

		for (String str : current) {
			for (int i = 0; i < str.length() + 1; i++) {
				permutations.add(new StringBuilder(str).insert(i, par).toString());
			}
		}
		return permutations;
	}

	public static void main(String[] args) {
		System.out.println(generatePairsOfParentheses(3));
	}
}
