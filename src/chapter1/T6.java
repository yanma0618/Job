package chapter1;

public class T6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] array={ 
				{1,2,3,4,17}, 
				{5,6,7,8,18},
				{9,10,11,12,19},
				{13,14,15,16,20},
				{21,22,23,24,25}
				
		};
		
		array=rotate(array, array.length);
		for(int i=0; i<array.length;i++){
			for(int j=0; j<array[0].length; j++){
				System.out.print(array[i][j]+" ");
			}
			System.out.println("");
		}
	//	System.out.println(array.length);
	}
	static int[][] rotate(int[][] array, int N){
		for(int j=0; j<N/2; j++){
			int end=N-j-1;
			int offset=0;
			for(int i=j; i<=end-1;i++){
				int tmp=array[j][i];
				array[j][i]=array[i][end];
				array[i][end]=array[end][end-(i-j)];
				array[end][end-(i-j)]=array[end-(i-j)][j];
				array[end-(i-j)][j]=tmp;
			}
		}
		
		return array;
	}

}
