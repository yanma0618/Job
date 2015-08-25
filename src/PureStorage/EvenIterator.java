package PureStorage;


public class EvenIterator {

	int end;
	int cursor;
	
	public static void main(String[] args){
		EvenIterator et = new EvenIterator(0, 21);
		while(et.hasNext()){
			System.out.println(et.next());
		}
	}
	
	public EvenIterator(int start, int end){
		this.cursor=start;
		this.end=end;
	}
	public boolean hasNext() {
		return cursor<=end;
		
	}
	public Integer next() {
		if(hasNext()){
			int res=cursor;
			cursor+=2;
			return res;
		}
		return null;
	}

}

