package HARD;

import java.util.ArrayList;
import java.util.Hashtable;

public class SuffixNode {
	Hashtable<Character, SuffixNode> children=new Hashtable<Character, SuffixNode>();
	ArrayList<Integer> indexs=new ArrayList<Integer>();
	char value;
	
	public SuffixNode(){}
	
	public void insert(String s, int index){
		indexs.add(index);
		if(s!=null&&s.length()>0){
			value=s.charAt(0);
			SuffixNode child=null;
			if(children.containsKey(value)){
				child=children.get(value);
			}else{
				child = new SuffixNode();
				children.put(value, child);
			}
			String remain=s.substring(1);
			child.insert(remain, index);
		}
	}
	
	public ArrayList<Integer> getIndex(String s){
		if(s==null||s.length()==0) return indexs;
		char first = s.charAt(0);
		if(children.containsKey(first)){
			String remain=s.substring(1);
			return children.get(first).getIndex(remain);
		}
		return null;
	}
}
