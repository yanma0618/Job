package PS;
import java.util.ArrayList;



public class Bitmap {
	static int[][] tree;
	public static void main(String[] args) {
		tree=new int[4][8];
		int base=1;
		for(int i=0;i<4;i++){
			for(int j=0;j<base;j++){
				tree[i][j]=0;
			}
			base *=2;
		}
		print();
		setBit(2,6);
		print();
		clearBit(4,4);
		print();
	}
	
	static void print(){
		for(int[] item:tree){
			for(int n:item){
				System.out.print(n+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	static void setBit(int offset, int len){
		int row = tree.length-1;
		ArrayList<Integer> queue=new ArrayList<Integer>();
		for(int i=offset;i<offset+len;i++){
			if(tree[row][i]!=1) {
				tree[row][i]=1;
				queue.add(i);
			}
		}
		change(row,queue);
	}
	
	static void change(int row, ArrayList<Integer> queue){
		while(queue.size()>0 && row>0) {
			ArrayList<Integer> cur = new ArrayList<Integer>();
			for(int i=0;i<queue.size();i++){
				int col=queue.get(i);
				if(col%2==0){
					int tmp=tree[row][col]&tree[row][col+1];
					if(tree[row-1][col/2]!=tmp){
						cur.add(col/2);
						tree[row-1][col/2]=tmp;
					}
				}else{
					if(i>0 && queue.get(i-1)==col-1) continue;
					int tmp=tree[row][col]&tree[row][col-1];
					if(tree[row-1][col/2]!=tmp){
						cur.add(col/2);
						tree[row-1][col/2]=tmp;
					}
				}
			}
			queue=cur;
			row--;
		}
	}
	
	static void clearBit(int offset, int len){
		int row=tree.length-1;
		ArrayList<Integer> queue=new ArrayList<Integer>();
		for(int i=offset;i<offset+len;i++){
			if(tree[row][i]!=0) {
				tree[row][i]=0;
				queue.add(i);
			}
		}
		change(row,queue);
	}
	

}