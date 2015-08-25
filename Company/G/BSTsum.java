package G;

import java.util.Stack;

public class BSTsum {

	

	public static void main(String[] args) {
		TreeNode r = TreeNode.builtBST();
		TreeNode.inorder(r);

	}

	static int[] twosum(TreeNode root, int sum){
		int[] res=new int[2];
		if(root==null) return null;
		LeftItr leftitr=new;
		rightitr=root;
		TreeNode left=leftnext();
		TreeNode right=rightnext();
		while(left!=right && left!=null && right!=null){
			int val =left.val+right.val;
			if(val==sum){
				res[0]=left.val;
				res[1]=right.val;
				return res;
			}
			if(val<sum){
				left=leftnext();
			}else{
				right=rightnext();
			}
		}
		
		return null;
	}

	static TreeNode leftnext() {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (leftitr == null) {
			if (!stack.isEmpty()) {
				TreeNode res = stack.pop();
				leftitr = res.right;
				return res;
			}
			return null;
		}
		stack.push(leftitr);
	}

	static TreeNode rightnext() {

	}
}

class LeftItr{
	TreeNode root;
	Stack<TreeNode> stack = new Stack<TreeNode>();
	public LeftItr(TreeNode root){
		this.root=root;
	}
}
