package chapter3;

import java.util.Stack;

/*
 * Implement a MyQueue class which implements a queue using two stacks.
 */
public class Question5 {

	public static void main(String[] args) {

		MyQueue queue = new MyQueue();

		queue.enqueue(5);
		System.out.println(queue.toString());
		queue.enqueue(10);
		System.out.println(queue.toString());
		System.out.println(queue.dequeue());
		queue.enqueue(11);
		queue.enqueue(12);
		System.out.println(queue.toString());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}
}

class MyQueue {

	Stack<Integer> mainStack;
	Stack<Integer> auxStack;

	public MyQueue() {
		mainStack = new Stack<Integer>();
		auxStack = new Stack<Integer>();
	}

	public void enqueue(Integer value) {
		auxStack.push(value);
	}

	private void passAllElements(Stack<Integer> start, Stack<Integer> destination) {
		while (!start.isEmpty()) {
			destination.push(start.pop());
		}
	}

	public Integer dequeue() {

		if (mainStack.isEmpty()) {
			passAllElements(auxStack, mainStack);
		}
		return mainStack.pop();
	}

	public Integer peek() {
		if (mainStack.isEmpty()) {
			passAllElements(auxStack, mainStack);
		}
		return mainStack.peek();
	}

	public String toString() {
		return mainStack.toString() + " " + auxStack.toString();
	}
}