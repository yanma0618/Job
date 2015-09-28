package LK;


public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode parent;

	public TreeNode(int x) {
		val = x;
	}
	
	public static void inorder(TreeNode root){
		if(root==null) return;
		inorder(root.left);
		System.out.print(root.val+" ");
		inorder(root.right);
	}
	
	public static void encode(TreeNode root){
		if(root==null) System.out.print("# ");
		else{
			System.out.print(root.val+" ");
			encode(root.left);
			encode(root.right);
		}
	}
	//     5
	//   3    7
	// 2   4    8 
	public static TreeNode builtBST(){
		TreeNode root=new TreeNode(5);
		root.left=new TreeNode(3);
		root.right=new TreeNode(7);
		root.left.left=new TreeNode(2);
		root.left.right=new TreeNode(4);
//		root.left.left.left=new TreeNode(1);
//		root.right.left=new TreeNode(6);
		root.right.right=new TreeNode(8);
		return root;
	}
}
