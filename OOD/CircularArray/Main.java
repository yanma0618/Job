package CircularArray;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularArray<String> array = new CircularArray<String>(3);
		array.set(0, "a");
		array.set(1, "b");
		array.set(2, "c");
		
		for(String str:array){
			System.out.print(str+" ");
		}
		
		array.rotate(1);
		for(String str:array){
			System.out.print(str+" ");
		}
//		Iterator<String> itr=array.iterator();
//		while(itr.hasNext()){
//			
//		}
	}

}
