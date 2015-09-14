package SL;

//design data structure to represent a square which could be divided into 4 small squares recursively. Each square has value 1 or 0. Then, you are required to merge two given such square.
public class FourSquares {
	
	public static void main(String[] args){
		FourSquares s=new FourSquares();
		SqureNode n1=new SqureNode(-1);
		n1.c1=new SqureNode(0);
		n1.c2=new SqureNode(0);
		n1.c3=new SqureNode(0);
		n1.c4=new SqureNode(1);
		SqureNode n2=new SqureNode(-1);
		n2.c1=new SqureNode(1);
		n2.c2=new SqureNode(0);
		n2.c3=new SqureNode(1);
		n2.c4=new SqureNode(1);
		SqureNode ret=s.merge(n1, n2);
		System.out.print(ret.val);
	}
	
	public SqureNode merge(SqureNode n1, SqureNode n2){
		
		if(n1.val==0 || n2.val==1) return n1;
		if(n2.val==0 || n1.val==1) return n2;
		SqureNode root=new SqureNode(-1);
		
		root.c1=merge(n1.c1, n2.c1);
		root.c2=merge(n1.c2, n2.c2);
		root.c3=merge(n1.c3, n2.c3);
		root.c4=merge(n1.c4, n2.c4);
		root.update();
		return root;
		
	}
}


class SqureNode{
	int val;
	SqureNode c1;
	SqureNode c2;
	SqureNode c3;
	SqureNode c4;
	public SqureNode(int val){
		this.val=val;
	}
	
	public void update(){
		if(c1!=null && c1.val==1 &&c2!=null && c2.val==1 && c3!=null && c3.val==1 && c4!=null &&c4.val==1 ){
			this.val=1;
			c1=c2=c3=c4=null;
		}
		if(c1!=null && c1.val==0 &&c2!=null && c2.val==0 && c3!=null && c3.val==0 && c4!=null &&c4.val==0 ){
			this.val=0;
			c1=c2=c3=c4=null;
		}
	}
}