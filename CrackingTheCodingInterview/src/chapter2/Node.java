package chapter2;

public class Node<T> {
	
	public Node<T> next;
	public T value;
	
	public Node(T value){
		this.value = value;
	}
	
	public void addToTail(T value){
		Node<T> newNode = new Node<T>(value);
		
		Node<T> n = this;
		
		while (n.next != null) {
			n = n.next;
		}
		
		n.next = newNode;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		
		Node<T> n = this;
		
		while (n.next != null) {
			str.append("["+n.value+"]-");
			n = n.next;
		}
		str.append("["+n.value+"]");
		
		return str.toString();
	}
	
	public static void main(String[] args) {
		Node<Integer> n = new Node<Integer>(5);
		n.addToTail(3);
		n.addToTail(7);
		System.out.println(n.toString());
	}
}
