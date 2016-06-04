package chapter2;


/**
 * You have two numbers represented by a linked list, 
 * where each node contains a single digit. 
 * 
 * Possible improvements after seeing the solution:
 * - could've just compare the first half of the lists.
 */
public class Question7 {

	static Node<Integer> reverseList(Node<Integer> list) {

		Node<Integer> result = null;

		Node<Integer> newHead;

		while (list != null) {
			newHead = new Node<Integer>(list.value);
			newHead.next = result;
			result = newHead;

			list = list.next;
		}

		return result;
	}

	static boolean isPalindrome(Node<Integer> list1) {

		Node<Integer> reversed = reverseList(list1);

		while (list1 != null) {

			if(list1.value != reversed.value) {
				return false;
			}

			list1 = list1.next;
			reversed = reversed.next;
		}

		return true;
	}

	public static void main(String[] args) {
		Node<Integer> number1 = new Node<Integer>(1);
		number1.addToTail(4);
		number1.addToTail(2);
		number1.addToTail(4);
		number1.addToTail(1);

		boolean result = isPalindrome(number1);

		System.out.println(reverseList(number1).toString() + " palindrome: "+result);

	}

}
