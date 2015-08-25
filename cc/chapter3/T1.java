package chapter3;

public class T1 {
	public static void main(String[] args){
		stack s=new stack();
		s.push(1, 1);
		s.push(1, 2);
		s.push(1, 0);
		System.out.print(s.peek(0)+s.peek(1)+s.peek(2));
		
	}
	
}
class stack{
	int size=50;
	int[] stack=new int[size*3];
	int[] stackpoint={0,0,0};
	
	public stack(){
		
	}
	
	public void push(int data, int num){
		int pos=num*size+stackpoint[num]+1;
		stack[pos]=data;
		stackpoint[num]++;
	}
	
	public int pop(int num){
		int pos=num*size+stackpoint[num];
		stackpoint[pos]--;
		int result=stack[pos];
		stack[pos]=0;
		return result;
	}
	
	public int peek(int num){
		return stack[num*size+stackpoint[num]];
	}
	
}