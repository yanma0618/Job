package HARD;

import java.util.ArrayList;

public class Eight {
	public static void main(String[] args){
		String test="mississippi";
		String[] stlist={"is", "sip", "hi", "sis"};
		SuffixTree tree=new SuffixTree(test);
		for(String s: stlist){
			ArrayList<Integer> list=tree.getIndexes(s);
			if(list!=null){
				System.out.println(s+":"+list.toString());
			}
		}
	}
}
