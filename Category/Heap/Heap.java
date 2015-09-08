package Heap;

public class Heap {
	int[] array;
	int current_size;
	int size=30;
	public Heap(){
		array = new int[size];
		current_size=0;
	}
	
	public void insert(int x){
		int hole=++current_size;
		array[hole]=x;
		percolateUp(hole);
		
		
	}
	
	
	
	public void build(int[] input){
		for(int i=0;i<input.length;i++){
			array[i+1]=input[i];
		}
		current_size=input.length;
		for(int i=current_size/2;i>0;i--){
			percolateDown(i);
		}
	}
	
	public void enlargeArray(int size){
		
	}
	
	public boolean isEmpty(){
		return current_size==0;
	}
	
	public int findMin(){
		if(this.isEmpty()){
			
		}
		return array[1];
	}
	
	public int deletMin(){
		if(isEmpty()){
			
		}
		int item = findMin();
		array[1]=array[current_size--];
		percolateDown(1);
		return item;
	}
	
	public void print(){
		for(int i=1;i<current_size+1;i++){
			System.out.println(i+" "+array[i]);
		}
	}
	
	private void percolateDown(int hole){
		int child=hole*2;
		int tmp = array[hole];
		for(;hole*2<=current_size;hole=child){
			child = hole*2;
			if(child<current_size && array[child+1]<array[child]){
				child++;
			}
			if(array[child]<tmp){
				array[hole]=array[child];
			}else{
				break;
			}
		}
		array[hole]=tmp;
	}
	private void percolateUp(int hole){
		int x = array[hole];
		for(array[0]=x;array[hole/2]>x;hole/=2){
			array[hole]=array[hole/2];
		}
		array[hole]=x;
		
	}
}
