package chapter4;

import util.TreeNode;

/***
 * Design an algorithm and write code to find the first common ancestor of two
 * nodes inabinarytree.Avoidstoringadditional
 * nodesinadatastructure.NOTE:Thisisnot necessarily a binary search tree.
 *
 */
public class Question7 {

	public static boolean nodeExists(TreeNode root, TreeNode node) {
		if (root == null || node == null) {
			return false;
		}

		if (node == root) {
			return true;
		} else {
			return nodeExists(root.left, node) || nodeExists(root.right, node);
		}
	}

	public static TreeNode findCommonNode(TreeNode root, TreeNode node1, TreeNode node2) {

		if (root == null || node1 == null || node2 == null) {
			return null;
		}

		boolean node1OnTheLeft = nodeExists(root.left, node1);
		boolean node2OnTheLeft = nodeExists(root.left, node2);
		boolean node1OnTheRight = nodeExists(root.right, node1);
		boolean node2OnTheRight = nodeExists(root.right, node2);

		if (node1OnTheLeft && node2OnTheLeft) {
			return findCommonNode(root.left, node1, node2);
		} else if (node1OnTheRight && node2OnTheRight) {
			return findCommonNode(root.right, node1, node2);
		} else {
			return root;
		}
	}

	public static TreeNode findCommon(TreeNode root, TreeNode node1, TreeNode node2) {

		if (!nodeExists(root, node1) || !nodeExists(root, node2)) {
			return null;
		}

		return findCommonNode(root, node1, node2);
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

		TreeNode t6 = root.right.right.left;
		TreeNode t7 = root.right.right;
		TreeNode t4 = root.right.left;
		TreeNode t2 = root.left.right;

		System.out.println(findCommon(root, t6, t4));
		System.out.println(findCommon(root, t2, t4));
		System.out.println(findCommon(root, t7, t6));
	}
}
