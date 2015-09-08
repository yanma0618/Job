package PG;

public class N6_Inorder_Sucessor_in_BST {

	public static void main(String[] args){
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		n1.parent=n2;
		n2.left=n1; n2.right=n3;
		n3.parent=n2;
		n3.right=new TreeNode(4);
		n3.right.parent=n3;
		
		N6_Inorder_Sucessor_in_BST s = new N6_Inorder_Sucessor_in_BST();
		System.out.println(s.find_suc(n1,n2).val);
	}
	
	public TreeNode find_suc(TreeNode node){
		if(node==null) return node;
		if(node.right!=null) return most_left(node.right);
		
		TreeNode pare=node.parent;
		while(pare!=null && pare.right==node){
			node=pare;
			pare=node.parent;
		}
		return pare;
	}
	
	public TreeNode find_suc(TreeNode node, TreeNode root){
		if(node==null) return null;
		
		if(node.right!=null) return most_left(node.right);
		TreeNode ret=null;
		while(root!=node){
			if(root.val<node.val){
				root=root.right;
			}else if(root.val>node.val){
				ret=root;
				root=root.left;
			}
		}
		return ret;
	}
	
	public TreeNode most_left(TreeNode node){
		while(node.left!=null){
			node=node.left;
		}
		return node;
	}
}

