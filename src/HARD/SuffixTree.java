package HARD;

import java.util.ArrayList;

public class SuffixTree {
	SuffixNode root= new SuffixNode();
	public SuffixTree(String s){
		for(int i=0; i<s.length();i++){
			root.insert(s.substring(i), i);
		}
	}
	
	public ArrayList<Integer> getIndexes(String s){
		return root.getIndex(s);
	}
}
