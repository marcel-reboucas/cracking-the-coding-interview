package chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import util.TreeNode;

/***
 * Given a sorted (increasing order) array with unique integer elements, write
 * an algorithm to create a binary search tree with minimal height.
 *
 */
public class Question3 {

	// first option - organizing the array
	public static Integer[] prepareArray(Integer[] array) {

		List<Integer> initialArray = new ArrayList<Integer>();
		for (Integer i : array) {
			initialArray.add(i);
		}

		List<Integer> result = new ArrayList<Integer>();

		Queue<List<Integer>> queue = new LinkedBlockingQueue<List<Integer>>();
		queue.add(initialArray);

		while (!queue.isEmpty()) {
			List<Integer> current = queue.poll();

			if (current.size() == 0) {
				continue;
			} else if (current.size() == 1) {
				result.add(current.get(0));
			} else {

				Integer midValue = current.get(current.size() / 2);
				result.add(midValue);

				queue.add(current.subList(0, (current.size() / 2))); // left
																		// side
				queue.add(current.subList((current.size() / 2) + 1, current.size())); // right
																						// side
			}
		}

		Integer[] resultArray = new Integer[result.size()];
		for (int i = 0; i < result.size(); i++) {
			resultArray[i] = result.get(i);
		}
		return resultArray;
	}

	// second option - generating the tree
	public static TreeNode generateTree(Integer[] array) {

		if (array.length == 0) {
			return null;
		}
		if (array.length == 1) {
			return new TreeNode(array[0]);
		}

		Integer midValue = array[array.length / 2];

		Integer[] leftSide = Arrays.copyOfRange(array, 0, array.length / 2);
		Integer[] rightSide = Arrays.copyOfRange(array, (array.length / 2) + 1, array.length);

		TreeNode result = new TreeNode(midValue);
		result.left = generateTree(leftSide);
		result.right = generateTree(rightSide);

		return result;
	}

	public static void main(String[] args) {

		Integer[] array = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };

		Integer[] result = prepareArray(array);

		if (result.length > 0) {
			TreeNode root = new TreeNode(result[0]);

			for (int i = 1; i < result.length; i++) {
				root.insert(result[i]);
			}

			root.printTree(System.out);
		}

		TreeNode root2 = generateTree(array);
		root2.printTree(System.out);
	}

}
