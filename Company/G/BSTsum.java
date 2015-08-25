package G;

import java.util.Stack;

public class BSTsum {


	public static void main(String[] args) {
		TreeNode r = TreeNode.builtBST();
		TreeNode.inorder(r);
		System.out.println();
		int[] res = twosum(r, 4);
		for(int n:res) System.out.print(n+" ");
	}

	static int[] twosum(TreeNode root, int sum){
		int[] res=new int[2];
		if(root==null) return null;
		LeftItr leftitr=new LeftItr(root);
		RightItr rightitr=new RightItr(root);
		TreeNode left=leftitr.next();
		TreeNode right=rightitr.next();
		while(left!=right && left!=null && right!=null){
			int val= left.val+right.val;
			if(val==sum){
				res[0]=left.val;
				res[1]=right.val;
				return res;
			}
			if(val<sum){
				left=leftitr.next();
				
			}else{
				right=rightitr.next();
			}
		}
		
		return null;
	}

}

class LeftItr{
	TreeNode root;
	Stack<TreeNode> stack = new Stack<TreeNode>();
	public LeftItr(TreeNode root){
		this.root=root;
	}
	
	public TreeNode next(){
		while(root!=null){
			stack.push(root);
			root=root.left;
		}
		if(!stack.isEmpty()){
			TreeNode ret=stack.pop();
			root=ret.right;
			return ret;
		}
		return null;
	}
}

class RightItr{
	TreeNode root;
	Stack<TreeNode> stack = new Stack<TreeNode>();
	public RightItr(TreeNode root){
		this.root=root;
	}
	
	public TreeNode next(){
		while(root!=null){
			stack.push(root);
			root=root.right;
		}
		if(!stack.isEmpty()){
			TreeNode ret=stack.pop();
			root=ret.left;
			return ret;
		}
		return null;
	}
}


