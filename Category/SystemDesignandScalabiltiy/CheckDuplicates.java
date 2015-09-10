package SystemDesignandScalabiltiy;

public class CheckDuplicates {
	
	public static void main(String[] args){
		int[] arr={1,1,2,2,2,3,3,4,4};
		Bitset b=new Bitset(3200);
		for(int n:arr){
			if(b.get(n)){
				System.out.println(n);
			}else{
				b.set(n);
			}
		}
	}
	
}

class Bitset{
	byte[] bitset;
	public Bitset(int size){
		bitset = new byte[size/8];
	}
	
	public void set(int n){
		bitset[n/8] |= 1<<(n%8);
	}
	
	public boolean get(int n){
		return (bitset[n/8] & (1<<(n%8))) >0;
	}
	
}