package scalabiltiy;

import java.util.BitSet;

public class checkDup {
	public void print(){}
	
	public void check(int[] arr){
		BitSet bs= new BitSet(32000);
		for(int i=0;i<arr.length;i++){
			int num=arr[i]-1;
			if(bs.get(num)){
				System.out.println(num+1);
			}else{
				bs.set(num);
			}
		}
	}
	
	
}
