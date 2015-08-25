package chapter4;

public class T3 {
	public static void main(String[] args){
		int[] array={1,2,3,4,5};
		int l=array.length;
		BST r=new BST();
		BSTcreate(r,array,0,l-1);
		r.bfs();
		r.traverin();
		System.out.println();
		Tree node=create(array,0,l-1);
		node.bfs();
	}
	private static void BSTcreate(BST r, int[] a, int s,int e){
		if(s>e) return;
		int m=(e+s)/2;
		r.insert(a[m]);
	//	r.bfs();
	//	System.out.println(a[m]);
		BSTcreate(r,a,s,m-1);
		BSTcreate(r,a,m+1,e);
	}
	
	private static Tree create(int[] a, int s,int e){
		if(s>e) return null;
		int m=(s+e)/2;
		Tree node=new Tree(a[m]);
		node.lchild=create(a,s,m-1);
		node.rchild=create(a,m+1,e);
		return node;
	}
}
