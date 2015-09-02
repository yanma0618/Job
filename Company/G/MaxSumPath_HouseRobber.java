package G;


public class MaxSumPath_HouseRobber {
	static int max=Integer.MIN_VALUE;
	public static void main(String[] args){
		BinaryTreeNode root=BinaryTreeNode.builtBST();
		root.inorder(root);
		helper(root);
		System.out.println(max);
	}
	
	static int[] helper(BinaryTreeNode root){
		//0 local 1 global
		int[] ret=new int[2];
		if(root==null){
			return ret;
		}
		int[] left=helper(root.left);
		int[] right=helper(root.right);
		ret[0]=Math.max(Math.max(left[1],right[1])+root.val, root.val);
		ret[1]=Math.max(left[0],right[0]);
		max = Math.max(ret[0],max);
		max = Math.max(root.val+left[1]+right[1],max);
		max = Math.max(ret[1],max);
		max = Math.max(max, left[0]+right[0]);
		return ret;
	}
}
