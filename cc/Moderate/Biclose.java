package Moderate;

public class Biclose {
	public int binarysearch(int[] arr, int[] brr){
		int min=Integer.MAX_VALUE;
		for(int num:brr){
			int h=0, l=arr.length-1;
			int m=0;
			while(h<=l){
				m=(h+l)/2;
				if(num==arr[m]) return 0;
				else if(num<arr[m]) l=m-1;
				else h=m+1;
				min=Math.min(min, Math.abs(arr[m]-num));
			}
		}
		return min;
	}
	public int mergesearch(int[] arr, int[] brr){
		Biwrap[] res=new Biwrap[arr.length+brr.length];
		merge(arr,brr,res);
		int min=Integer.MAX_VALUE;
		for(int i=0;i<res.length;i++){
			if(i==0) continue;
			if(res[i].getc()!=res[i-1].getc()){
				min=Math.min(min, res[i].getx()-res[i-1].getx());
			}
		}
		return min;
	}
	public void merge(int[] arr, int[] brr, Biwrap[] res){
		if(arr.length<brr.length){
			merge(brr,arr,res);
			return;
		}
		int posa=0, posb=0, posw=0;
		while(posa<arr.length){
			if(posb>=brr.length || arr[posa]<brr[posb]){
				res[posw++]=new Biwrap(arr[posa++], 'a');
			}else{
				res[posw++]=new Biwrap(brr[posb++], 'b');
			}
		}
	}
	
}
