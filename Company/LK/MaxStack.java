package LK;

import java.util.Stack;

public class MaxStack {

	public static void main(String[] args) {
		MaxStack stack = new MaxStack();
		stack.push(1);
		stack.push(2);
		stack.push(4);
		stack.push(3);
		System.out.println(stack.getMax()); //4
		stack.pop();
		System.out.println(stack.getMax()); //4
		System.out.println(stack.top()); //4
	}
	
	Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> maxStack= new Stack<Integer>();

    public void push(int x) {
        stack.push(x);
        if(maxStack.isEmpty() || x>=maxStack.peek()){
            maxStack.push(x);
        }
    }

    public void pop() {
        int top=stack.pop();
        if(top==maxStack.peek()){
            maxStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMax() {
        return maxStack.peek();
    }

}
