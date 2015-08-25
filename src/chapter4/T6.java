package chapter4;

public class T6 {
	public static void main(String[] args){
		Tree r=new Tree(5);
		Tree t3=new Tree(3); Tree t6=new Tree(6); Tree t2=new Tree(2); Tree t4=new Tree(4);
		r.lchild=t3; t3.parent=r; 
		r.rchild=t6; t6.parent=r;
		t3.lchild=t2; t2.parent=t3;
		t3.rchild=t4; t4.parent=t3;
		Tree t7=new Tree(7);
		t7.lchild=r; r.parent=t7;
		t7.traverin();
		System.out.println();
		
		Tree result=commonAncestor(t7, t3, t6);
		if(result==null)	 System.out.println("null");
		else System.out.println(result.data);
		
	}
	
	private static Tree commonAncestor(Tree r, Tree p, Tree q){
		if(cover(r.lchild, p) && cover(r.lchild, q))
			return commonAncestor(r.lchild, p, q);
		if(cover(r.rchild,p) && cover(r.rchild, q))
			return commonAncestor(r.rchild, p,q);
		return r;
	}
	
	private static boolean cover(Tree r, Tree n){
		if(r==null) return false;
		if(r==n) return true;
		return cover(r.lchild, n) || cover(r.rchild, n);
	}
}
