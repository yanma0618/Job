package LK;

import java.util.LinkedList;
import java.util.Queue;

public class LCA {
	public static void main(String[] args){
		TreeNode root=new TreeNode(5);
		TreeNode left=new TreeNode(3);
		TreeNode right=new TreeNode(7);
		root.left=left;left.parent=root;
		root.right=right; right.parent=root;
		TreeNode ll=new TreeNode(1);
		TreeNode lr=new TreeNode(4);
		left.left=ll;ll.parent=left;
		left.right=lr; lr.parent=left;
		TreeNode.encode(root);
		System.out.println();
		LCA s = new LCA();
		//1 3 -> 3
		System.out.println(s.lcaWithPare(root, ll, left).val);
		System.out.println(s.lca(root, ll, left).val);
		
		//1 4 -> 3
		System.out.println(s.lcaWithPare(root, ll, lr).val);
		System.out.println(s.lca(root, ll, lr).val);
		
		// 1 7 -> 5
		System.out.println(s.lcaWithPare(root, ll, right).val);
		System.out.println(s.lca(root, ll, right).val);
		
		
	}
	
	public TreeNode lcaWithPare(TreeNode root, TreeNode p, TreeNode q){
		TreeNode prun = p;
		TreeNode qrun = q;
		while(prun!=null && qrun!=null){
			prun = prun.parent;
			qrun = qrun.parent;
		}
		while(prun!=null){
			p=p.parent;
			prun=prun.parent;
		}
		while(qrun!=null){
			qrun=qrun.parent;
			q=q.parent;
		}
		while(p!=q){
			p=p.parent;
			q=q.parent;
		}
		return p;
	}
	
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

