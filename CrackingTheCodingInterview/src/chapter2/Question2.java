package chapter2;

/**
 * Implement an algorithm to find the kth to last 
 * element of a singly linked list.
 *
 */
public class Question2 {
	

	static Integer findKthElement(Node<Integer> n, int k) {

		if (n == null || k < 0) { return null; }

		Node<Integer> slow = n;
		Node<Integer> runner = n;

		int counter = 0;
		while (counter < k) {
			if (runner.next == null) { return null; }
			runner = runner.next;
			counter++;
		}

		while(runner.next != null) {
			runner = runner.next;
			slow = slow.next;
		}

		return slow.value;
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
		Integer value = findKthElement(n,3);
		System.out.println(value);
	}

}
