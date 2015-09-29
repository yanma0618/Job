package AP;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeAndDeserializeNnaryTree {
	
	
	public void serize(TreeNode root){
		if(root==null) System.out.print("#,");
		System.out.println(root.val+",");
		serize(root.left);
		serize(root.right);
	}
}

class TreeNode{
	int val;
	List<TreeNode> children;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val){
		this.val=val;
	}
}
