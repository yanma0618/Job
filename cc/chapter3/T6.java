package chapter3;

import java.util.Stack;

public class T6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> s=new Stack<Integer>();
		s.push(4); s.push(3); s.push(7);
		s.push(2); s.push(10);
		s=sort(s);
		while(!s.isEmpty()){
			System.out.println(s.pop());
		}
	}
	
	private static Stack<Integer> sort(Stack<Integer> s){
		Stack<Integer> r=new Stack<Integer>();
		while(!s.isEmpty()){
			int tmp=s.pop();
			while(!r.isEmpty() && r.peek()>tmp){
				s.push(r.pop());
			}
			r.push(tmp);
		}
		
		return r;
	}
}
