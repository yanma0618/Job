package G;

public  class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(){
		
	}
	
	public TreeNode(int val){
		this.val=val;
	}
	
	public static void inorder(TreeNode root){
		if(root==null) return;
		inorder(root.left);
		System.out.print(root.val+" ");
		inorder(root.right);
	}
	
	public static TreeNode builtBST(){
		TreeNode root=new TreeNode(5);
		root.left=new TreeNode(3);
		root.right=new TreeNode(7);
		root.left.left=new TreeNode(2);
		root.left.right=new TreeNode(4);
		root.left.left.left=new TreeNode(1);
		root.right.left=new TreeNode(6);
		root.right.right=new TreeNode(8);
		return root;
	}
}
