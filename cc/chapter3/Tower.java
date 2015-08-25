package chapter3;

import java.util.Stack;

public class Tower {
	private Stack<Integer> disks;
	private int index;
	public Tower(int i){
		disks=new Stack<Integer>();
		index=i;
	}
	public int getindex(){
		return index;
	}
	public void add(int d){
		if(!disks.isEmpty()&&disks.peek()<=d){
			System.out.println(index+"error");
		}
		else disks.push(d);
	}
	
	public void moveTopto(Tower t){
		int top=disks.pop();
		t.add(top);
		System.out.println("Move disk "+top+" from "+this.getindex()+
				" to "+t.getindex());
	}
	
	
	public void movedisks(int n, Tower destination, Tower buffer){
		if(n>0){
			movedisks(n-1, buffer, destination);
			moveTopto(destination);
			buffer.movedisks(n-1, destination, this);
		}
	}
}
