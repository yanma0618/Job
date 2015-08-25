package chapter3;

import java.util.Stack;

public class T2 {
	public static void main(String[] args){
		Mystack s=new Mystack();
		s.push(0);
	//	System.out.print(s.pop());
		StackWithMin m=new StackWithMin();
		m.push(2); m.push(1); m.push(3);
		System.out.print(m.peek()+" "+m.getmin());
	}
}

class easystack {
	private Mystack<Integer> stack=null;
	private Mystack<Integer> min=null;
	public easystack(){
		stack=new Mystack();
		min=new Mystack();
	}
	public void push(int value){
		stack.push(value);
		if(min.isEmpty()) min.push(value);
		else if(value<min.peek()) min.push(value);
		else min.push(min.peek());
	}
	
	public int pop(){
		min.pop();
		return stack.pop();
	}
	
	public int peek(){
		return stack.peek();
	}
	
	public int min(){
		return min.peek();
	}
}

class StackWithMin extends Stack<Integer>{
	Stack<Integer> min;
	public StackWithMin(){
		min=new Stack<Integer>();
	}
	
	public void push(int data){
		super.push(data);
		if(min.isEmpty()) min.push(data);
		else if(data<=min.peek()){
			min.push(data);
		}
	}
	
	public Integer pop(){
		int value=super.pop();
		if(value==min.peek()) min.pop();
		return value;
	}
	
	public int getmin(){
		int value=(min.isEmpty())? Integer.MAX_VALUE:min.peek();
		return value;
	}
}















