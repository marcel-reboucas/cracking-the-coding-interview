package chapter2;

import java.util.HashMap;
import java.util.Map;

import util.Node;

/**
 * 
 * Given a circular linked list, implement an algorithm which returns the node
 * at the beginning of the loop. Possible improvements after seeing the
 * solution: - could've used multiple pointers to avoid the increased space
 * requirements.
 */
public class Question6 {

	static Node<Integer> containsLoop(Node<Integer> node) {

		Map<Node<Integer>, Boolean> map = new HashMap<Node<Integer>, Boolean>();

		while (node != null) {

			if (map.get(node) != null) {
				node.next = null;
				return node;
			} else {
				map.put(node, true);
			}

			node = node.next;
		}

		return null;
	}

	public static void main(String[] args) {
		Node<Integer> number1 = new Node<Integer>(1);
		Node<Integer> number2 = new Node<Integer>(2);
		Node<Integer> number3 = new Node<Integer>(3);
		Node<Integer> number4 = new Node<Integer>(4);

		number1.next = number2;
		number2.next = number3;
		number3.next = number4;
		number4.next = number2;

		Node<Integer> result = containsLoop(number1);

		System.out.println(result);
	}
}
