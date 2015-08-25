package chapter4;

public class BinarySearchTree {
	public static void main(String[] args){
	BST r=new BST();
	r.insert(1);
	r.insert(2); r.insert(3); r.insert(4);
	r.traverin();
//	if(r.find(1)) System.out.println("find");
	
//	rotate(r);
//	r.traverin();
	
	}
	
	private static void rotate(Tree r){
		
		if(r==null ||(r.lchild==null && r.rchild==null) ) return ;
		
		Tree tmp=r.lchild;
		r.lchild=r.rchild;
		r.rchild=tmp;
		rotate(r.lchild);
		rotate(r.rchild);
	}
}

class BST extends Tree{
	public BST(){
		super();
	}
	public BST(int data) {
		super(data);
		// TODO Auto-generated constructor stub
	}
	public Tree insert(int data){
		return proinsert(data, this);
	}
	
	private Tree proinsert(int data,Tree r){
		if(r==null) return new BST(data);
		if(r.data==0) {
			r.data=data;
		}else if(data<r.data){
			r.lchild=proinsert(data, r.lchild);
		}else{
			r.rchild=proinsert(data, r.rchild);
		}
		return r;
	}
	
	public boolean find(int data){
		return innerfind(data,this);
	}
	
	private boolean innerfind(int data, Tree r){
		if(r==null) return false;
		if(r.data==data) return true;
		else if(data<r.data){
			return innerfind(data, r.lchild);
		}else return innerfind(data, r.rchild);
	}
}
