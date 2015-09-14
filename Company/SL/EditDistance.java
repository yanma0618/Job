package SL;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EditDistance {
	HashSet<String> dict=new HashSet<String>();
	
	public EditDistance(){
		dict.add("hog"); dict.add("fag"); 
	}
	public String oneEdit(String word){
		
		for(int i=0;i<word.length();i++){
			char[] ch = word.toCharArray();
			for(char c='a';c<='z';c++){
				if(ch[i]!=c){
					ch[i]=c;
					if(dict.contains(String.valueOf(ch))){
						return String.valueOf(ch);
					}
				}
			}
		}
		return null;
	}
	
	public List<String> kEdit(String word, int k){
		List<String> ret=new ArrayList<String>();
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(word,0));
		HashSet<String> visited=new HashSet<String>();
		while(!queue.isEmpty() && queue.peek().k<k){
			Node top=queue.poll();
			for(int i=0;i<top.w.length();i++){
				char[] ch = top.w.toCharArray();
				for(char c='a';c<='z';c++){
					if(ch[i]!=c){
						ch[i]=c;
						String tmp=String.valueOf(ch);
						if(!visited.contains(tmp)){
							visited.add(tmp);
							if(top.k+1==k && dict.contains(tmp)){
								ret.add(tmp);
							}else{
								queue.add(new Node(tmp,top.k+1));
							}
						}
						
					}
				}
			}
		}
		return ret;
	}
	
	public static void main(String[] args){
		EditDistance s=new EditDistance();
		System.out.println(s.oneEdit("dag"));
		System.out.println(s.kEdit("abg",2));
	}
	
}

class Node{
	String w;
	int k;
	public Node(String w, int k){
		this.w=w;
		this.k=k;
	}
}
