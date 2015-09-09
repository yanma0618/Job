package Tree;

import java.util.LinkedList;

public class AvlNode<T extends IAvlType> {
	T element;
	AvlNode<T> left;
	AvlNode<T> right;
	int height;
	
	public AvlNode(T theElement){
		this(theElement, null, null);
	}
	
	public void print(AvlNode<T> rt){
		LinkedList<AvlNode<T>> pre=new LinkedList<AvlNode<T>>();
		pre.add(rt);
		while(pre.size()>0){
			LinkedList<AvlNode<T>> cur=new LinkedList<AvlNode<T>>();
			for(AvlNode<T> node:pre){
				node.element.print();
				if(node.left!=null) cur.add(node.left);
				if(node.right!=null) cur.add(node.right);
			}
			System.out.println();
			pre=cur;
		}
	}
	
	public void inorder(AvlNode<T> rt){
		if(rt==null) return;
		inorder(rt.left);
		rt.element.print();
		inorder(rt.right);
	}
	
	public AvlNode(T theElement, AvlNode<T> lt, AvlNode<T> rt){
		this.element=theElement;
		this.left=lt;
		this.right=rt;
		this.height=0;
	}
	
	public int height(AvlNode<T> t){
		return t==null?-1:t.height;
	}
	
	public AvlNode<T> insert(T x, AvlNode<T> t){
		if(t==null){
			return new AvlNode<T>(x,null,null);
		}
		int comRes=x.compareTo(t.element);
		if(comRes<0){
			t.left=insert(x,t.left);
		}else if(comRes>0){
			t.right=insert(x,t.right);
		}
		return balance(t);
	}
	
	
	
	private static final int ALLOWED_IMBALANCE=1;
	
	public AvlNode<T> balance(AvlNode<T> t){
		if(t==null){
			return t;
		}
		
		if(height(t.left) - height(t.right) > ALLOWED_IMBALANCE ){
			if(height(t.left.left)>= height(t.left.right) ){
				t=rotateWithLeftChild(t);
			}else{
				t=doubleWithLeftChild(t);
			}
		}else if( height( t.right ) - height( t.left ) > ALLOWED_IMBALANCE ){
			if( height( t.right.right ) >= height( t.right.left ) ){
				t = rotateWithRightChild( t );
			}else{
				t = doubleWithRightChild( t );
			}
		}
		t.height = Math.max( height( t.left ), height( t.right ) ) + 1;	
		return t;
	}
	
	
	public AvlNode<T> rotateWithLeftChild(AvlNode<T> k2){
		AvlNode<T> k1=k2.left;
		k2.left=k1.right;
		k1.right=k2;
		k2.height=Math.max( height(k2.left), height(k2.right) )+1;
		k1.height=Math.max( height(k1.left),height(k1.right) )+1;
		return k1;
	}
	
	public AvlNode<T> rotateWithRightChild(AvlNode<T> k1){
		AvlNode<T> k2=k1.right;
		k1.right=k2.left;
		k2.left=k1;
		k2.height=Math.max( height(k2.left), height(k2.right) )+1;
		k1.height=Math.max( height(k1.left),height(k1.right) )+1;
		return k2;
	}
	
	public AvlNode<T> doubleWithLeftChild(AvlNode<T> k3){
		k3.left=rotateWithRightChild(k3.left);
		return rotateWithLeftChild(k3);
	}
	
	public AvlNode<T> doubleWithRightChild(AvlNode<T> k1){
		k1.right=rotateWithLeftChild(k1.right);
		return rotateWithRightChild(k1);
	}
	
}

