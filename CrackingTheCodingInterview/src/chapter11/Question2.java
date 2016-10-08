package chapter11;

import java.util.Arrays;
import java.util.Comparator;

/***
 * Write a method to sort an array of strings so that all the anagrams are next to each other.

 *
 */
class AnagramComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		
		char[] o1Array = o1.toCharArray();
		char[] o2Array = o2.toCharArray();
		Arrays.sort(o1Array);
		Arrays.sort(o2Array);
		
		String o1String = new String(o1Array);
		String o2String = new String(o2Array);
		
		return o1String.compareTo(o2String);
	}
	
}
public class Question2 {
	
	public static void main(String[] args) {
		
		AnagramComparator ac = new AnagramComparator();
		
		String[] words = new String[]{"sapo","apos","maria","jose","claudio","tapioca"};
		
		Arrays.sort(words, ac);
		
		System.out.println(Arrays.asList(words));
	}

}
