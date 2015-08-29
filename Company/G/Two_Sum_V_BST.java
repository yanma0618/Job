package G;

import java.util.Stack;

public class Two_Sum_V_BST {


	public static void main(String[] args) {
		BinaryTreeNode r = BinaryTreeNode.builtBST();
		BinaryTreeNode.inorder(r);
		System.out.println();
		int[] res = twosum(r, 4);
		for(int n:res) System.out.print(n+" ");
	}

	static int[] twosum(BinaryTreeNode root, int sum){
		int[] res=new int[2];
		if(root==null) return null;
		LeftItr leftitr=new LeftItr(root);
		RightItr rightitr=new RightItr(root);
		BinaryTreeNode left=leftitr.next();
		BinaryTreeNode right=rightitr.next();
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
	BinaryTreeNode root;
	Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
	public LeftItr(BinaryTreeNode root){
		this.root=root;
	}
	
	public BinaryTreeNode next(){
		while(root!=null){
			stack.push(root);
			root=root.left;
		}
		if(!stack.isEmpty()){
			BinaryTreeNode ret=stack.pop();
			root=ret.right;
			return ret;
		}
		return null;
	}
}

class RightItr{
	BinaryTreeNode root;
	Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
	public RightItr(BinaryTreeNode root){
		this.root=root;
	}
	
	public BinaryTreeNode next(){
		while(root!=null){
			stack.push(root);
			root=root.right;
		}
		if(!stack.isEmpty()){
			BinaryTreeNode ret=stack.pop();
			root=ret.left;
			return ret;
		}
		return null;
	}
}


