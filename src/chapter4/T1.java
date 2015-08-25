package chapter4;

public class T1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree r=new Tree();
		r.initial();
		r.traverin();
		if(isBalance(r)) System.out.println("balance");
	}
	
	private static boolean isBalance(Tree r){
		if(Math.abs(min(r)-max(r))<=1) return true;
		return false;
	}
	
	private static int min(Tree r){
		if(r==null)	return 0;
		return Math.min(min(r.lchild)+1, min(r.rchild)+1);
	}
	
	private static int max(Tree r){
		if(r==null)	return 0;
		return Math.max(max(r.lchild)+1, max(r.rchild)+1);
	}
}
