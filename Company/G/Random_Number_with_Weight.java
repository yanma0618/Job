package G;
import java.util.Random;


public class Random_Number_with_Weight {
	public static void main(String[] args){
		double[] pos={0.1,0.0,0.2,0.7};
//		for(int i=0;i<10;i++) System.out.println(getRandom(p));
		
		for(int i=0;i<10;i++) System.out.println(random_from_tree(pos));
	}
	
	public static int getRandom(double[] pos){
		double start=0;
		Random random=new Random();
		DoubleInterval[] di=new DoubleInterval[pos.length];
		for(int i=0;i<pos.length;i++){
			di[i]=new DoubleInterval(start,start+pos[i]);
			start=start+pos[i];
		}
		start=random.nextDouble();
		int l=0,r=di.length-1;
		while(l<=r){
			int m=(l+r)/2;
			if(start>=di[m].left && start<di[m].right) return m;
			if(start>=di[m].right) l=m+1;
			else r=m-1;
		}
		return 0;
	}

	public static  int random_from_tree(double[] pos){
		RandomTreeNode root = buildTree(pos, 0, pos.length-1, 0.0);
//		root.range.print();
//		root.left.range.print();
//		root.right.range.print();
		double hit=new Random().nextDouble();
		while(root.val==-1){
			if(hit<root.left.range.right){
				root=root.left;
			}else{
				root=root.right;
			}
		}
		return root.val;
		
	}
	
	public static RandomTreeNode buildTree(double[] pos, int left, int right, double start){
		RandomTreeNode root=null;
		if(left==right){
			
			root=new RandomTreeNode(new DoubleInterval(start, start+pos[left]), left);
			return root;
		}
		int m=(left+right)/2;
		RandomTreeNode lc=buildTree(pos,left,m,start);
		RandomTreeNode rc=buildTree(pos,m+1,right,lc.range.right);
		root=new RandomTreeNode(new DoubleInterval(start, rc.range.right));
		root.left=lc;
		root.right=rc;
		return root;
	}
}

class RandomTreeNode{
	DoubleInterval range;
	RandomTreeNode left;
	RandomTreeNode right;
	int val=-1;
	
	public RandomTreeNode(){
		
	}
	
	public RandomTreeNode(DoubleInterval range){
		this.range=range;
	}
	
	public RandomTreeNode(DoubleInterval range, int val){
		this.range=range;
		this.val=val;
	}
}

class DoubleInterval{
	double left;
	double right;
	
	public DoubleInterval(){}
	
	public DoubleInterval(double left, double right){
		this.left=left;
		this.right=right;
		
	}
	
	public void print(){
		System.out.println(left+"-"+right);
	}
}