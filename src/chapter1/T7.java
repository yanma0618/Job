package chapter1;

public class T7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] array={ 
				{1,2,3,4,17}, 
				{5,6,7,8,18},
				{9,0,0,12,19},
				{13,14,15,16,20},
				{21,22,23,24,25}	
		};
		array=setzero(array);
		for(int i=0; i<array.length;i++){
			for(int j=0; j<array[0].length; j++){
				System.out.print(array[i][j]+" ");
			}
			System.out.println("");
		}
	}
	
	static int[][] setzero(int[][] array){
		int[] c=new int[array.length];
		int[] r=new int[array[0].length];
		//judge zero for colum and row	
		for(int i=0; i<array.length;i++){
			for(int j=0;j<array[0].length; j++){
				if(array[i][j] == 0){
					r[j]=1;
					c[i]=1;
				}
			}
		}
		//set zero for matrix
		for(int i=0;i<array.length; i++){
			for(int j=0; j<array[0].length; j++){
				if(r[j]==1 || c[i]==1){
					array[i][j]=0;
				}
			}
		}
		
		return array;
	}

}
