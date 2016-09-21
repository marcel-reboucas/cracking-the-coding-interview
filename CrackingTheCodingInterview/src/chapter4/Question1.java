package chapter4;

import util.TreeNode;

/***
 * 
 * Implement a function to check if a binary tree is balanced. 
 * For the purposes of this question, a balanced tree is defined to
 * be a tree such that the heights of the two subtrees of any node 
 * never differ by more than one.
 * 
 * 
 * Possible improvements after seeing the solution:
 * 	implemented the getHeight already checking if it is balanced.
 */

public class Question1 {

	public static int getHeight(TreeNode node) {

		if (node == null) { return 0; };

		return 1 + Math.max(getHeight(node.left), getHeight(node.right));
	}

	public static boolean checkBalance(TreeNode node) {

		if (node == null) { return true; };
		
		boolean isBalanced = Math.abs(getHeight(node.left) - getHeight(node.right)) <= 1;
		return isBalanced && checkBalance(node.left) && checkBalance(node.right);
	}
	
	public static int getHeightCheckingBalance(TreeNode node) {

		if (node == null) { return 0; };

		int leftHeight = getHeight(node.left);
		if (leftHeight == -1) { return -1; }
		
		int rightHeight = getHeight(node.right);
		if (rightHeight == -1) { return -1; }
		
		if (Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		} 
		
		return 1 + Math.max(leftHeight, rightHeight);
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
		System.out.println(getHeight(root));
		System.out.println(checkBalance(root));
		System.out.println(getHeightCheckingBalance(root));
	}
	
}
