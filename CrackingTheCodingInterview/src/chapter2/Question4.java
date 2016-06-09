package chapter2;

import util.Node;

/**
 * Write code to partition a linked list around a value x,
 * such that all nodes less than x come before alt nodes 
 * greater than or equal to x.
 *
 */
public class Question4 {

	static Node<Integer> partitionList(Node<Integer> node, int k) {

		if (node == null) { return null; }

		Node<Integer> headLesser = null;
		Node<Integer> headHigher = null;

		Node<Integer> lastLesserNode = null;
		Node<Integer> lastHigherNode= null;

		Node<Integer> newNode;

		while (node != null) {

			newNode = new Node<Integer>(node.value);

			if (node.value < k){

				if (headLesser == null) { 
					headLesser = newNode;
					lastLesserNode = headLesser;
				} else {
					lastLesserNode.next = newNode;
					lastLesserNode = newNode;
				}

			} else {

				if (headHigher == null) { 
					headHigher = newNode;
					lastHigherNode = headHigher;
				} else {
					lastHigherNode.next = newNode;
					lastHigherNode = newNode;
				}
			}
			
			node = node.next;
		}
		
		if (headLesser == null) {
			return headHigher;
		} else {
			lastLesserNode.next = headHigher;
			return headLesser;
		}
	}
public static void main(String[] args) {
	Node<Integer> n = new Node<Integer>(9);
	n.addToTail(4);
	n.addToTail(3);
	n.addToTail(7);
	n.addToTail(54);
	n.addToTail(32);
	n.addToTail(1);
	
	Node<Integer> partitioned = partitionList(n, 6);
	System.out.println(partitioned.toString());
}

}
