package chapter4;

import java.util.*;

public class Graph {
	ArrayList<Gnode> graph;
	public Graph(){
		graph=new ArrayList<Gnode>();
	}
	
	public void initial(){
		Gnode one=new Gnode(1); Gnode two=new Gnode(2); Gnode three=new Gnode(3);
		one.list.add(two); one.list.add(three);
		three.list.add(two);
		graph.add(one); graph.add(two); graph.add(three);
	}
}
