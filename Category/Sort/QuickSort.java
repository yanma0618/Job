package Sort;

public  class QuickSort {
	/* qucik sort */
	public static void sort(int[] a){
		quickSort(a,0,a.length-1);
		
	}
	
	private static void quickSort(int[] a, int left, int right){
		if(left<right){
			int m=partition2(a,left,right);
			quickSort(a,left,m-1);
			quickSort(a,m+1,right);
		}
	}
	
	private static int partition1(int[] a, int left, int right){
		
		int p=a[(left+right)/2];
		swap(a,(left+right)/2, left);
		int index=left+1;
		for(int i=left+1;i<=right;i++){
			if(a[i]<p){
				swap(a,index,i);
				index++;
			}
		}
		swap(a,index-1,left);
		return index-1;
	}
	
	private static int partition2(int[] a, int left, int right){
		int p = a[(left+right)/2];
		int end=right;
		swap(a, (left+right)/2, right);
		right--;
		while(left<=right){
			while(left<=right && a[left]<p){
				left++;
			}
			
			while(left<=right && a[right]>p){
				right--;
			}
			
			if(left<=right){
				swap(a,left,right);
				left++;
				right--;
			}
		}
		swap(a,left,end);
		return left;
	}
	
	private static void swap(int[] a, int i, int j){
		int tmp=a[i];
		a[i]=a[j];
		a[j]=tmp;
	}
}
