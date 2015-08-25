public class Sort {
	
	public void insetionSort(int[] a) {
		int j;
		for(int i=1;i<a.length;i++){
			int tmp=a[i];
			for(j=i;j>0 && a[j-1]>tmp;j--){
				a[j]=a[j-1];
			}
			a[j]=tmp;
		}
	}
	
	public void shellSort(int[] a){
		int j;
		for(int gap=a.length/2;gap>0;gap/=2){
			for(int i=gap;i<a.length;i++){
				int tmp=a[i];
				for(j=i;j>=gap && a[j-gap]>tmp;j-=gap){
					a[j]=a[j-gap];
				}
				a[j]=tmp;
			}
		}
	}
	
	/* heap sort */
	private void perlocateDown(int[] a, int i, int last){
		int tmp=a[i];
		int hole=i;
		int child=hole*2;
		for(;hole*2+1<=last;hole=child){
			child=hole*2+1;
			if(child<last && a[child+1]>a[child]) child++;
			if(a[child]>tmp){
				a[hole]=a[child];
			}else{
				break;
			}
		}
		a[hole]=tmp;
	}
	
	public void heapSort(int[] a){
		//build heap
		for(int i=(a.length-2)/2;i>=0;i--){
			perlocateDown(a,i,a.length-1);
		}
				
		for(int last=a.length-1;last>0;last--){
			int tmp=a[last];
			a[last]=a[0];
			a[0]=tmp;
			
			perlocateDown(a,0,last-1);
		}
		
	}
	/* heap sort */
	
	/* merge sort */
public void mergesort(int[] a){
	int[] helper = new int[a.length];
	mergesort(a,0,a.length-1,helper);
}

private void mergesort(int[] a, int left, int right, int[] helper){
	if(left<right){
		int m=(left+right)/2;
		mergesort(a,left,m,helper);
		mergesort(a,m+1, right,helper);
		merge(a, helper, left, m, right);
	}
}

private void merge(int[] a, int[] helper, int left, int m, int right){
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
	
	/* qucik sort */
	public void quickSort(int[] a){
		quickSort(a,0,a.length-1);
		
	}
	
	private void quickSort(int[] a, int left, int right){
		if(left<right){
			int m=partition2(a,left,right);
			quickSort(a,left,m-1);
			quickSort(a,m+1,right);
		}
	}
	
	private int partition1(int[] a, int left, int right){
		
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
	
	private int partition2(int[] a, int left, int right){
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
	
	private void swap(int[] a, int i, int j){
		int tmp=a[i];
		a[i]=a[j];
		a[j]=tmp;
	}
	
}
