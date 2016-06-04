package chapter2;

/**
 * You have two numbers represented by a linked list, 
 * where each node contains a single digit. 
 * 
 * Possible improvements after seeing the solution:
 * - should have done with lists only, feels like I cheated :O
 */

public class Question5 {


	static Integer listToInt (Node<Integer> list, boolean reversed) {

		if (list == null) { return 0; }


		StringBuilder strBdr = new StringBuilder();

		while (list != null) {
			strBdr.append(list.value.toString());
			list = list.next;	
		}

		if (reversed) {
			return Integer.parseInt(strBdr.reverse().toString());
		} else {
			return Integer.parseInt(strBdr.toString());
		}
	}

	static Node<Integer> sumLists(Node<Integer> list1, Node<Integer> list2, boolean reversed) {

		if (list1 == null && list2 == null) { return null; }

		Node<Integer> result = null;

		Integer number1 = listToInt(list1, reversed);
		Integer number2 = listToInt(list2, reversed);

		Integer sum = number1 + number2;

		String sumString;

		if (reversed) {
			sumString = new StringBuilder(sum.toString()).reverse().toString();
		} else {
			sumString = sum.toString();
		}

		for (char c : sumString.toCharArray()) {
			Integer value = new Integer(String.valueOf(c));
			
			if (result == null) { 
				result = new Node<Integer>(value); 
			} else {
				result.addToTail(value);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		Node<Integer> number1 = new Node<Integer>(1);
		number1.addToTail(4);
		number1.addToTail(3);
		
		Node<Integer> number2 = new Node<Integer>(2);
		number2.addToTail(7);
		number2.addToTail(1);
		
		Node<Integer> result = sumLists(number1, number2, false);
		
		System.out.println(number1);
		System.out.println(number2);
		System.out.println("- - - - - - - +");
		System.out.println(result);
	}
	
}
