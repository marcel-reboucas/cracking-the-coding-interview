package chapter3;

public class Question2 {
	public static void main(String[] args) {
		ModifiedStack stack = new ModifiedStack();
		
		stack.push(5);
		System.out.println(stack.toString());
		System.out.println(stack.min());
		stack.push(3);
		stack.push(8);
		stack.push(1);
		stack.push(2);
		System.out.println(stack.toString());
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.toString());
		System.out.println(stack.min());
		stack.pop();
		
		stack.pop();
		stack.pop();
		
		System.out.println(stack.toString());
		System.out.println(stack.min());
		
		stack.pop();
	}
}


class ModifiedStack extends Stack<Integer> {

	Stack<Integer> orderedStack;

	public ModifiedStack() {
		orderedStack = new Stack<Integer>();
	}

	public Integer pop() {

		Integer value = super.pop();

		if (value == min()){
			orderedStack.pop();
		}

		return value;
	}

	public void push(Integer value) {

		if (value <= min()){
			orderedStack.push(value);
		}

		super.push(value);

	}

	public Integer min(){

		if (orderedStack.top != null) {
			return orderedStack.peek();
		}
		return Integer.MAX_VALUE;
	}

	public String toString() {
		return super.top.toString() + " "+ orderedStack.top.toString();
	}
}