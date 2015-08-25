package chapter4;

public class T5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		Tree result=findnext(t6);
		if(result==null)	 System.out.println("null");
		else System.out.println(result.data);
	}
	
	private static Tree findnext(Tree r){
		if(r.rchild!=null){
			Tree tmp=r.rchild;
			while(tmp.lchild!=null){
				tmp=tmp.lchild;
			}
			return tmp;
		}
		else if(r.parent==null)
			return r.parent;
		else{
			Tree tmp=r;
			Tree p=tmp.parent;
			while(p!=null && p.rchild==tmp){
				tmp=p;
				p=p.parent;
			}
			return p;
		}
	}
	
}
