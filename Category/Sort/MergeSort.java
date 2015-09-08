package Sort;

public  class MergeSort {
	/* merge sort */
	public static void sort(int[] a){
		int[] helper = new int[a.length];
		mergesort(a,0,a.length-1,helper);
	}

	private static void mergesort(int[] a, int left, int right, int[] helper){
		if(left<right){
			int m=(left+right)/2;
			mergesort(a,left,m,helper);
			mergesort(a,m+1, right,helper);
			merge(a, helper, left, m, right);
		}
	}

	private static void merge(int[] a, int[] helper, int left, int m, int right){
		int index=left;
		int leftstart=left, rightstart=m+1;
		while(leftstart<=m && rightstart<=right){
			if(a[leftstart]<=a[rightstart]){
				helper[index++]=a[leftstart++];
			}else{
				helper[index++]=a[rightstart++];
			}
		}
		while(leftstart<=m){
			helper[index++]=a[leftstart++];
		}
		while(rightstart<=right){
			helper[index++]=a[rightstart++];
		}
		for(int i=left;i<=right;i++){
			a[i]=helper[i];
		}
	}
}
