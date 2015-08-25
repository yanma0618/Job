package Recursive;

import java.util.ArrayList;

public class Subset {
	ArrayList<ArrayList<Integer>> res;
	public ArrayList<ArrayList<Integer>> getsubset(int[] set){
		res = new ArrayList<ArrayList<Integer>>();
		dfs(new ArrayList<Integer>(), 0, set);
		return res;
	}
	
	public void dfs(ArrayList<Integer> cur, int index, int[] set){
		if(index==set.length){
			res.add(new ArrayList<Integer>(cur));
			return;
		}
		ArrayList<Integer> tmp=(ArrayList<Integer>) cur.clone();
		tmp.add(set[index]);
		dfs(tmp,index+1,set);
		dfs(cur,index+1,set);
		
	}
	
	
}
