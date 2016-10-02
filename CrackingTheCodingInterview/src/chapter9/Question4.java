package chapter9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Question4 {

	public static List<HashSet<Integer>> allSubsets(HashSet<Integer> set) {
		
		List<HashSet<Integer>> subsets = new ArrayList<HashSet<Integer>>();
		List<HashSet<Integer>> aux;
		HashSet<Integer> elementAux;
		
		for (Integer i : set) {
			
			aux = new ArrayList<HashSet<Integer>>();
			elementAux = new HashSet<Integer>();
			elementAux.add(i);
			
			for (HashSet<Integer> subset : subsets){
				
				@SuppressWarnings("unchecked")
				HashSet<Integer> subsetCopy = (HashSet<Integer>) subset.clone();
				subsetCopy.add(i);
				aux.add(subsetCopy);
			}
			
			aux.add(elementAux);
			subsets.addAll(aux);
		}
		
		subsets.add(new HashSet<Integer>()); // includes empty
		
		return subsets;
	}
	
	public static void main(String[] args) {
		
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		
		System.out.println(allSubsets(set));
	}
}
