package chapter2;

import java.util.HashSet;
import java.util.Set;

/**
 * Write code to remove duplicates from an unsorted linked list.
 * How would you solve this problem if a temporary buffer is not allowed?
 * @author Marcel
 *
 */
public class Question1 {


	static void removeDuplicatesWithBuffer (Node<Integer> node) {

		Set<Integer> characters = new HashSet<Integer>();

		if (node == null) { return; }

		characters.add(node.value);

		Node<Integer> n = node;

		while(n.next != null) {

			Integer nextValue = n.next.value;

			if (characters.contains(nextValue)) {
				n.next = n.next.next;
			} else {
				characters.add(nextValue);
				n = n.next;
			}
		}
	}

	static void removeDuplicatesWithoutBuffer (Node<Integer> node) {

		if (node == null || node.next == null) {return;} 

		Node<Integer> slow = node;
		Node<Integer> fast = node;

		Integer slowValue;
		Integer fastValue;

		while (slow.next != null) {
			slowValue = slow.value;

			while(fast.next != null){
				fastValue = fast.next.value;

				if (fastValue == slowValue){
					fast.next = fast.next.next;
				} else {
					fast = fast.next;
				}
			}
			slow = slow.next;
			fast = slow;
		}
	}



	public static void main(String[] args) {
		Node<Integer> n = new Node<Integer>(1);
		n.addToTail(3);
		n.addToTail(5);
		n.addToTail(5);
		n.addToTail(3);
		n.addToTail(4);
		n.addToTail(2);
		n.addToTail(9);
		n.addToTail(4);
		System.out.println(n.toString());
		removeDuplicatesWithoutBuffer(n);
		System.out.println(n.toString());


	}

}
