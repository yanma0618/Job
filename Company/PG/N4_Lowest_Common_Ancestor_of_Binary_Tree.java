package PG;

public class N4_Lowest_Common_Ancestor_of_Binary_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public TreeNode common(TreeNode root, TreeNode p, TreeNode q){
		if(root==null|| root==p || root==q){
			return root;
		}
		TreeNode left=common(root.left,p,q);
		TreeNode right=common(root.right,p,q);
		
		if(left!=null && right!=null ) return root;
		if(left!=null) return left;
		if(right!=null) return right;
		return null;
		
	}

}
