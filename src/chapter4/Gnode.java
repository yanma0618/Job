package chapter4;

import java.util.ArrayList;

public class Gnode {
	int data;
	State state;
	ArrayList<Gnode> list;
	
	public enum State{
		unvisit, visited,visiting;
	}
	
	public Gnode(int data){
		this.data=data;
		list=new ArrayList<Gnode>();
		state=State.unvisit;
	}
}
