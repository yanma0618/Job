package chapter3;

import java.util.ArrayList;
import java.util.Stack;

public class T3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}
	
}

class ArrayStack{
	ArrayList<Stack<Integer>> as;
	public ArrayStack(){
		as=new ArrayList<Stack<Integer>>();
	}
	
	public void push(int value){
		Stack last=as.get(as.size()-1);
		if(last.size()<10){
			last.push(value);
		}else{
			Stack n=new Stack();
			n.push(value);
			as.add(n);
		}
	}
	
/*	public int pop(){
		Stack last=as.get(as.size()-1);
	}
*/



}


