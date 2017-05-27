package chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 
 * Magic
 *
 */

public class Question4 {

	public static void main(String[] args) {

		Hanoi hanoi = new Hanoi(new int[] { 1, 2, 3 });
		hanoi.play();
	}
}

class Hanoi {

	List<Stack<Integer>> stacks;

	public Hanoi(int[] values) {

		stacks = new ArrayList<Stack<Integer>>();
		stacks.add(new Stack<Integer>());
		stacks.add(new Stack<Integer>());
		stacks.add(new Stack<Integer>());

		Arrays.sort(values);

		for (int i = values.length - 1; i >= 0; i--) {
			stacks.get(0).add(values[i]);
		}

		System.out.println(stacks);
	}

	private void moveDisk(int from, int to) {

		Stack<Integer> fromStack = stacks.get(from);
		Stack<Integer> toStack = stacks.get(to);

		if (fromStack.isEmpty()) {
			return;
		}

		if (toStack.isEmpty()) {
			toStack.push(fromStack.pop());
		} else {
			if (fromStack.peek() < toStack.peek()) {
				toStack.push(fromStack.pop());
			}
		}

		System.out.println("Moved from " + from + " to " + to);
		System.out.println(stacks);
	}

	private void moveDisks(int n, int beginning, int end, int buffer) {

		if (n <= 0) {
			return;
		}

		moveDisks(n - 1, beginning, buffer, end);
		moveDisk(beginning, end);
		moveDisks(n - 1, buffer, end, beginning);
	}

	public void play() {
		int n = stacks.get(0).size();
		moveDisks(n, 0, 2, 1);
	}

	public String toString() {
		return stacks.toString();
	}

}