package LK;

import java.util.LinkedList;
import java.util.Queue;

public class LCA {
	public static void main(String[] args){
		TreeNode root=new TreeNode(5);
		TreeNode left=new TreeNode(3);
		TreeNode right=new TreeNode(7);
		TreeNode.encode(root);
	}
	
//	public TreeNode lcaP(TreeNode root, TreeNode p, TreeNode q){
//		Queue<TreeNode> queue = new LinkedList<TreeNode>();
//		queue.add(root);
//		
//	}
	
	public TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
		if(root==null || p==root || q==root){
			return root;
		}
		TreeNode left=lca(root.left,p,q);
		TreeNode right=lca(root.right,p,q);
		if(left!=null && right!=null) return root;
		return left!=null ? left : right;
	}
}

