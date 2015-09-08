package Sort;

public class MergeTwoArr {
	public void mergetoa(int[] a, int[] b){
		int index=a.length-1;
		int ib=b.length-1;
		int ia=0;
		while(a[ia]!=0) ia++;
		ia--;
		while(ia>=0 && ib>=0){
			if(a[ia]>=b[ib]){
				a[index--]=a[ia--];
			}else{
				a[index--]=b[ib--];
			}
		}
		while(ib>=0){
			a[index--]=b[ib--];
		}
	}
}
