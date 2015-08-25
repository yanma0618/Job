package sort;

public class sort {
	public static void main(String[] args){
		int[] num={2,40,34,5,6,10,90,45};
		int[] tmp=new int[num.length];
	//	mergesort(num,0,num.length-1, tmp);
		quicksort(num,0, num.length-1);
//		System.out.print(selectkth(num,0,num.length-1, 4));
		for(int i:num) System.out.print(i+" ");
	}
	static void mergesort(int[] num, int low, int high, int[] tmp){
		if(low<high){
			int middle=(low+high)/2;
			mergesort(num, low, middle, tmp);
			mergesort(num, middle+1, high, tmp);
			merge(num, low, middle, high, tmp);
		}
	}
	static void merge(int[] num, int low, int middle, int high, int[] tmp){
		for(int i=low; i<=high;i++){
			tmp[i]=num[i];
		}
		int left=low, right=middle+1, index=low;
		while(left <=middle && right<=high){
			if(tmp[left]<=tmp[right]){
				num[index]=tmp[left++];
			}else{
				num[index]=tmp[right++];
			}
			index++;
		}
		while(left<=middle){
			num[index++]=tmp[left++];
		}
	}
	
	static void quicksort(int[] num, int left, int right){
		int index=partition(num,left,right);
		System.out.println(index);
		if(left<index-1) quicksort(num, left, index-1);
		if(right>index) quicksort(num, index, right);
	}
	static int selectkth(int[] num, int left, int right, int k){
		int pivot=num[(left+right)/2];
		int index=partition(num, left, right);
		if(k<index) return selectkth(num, left, index-1, k);
		if(k>index) return selectkth(num, index,right,k-index);
		else return pivot;
	}
	static int partition(int[] num, int left, int right){
		int pivot=num[(left+right)/2];
		while(left<=right){
			while(num[left]<=pivot) left++;
			while(num[right]>pivot) right--;
			if(left<=right){
				int tmp=num[left];
				num[left]=num[right];
				num[right]=tmp;
				left++;
				right--;
			}
		}
		return left;
	}
	
	static void swap(int[] a, int i, int j){
		
	}
}
