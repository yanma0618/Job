package Recursive;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EightQueue eq=new EightQueue();
		ArrayList<int[]> res=eq.getresult();
		for(int[] board:res){
			for(int i=0;i<8;i++){
				System.out.print(i+","+board[i]+" ");
			}
			System.out.println();
		}
		
	}

}
