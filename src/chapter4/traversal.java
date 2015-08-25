package chapter4;

import java.util.*;

public class traversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree root=new Tree(2);
		root.lchild=new Tree(1); root.rchild=new Tree(3); root.rchild.rchild=new Tree(4);
		root.lchild.lchild=new Tree(0); 
	//	inorder(root);
	//	preorder(root);
	//	postorder(root);
	//	pre(root);
	//	in(root);
	//	post(root);
		root.bfs();
	}
	
	private static void inorder(Tree r){
		if(r!=null){
			inorder(r.lchild);
			System.out.print(r.data+" ");
			inorder(r.rchild);
		}
	}
	
	private static void preorder(Tree r){
		if(r!=null){
			System.out.print(r.data+" ");
			preorder(r.lchild);
			preorder(r.rchild);
		}
		return;
	}
	
	private static void postorder(Tree r){
		if(r!=null){
			postorder(r.lchild);
			postorder(r.rchild);
			System.out.print(r.data+" ");
		}
		return;
	}
	
	private static void pre(Tree r){
		Stack<Tree> s=new Stack<Tree>();
		while(!s.isEmpty() || r!=null){
			while(r!=null){
				System.out.print(r.data+" ");
				s.push(r);
				r=r.lchild;
			}
			if(!s.isEmpty()){
				r=s.pop();
		//		System.out.print("sd"+r.data);
				r=r.rchild;
			}
		}
	}
	
	private static void in(Tree r){
		Stack<Tree> s=new Stack<Tree>();
		while(r!=null || !s.isEmpty()){
			while(r!=null){
				s.push(r);
				r=r.lchild;
			}
			if(!s.isEmpty()){
				r=s.pop();
				System.out.print(r.data+" ");
				r=r.rchild;
			}
		}
	}

	private static void post(Tree r){
		Stack<Tree>	s=new Stack<Tree>();
		Tree visit=null;
		while(!s.isEmpty() || r!=null){
			while(r!=null){
				s.push(r);
				r=r.lchild;
			}
			if(!s.isEmpty()){
				r=s.peek();
				if(r.rchild==visit || r.rchild==null){
					System.out.print(r.data+" ");
					visit=r;
					r=null;
					s.pop();
				}else{
					r=r.rchild;
				}
			}
		}
	}
}
