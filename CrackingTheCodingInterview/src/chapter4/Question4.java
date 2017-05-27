package chapter4;

import java.util.ArrayList;
import java.util.List;

import util.Node;
import util.TreeNode;

/***
 * 
 * Given a binary tree, design an algorithm which creates a linked list of all
 * the nodes at each depth (e.g., if you have a tree with depth D,you'll have D
 * linked lists
 *
 */
public class Question4 {

	public static List<Node<Integer>> generateLinkedLists(TreeNode node) {

		List<Node<Integer>> output = new ArrayList<Node<Integer>>();
		List<List<TreeNode>> depths = new ArrayList<List<TreeNode>>();

		if (node == null) {
			return output;
		}

		List<TreeNode> depth0 = new ArrayList<TreeNode>();
		depth0.add(node);
		depths.add(depth0);

		int depth = 0;

		while (!depths.isEmpty()) {

			List<TreeNode> currentDepth = depths.remove(0);
			List<TreeNode> children = new ArrayList<TreeNode>();

			for (TreeNode treenode : currentDepth) {
				if (output.isEmpty() || output.size() < depth + 1 || output.get(depth) == null) {
					output.add(depth, new Node<Integer>(treenode.value));
				} else {
					output.get(depth).addToTail(treenode.value);
				}

				if (treenode.left != null) {
					children.add(treenode.left);
				}
				if (treenode.right != null) {
					children.add(treenode.right);
				}
			}
			depth++;
			if (!children.isEmpty()) {
				depths.add(children);
			}
		}

		return output;
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(3);
		root.insert(1);
		root.insert(5);
		root.insert(7);
		root.insert(2);
		root.insert(6);
		root.insert(4);

		List<Node<Integer>> list = generateLinkedLists(root);
		root.printTree(System.out);
		System.out.println(list);

	}
}
