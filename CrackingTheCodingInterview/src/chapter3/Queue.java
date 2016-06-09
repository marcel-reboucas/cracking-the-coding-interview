package chapter3;

import chapter2.Node;

public class Queue<T> {
	
	Node<T> first;
	Node<T> last;
	
	public void enqueue(T value){
		
		Node<T> newNode = new Node<T>(value);
		
		if (first == null) {
			first = newNode;
			last = newNode;
		} else {
			last.next = newNode;
		}
	}
	
	public T dequeue() {
		
		if (first != null) {
			T value = first.value;
			first = first.next;
			return value;
		}
		return null;
	}
}
