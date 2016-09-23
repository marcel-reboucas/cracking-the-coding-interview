package util;

import java.io.PrintStream;

public class TreeNode {
	
	public int value;
	public TreeNode left;
	public TreeNode right;
	public TreeNode parent;

	public TreeNode(int value){
		this.value = value;
	}
	
	public void insert(int newValue) {
		
		//do not allow repeated values
		if (newValue == value) return;
		
		if (newValue < value) {
			if (left != null) {
				left.insert(newValue);
			} else {
				left = new TreeNode(newValue);
				left.parent = this;
			}
		} else {
			if (right != null) {
				right.insert(newValue);
			} else {
				right = new TreeNode(newValue);
				right.parent = this;
			}
		}
	}
	
	public String toString() {
		return Integer.toString(value) + "-("+left+", "+right +")";
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.insert(1);
		root.insert(5);
		root.insert(7);
		root.insert(2);
		root.insert(6);
		root.insert(4);
		root.printTree(System.out);
	}
	
	 public void printTree(PrintStream out){
	        if (right != null) {
	            right.printTree(out, true, "");
	        }
	        printNodeValue(out);
	        if (left != null) {
	            left.printTree(out, false, "");
	        }
	    }
	    private void printNodeValue(PrintStream out) {
	        
	        out.print(Integer.toString(value));
	        out.print('\n');
	    }
	    // use string and not stringbuffer on purpose as we need to change the indent at each recursion
	    private void printTree(PrintStream out, boolean isRight, String indent) {
	        if (right != null) {
	            right.printTree(out, true, indent + (isRight ? "        " : " |      "));
	        }
	        out.print(indent);
	        if (isRight) {
	            out.print(" /");
	        } else {
	            out.print(" \\");
	        }
	        out.print("----- ");
	        printNodeValue(out);
	        if (left != null) {
	            left.printTree(out, false, indent + (isRight ? " |      " : "        "));
	        }
	    }
}
