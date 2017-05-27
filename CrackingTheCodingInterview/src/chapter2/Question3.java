package chapter2;

import util.Node;

/**
 * Implement an algorithm to delete a node in the middle of a singly linked
 * list, given only access to that node.
 *
 */
public class Question3 {

	static void deleteNode(Node<Integer> n) {

		if (n == null) {
			return;
		}

		if (n.next != null) {
			n.value = n.next.value;
			n.next = n.next.next;
		}
	}

	public static void main(String[] args) {
		Node<Integer> n = new Node<Integer>(1);
		n.addToTail(2);
		n.addToTail(3);
		n.addToTail(4);
		n.addToTail(5);
		System.out.println(n.toString());

		deleteNode(n);
		System.out.println(n.toString());

		Node<Integer> middleNode = n.next.next;
		deleteNode(middleNode);
		System.out.println(n.toString());
	}
}
