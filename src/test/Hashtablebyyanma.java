package test;

import java.util.LinkedList;

public class Hashtablebyyanma {
	LinkedList[] tables=null;
	int size=50;
	
	public Hashtablebyyanma(){
		tables=new LinkedList[size];
	}
	public void put(int key, int value){
		int index=key%size;
		if(tables[index]==null){
			LinkedList head=new LinkedList();
			head.add(value);
		}else{
			tables[index].add(value);
		}
	}
	
	
	public boolean containskey(int key){
		int index=key % size;
		if(tables[index]!=null) return true;
		return false;
	}
}
