package PG;

public class N5_Sort_Color {

	public static void main(String[] args) {
		int[] list={0,1,2,1,0,0,0,1,1,0};
		N5_Sort_Color s= new N5_Sort_Color();
//		s.sort(list);
		s.sort_a(list);
		for(int n: list)
			System.out.print(n+" ");
	}
	
	public void sort(int[] list){
		int idx0=0;
		int idx2=list.length-1;
		int i=0;
		while(i<=idx2){
			if(list[i]==0){
				swap(list, idx0, i);
				idx0++;
				i++;
			}else if(list[i]==2){
				swap(list,idx2,i);
				idx2--;
			}
			else i++;
		}
	}
	
	public void sort_a(int[] list){
		int idx0=0;
		int idx1=0;
		for(int i=0;i<list.length;i++){
			if(list[i]==0){
				list[i]=2;
				list[idx1++]=1;
				list[idx0++]=0;
			}else if(list[i]==1){
				list[i]=2;
				list[idx1++]=1;
			}
		}
	}
	
	public void swap(int[] list, int i, int j){
		int tmp=list[i];
		list[i]=list[j];
		list[j]=tmp;
	}

}
