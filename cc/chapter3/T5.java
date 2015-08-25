package chapter3;

import java.util.Stack;

public class T5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stackqueue sq=new Stackqueue();
		sq.push(1);sq.push(2);sq.push(3);
		System.out.print(sq.pop());
	}

}

class Stackqueue{
	Stack<Integer> s1;
	Stack<Integer> s2;
	public Stackqueue(){
		s1=new Stack<Integer>();
		s2=new Stack<Integer>();
	}
	
	public void push(int data){
		s1.push(data);
	}
	
	public int pop(){
		if(s2.isEmpty()){
			while(!s1.isEmpty()){
				s2.push(s1.pop());
			}
		}
		return s2.pop();
	}
	
	
	
}