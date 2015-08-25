package chapter4;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
	public int data;
	Tree lchild;
	Tree rchild;
	Tree parent;
	
	public Tree(int data){
		this.data=data;
		lchild=null;
		rchild=null;
		parent=null;
	}
	public Tree(){
		this.data=0;
		lchild=null;
		rchild=null;
		parent=null;
	}
	public void initial(){
		this.data=5;
		this.lchild=new Tree(3); this.rchild=new Tree(7); this.rchild.rchild=new Tree(8);
		this.lchild.lchild=new Tree(2); this.lchild.rchild=new Tree(4);
	}
	
	public void traverin(){
		inorder(this);
	}
	public void traverpre(){
		preorder(this);
	}
	public void traverpost(){
		postorder(this);
	}
	private void inorder(Tree r){
		if(r!=null){
			inorder(r.lchild);
			System.out.print(r.data+" ");
			inorder(r.rchild);
		}
	}
	
	private void preorder(Tree r){
		if(r!=null){
			System.out.print(r.data+" ");
			preorder(r.lchild);
			preorder(r.rchild);
		}
		return;
	}
	
	private  void postorder(Tree r){
		if(r!=null){
			postorder(r.lchild);
			postorder(r.rchild);
			System.out.print(r.data+" ");
		}
		return;
	}

	private void runbfs(Tree r){
		Queue<Tree> q=new LinkedList<Tree>();
		System.out.print(r.data+" ");
		q.add(r);
		while(!q.isEmpty()){
			r=q.poll();
			if(r.lchild!=null){
				q.add(r.lchild);
				System.out.print(r.lchild.data+" ");
			}
			if(r.rchild!=null){
				q.add(r.rchild);
				System.out.print(r.rchild.data+" ");
			}
		}
	}
	public void bfs(){
		runbfs(this);
	}
}
