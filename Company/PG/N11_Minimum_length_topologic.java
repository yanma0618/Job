package PG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class N11_Minimum_length_topologic {
	
	public static void main(String[] args){
		N11_Minimum_length_topologic s = new N11_Minimum_length_topologic();
		String[] str={"cba", "bd", "ce", "ed"};
		System.out.print( s.convert(str));
	}
	
	
//	public ArrayList<ArrayList<Integer>> solution(String[] strs){
//		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
//		for (int i = 0; i < 26; i++) {
//			adj.add(new ArrayList<Integer>());
//		}
//		for (int i = 0; i < strs.length; i++) {
//			for (int j = 0; j < strs[i].length() - 1; j++) {
//				int a = strs[i].charAt(j) - 'a';
//				int b = strs[i].charAt(j + 1) - 'a';
//				if (a == b) continue;
//				adj.get(a).add(b);
//			}
//		}
//		return adj;
//	}
	
	 
	public String convert(String[] strs){
		HashMap<Character,Node> map=new HashMap<Character,Node>();
		
		for(String str:strs){
			char c=str.charAt(0);
			if(!map.containsKey(c)){
				map.put(c, new Node(c));
			}
			for(int i=1;i<str.length();i++){
				char tmp=str.charAt(i);
				Node node=null;
				if(map.containsKey(tmp)){
					node=map.get(tmp);
				}else{
					node=new Node(tmp);
					map.put(tmp, node);
				}
				node.dep++;
				map.get(c).neighbors.add(node);
				c=tmp;
			}			
		}
		
		StringBuilder sb=new StringBuilder();
		Queue<Character> queue = new LinkedList<Character>();
		for(Character c:map.keySet()){
			if(map.get(c).dep==0) queue.add(c);
		}
		while(!queue.isEmpty()){
			char c=queue.poll();
			sb.append(c);
			for(Node n:map.get(c).neighbors){
				n.dep--;
				if(n.dep==0){
					queue.add(n.c);
				}
			}
		}
		
		return sb.toString();
	}
}

class Node{
	char c;
	List<Node> neighbors;
	int dep;
	public Node(char c){
		this.c=c;
		neighbors = new ArrayList<Node>();
		dep=0;
	}
}

