package G;

public  class BinaryTreeNode {
	int val;
	BinaryTreeNode left;
	BinaryTreeNode right;
	public BinaryTreeNode(){
		
	}
	
	public BinaryTreeNode(int val){
		this.val=val;
	}
	
	public static void inorder(BinaryTreeNode root){
		if(root==null) return;
		inorder(root.left);
		System.out.print(root.val+" ");
		inorder(root.right);
	}
	//     5
	//   3    7
	// 2   4    8 
	public static BinaryTreeNode builtBST(){
		BinaryTreeNode root=new BinaryTreeNode(5);
		root.left=new BinaryTreeNode(3);
		root.right=new BinaryTreeNode(7);
		root.left.left=new BinaryTreeNode(2);
		root.left.right=new BinaryTreeNode(4);
//		root.left.left.left=new TreeNode(1);
//		root.right.left=new TreeNode(6);
		root.right.right=new BinaryTreeNode(8);
		return root;
	}
	
	
}
