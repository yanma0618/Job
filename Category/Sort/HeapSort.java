package Sort;

public  class HeapSort {
	/* heap sort */
	private static void perlocateDown(int[] a, int i, int last){
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
	
	public static void sort(int[] a){
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
}
