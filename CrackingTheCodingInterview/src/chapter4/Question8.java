package chapter4;

import util.TreeNode;

/***
 * You have two very large binary trees: Tl, with millions of nodes, and T2,
 * with hundreds of nodes.Create an algorithm to decide if T2 is a subtree of
 * Tl. A tree T2 is a subtree of Tl if there exists a node n in Tl such that the
 * subtree ofn is identical to T2. That is, if you cut off the tree at node n,
 * the two trees would be identical.
 * 
 * @author Marcel
 * 
 *         Edit: My solution only works with Binary Search Trees, since this is
 *         how I implemented the find. However, it could be changed to find all
 *         subtrees starting with a certain value, and then seeing if each
 *         subtree matches what we are looking for.
 *
 */
public class Question8 {

	public static boolean equals(TreeNode t1, TreeNode t2) {

		if (t1 == null && t2 == null) {
			return true;
		} // both are null, ok
		if (t1 == null || t2 == null) {
			return false;
		} // one of them is null, not ok

		return (t1.value == t2.value) && equals(t1.left, t2.left) && equals(t1.right, t2.right);
	}

	public static boolean isSubTree(TreeNode t1, TreeNode t2) {

		if (t1 == null || t2 == null) {
			return false;
		}

		TreeNode subtreeWithSameValue = t1.find(t2.value);

		// subtreeWithSameValue.printTree(System.out);
		return equals(subtreeWithSameValue, t2);
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

		TreeNode root2 = new TreeNode(5);
		root2.insert(7);
		root2.insert(6);
		root2.insert(4);

		root2.printTree(System.out);

		System.out.println(equals(root, root2));
		System.out.println(isSubTree(root, root2));
	}
}
