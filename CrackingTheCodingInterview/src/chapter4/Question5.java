package chapter4;

import util.TreeNode;

/***
 * Implement a function to check if a binary tree is a binary search tree.
 *
 */
public class Question5 {
	
	public static Integer lastInt = Integer.MIN_VALUE;
	
	public static boolean checkBST(TreeNode node) {
		
		if (node == null) {return true; }
		
		boolean left = checkBST(node.left);
		
		boolean thisNode = (node.value > lastInt);
		if (thisNode) {
			lastInt = node.value;
		} else {
			return false;
		}
		
		boolean right = checkBST(node.right);
		
		return left && right;
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
		lastInt = Integer.MIN_VALUE;
		System.out.println(checkBST(root));
		
		
		root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(7);
		
		root.printTree(System.out);
		lastInt = Integer.MIN_VALUE;
		System.out.println(checkBST(root));

	}
}
