package PG;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
		int val;
		char c;
		TreeNode left;
		TreeNode right;
		TreeNode parent;
		public TreeNode(int val){
			this.val=val;
		}
		
		public TreeNode(char c){
			this.c=c;
		}
		
		public void print(TreeNode r){
			Queue<TreeNode> queue =new LinkedList<TreeNode>();
			queue.add(r);
			while(!queue.isEmpty()){
				Queue<TreeNode> cur =new LinkedList<TreeNode>();
				while(!queue.isEmpty()){
					TreeNode node=queue.poll();
					System.out.print(node.c+" ");
					if(node.left!=null) cur.add(node.left);
					if(node.right!=null) cur.add(node.right);
				}
				System.out.println();
				queue=cur;
			}
		}
		
		public void inorder(TreeNode r){
			if(r==null) return;
			inorder(r.left);
			System.out.print(r.c+" ");
			inorder(r.right);
		}
}
