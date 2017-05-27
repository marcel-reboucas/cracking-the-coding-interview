package chapter3;

import java.util.Stack;

/**
 * 
 * Write a program to sort a stack in ascending order (with biggest items on
 * top). You may use at most one additional stack to hold items, but you may not
 * copy the elements into any other data structure (such as an array). The stack
 * supports the following operations: push, pop, peek, and isEmpty.
 *
 */

public class Question6 {

	public static void main(String[] args) {

		Stack<Integer> mainStack = new Stack<Integer>();
		Stack<Integer> auxStack = new Stack<Integer>();

		mainStack.add(5);
		mainStack.add(2);
		mainStack.add(7);
		mainStack.add(10);
		mainStack.add(6);

		System.out.println(mainStack);

		sortStack(mainStack, auxStack);

		System.out.println(mainStack);
	}

	public static void sortStack(Stack<Integer> mainStack, Stack<Integer> auxStack) {

		if (mainStack.isEmpty()) {
			return;
		}

		Integer value = mainStack.pop();

		sortStack(mainStack, auxStack);
		insertSorted(value, mainStack, auxStack);
	}

	private static void insertSorted(Integer value, Stack<Integer> mainStack, Stack<Integer> auxStack) {

		while (!mainStack.isEmpty() && value < mainStack.peek()) {
			auxStack.push(mainStack.pop());
		}

		mainStack.push(value);

		while (!auxStack.isEmpty()) {
			mainStack.push(auxStack.pop());
		}
	}
}
