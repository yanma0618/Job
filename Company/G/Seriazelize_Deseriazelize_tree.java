package G;

import java.util.ArrayList;
import java.util.List;

public class Seriazelize_Deseriazelize_tree {

	List<String> code=new ArrayList<String>();
	public static void main(String[] args) {
		Seriazelize_Deseriazelize_tree s = new Seriazelize_Deseriazelize_tree();
		BinaryTreeNode root=BinaryTreeNode.builtBST();
		s.serizlize(root);
		root.inorder(root);
		System.out.println();
		s.print();
		BinaryTreeNode retroot=s.deserizlize();
		retroot.inorder(retroot);
		
	}
	
	public void print(){
		for(String str:code){
			System.out.print(str+" ");
		}
		System.out.println();
	}
	
	public void serizlize(BinaryTreeNode root){
		if(root==null){
			code.add("#");
			return;
		}
		code.add(""+root.val);
		serizlize(root.left);
		serizlize(root.right);
	}
	
	int index=0;
	public BinaryTreeNode deserizlize(){
		if(code.get(index).equals("#")){
			index++;
			return null;
		}
		BinaryTreeNode root=new BinaryTreeNode(Integer.parseInt(code.get(index++)));
		root.left=deserizlize();
		root.right=deserizlize();
		return root;
	}

}


