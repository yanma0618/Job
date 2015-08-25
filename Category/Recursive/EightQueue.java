package Recursive;

import java.util.ArrayList;

public class EightQueue {
	ArrayList<int[]> res=new ArrayList<int[]>();
	private boolean isfree(int r, int c, int[]board){
		for(int i=0;i<r;i++){
			for(int j=0;j<8;j++){
				if(board[i]==j){
					if(r==i||j==c) return false; //row colum
					if(Math.abs(r-i)==Math.abs(c-j)) return false;//diagonal
				}
			}
		}
		return true;
	}
	public void setqueue(int row, int[] board){
		if(row>=8){
			res.add(board);
			return;
		}
		for(int col=0;col<8;col++){
			if(isfree(row, col, board)){
				int[] tmp=board.clone();
				tmp[row]=col;
				setqueue(row+1, tmp);
			}
		}
		return;
	}
	public ArrayList<int[]> getresult(){
		int[] board=new int[8];
		setqueue(0, board);
		return res;
	}
}
