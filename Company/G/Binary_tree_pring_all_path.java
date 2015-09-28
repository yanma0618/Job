package G;

import java.util.ArrayList;
import java.util.List;
/*
 * Print out all path in binary tree.
 */
public class Binary_tree_pring_all_path {
	public static void main(String[] args) {
		BinaryTreeNode root = BinaryTreeNode.builtBST();
		print(root, new ArrayList<Integer>());
	}

	static void print(BinaryTreeNode root, List<Integer> cur) {
		if (root == null)
			return;
		cur.add(root.val);
		if (root.left == null && root.right == null) {
			for (int n : cur) {
				System.out.print(n + ",");
			}
			System.out.println();
		} else {
			print(root.left, cur);
			print(root.right, cur);
		}

		cur.remove(cur.size() - 1);
	}
}
