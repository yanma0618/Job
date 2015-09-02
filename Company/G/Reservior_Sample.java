package G;

import java.util.Random;

public class Reservior_Sample {

	public static void main(String[] args) {
		int[] list={1,2,3,4,5,6,7,8,9,10};
		int k=1;
		selectK(list,k);
		for(int i=0;i<k;i++){
			System.out.print(list[i]+" ");
		}
	}
	
	static void selectK(int[] list, int k){
		Random r=new Random();
		for(int i=k;i<list.length;i++){
			int m = r.nextInt(i+1);
			System.out.println(m);
			if(m<=k-1){
				swap(list,m,i);
			}
		}
	}
	
	static void swap(int[] list, int i, int j){
		int tmp=list[i];
		list[i]=list[j];
		list[j]=tmp;
	}

}
