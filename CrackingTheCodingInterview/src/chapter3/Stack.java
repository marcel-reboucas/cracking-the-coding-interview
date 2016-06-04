package chapter3;

import chapter2.Node;

public class Stack<T> {
	
	Node<T> top;
	
	public T pop() {
		if (top != null) {
			T value = top.value; 
			top = top.next;
			return value;
		}
		return null;
	}
	
	public void push(T value){
		Node<T> newHead = new Node<T>(value);
		newHead.next = top;
		top = newHead;
	}
	
	public T peek(){
		if (top != null) {
			return top.value;
		}
		
		return null;
	}

}
