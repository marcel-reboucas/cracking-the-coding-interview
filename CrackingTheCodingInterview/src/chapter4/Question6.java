package chapter4;

import util.TreeNode;

/***
 * Write an algorithm to find the 'next'node (i.e., in-order successor) of a given node in
 * a binary search tree. You may assume that each node has a link to its parent.
 *
 */
public class Question6 {
	
	public static TreeNode nextNode(TreeNode node) {
		
		if (node == null) { return null; }
		
		if (node.right != null) {
			
			// get the left child of the right tree
			TreeNode rightTree = node.right;
			TreeNode leftChild = rightTree;
			
			while(leftChild.left != null) {
				leftChild = leftChild.left;
			}
			return leftChild;	
			
		} else {
			
			while (node != null && node.parent != null && node == node.parent.right) {
				node = node.parent;
			}
			
			return node.parent;
		}
		
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
		System.out.println(nextNode(root.right)); 
		System.out.println(nextNode(root.right.right));
		System.out.println(nextNode(root));

	}

}
