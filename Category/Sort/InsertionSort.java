package Sort;

public  class InsertionSort {
	public static void sort(int[] a) {
		int j;
		for(int i=1;i<a.length;i++){
			int tmp=a[i];
			for(j=i;j>0 && a[j-1]>tmp;j--){
				a[j]=a[j-1];
			}
			a[j]=tmp;
		}
	}
}
