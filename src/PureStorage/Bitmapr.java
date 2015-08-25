package PureStorage;

public class Bitmapr {
	static int[][] bitmap;
	
	public static void main(String[] args){
		init(1);
		print();
		clearBit(10,5,5);
		print();
	}
	
	static void init(int val){
		bitmap=new int[20][20];
		for(int i=0;i<bitmap.length;i++){
			for(int j=0;j<bitmap[0].length;j++){
				bitmap[i][j]=val;
			}
		}
	}
	
	static void print(){
		for(int[] tmp:bitmap){
			for(int n:tmp){
				System.out.print(n+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	static void clearBit(int r, int x, int y){
		boolean[][] visited=new boolean[bitmap.length][bitmap[0].length];
		setvalue(r,x,y,0, x, y, visited);
	}
	
	static void setBit(int r, int x, int y){
		boolean[][] visited=new boolean[bitmap.length][bitmap[0].length];
		setvalue(r,x,y,1,x,y,visited);
	}
	
	static void setvalue(int r, int x, int y, int value, int xo, int yo, boolean[][] v){
		if((x-xo)*(x-xo)+(y-yo)*(y-yo)>r*r) return;
		if(x<0 || x>=bitmap.length || y<0 || y>=bitmap[0].length)return ; 
		if(v[x][y]) return;
		v[x][y]=true;
		bitmap[x][y]=value;
		setvalue(r,x+1,y,value,xo,yo,v);
		setvalue(r,x-1,y,value,xo,yo,v);
		setvalue(r,x,y+1,value,xo,yo,v);
		setvalue(r,x,y-1,value,xo,yo,v);
	}
}
