package G;

import java.util.ArrayList;
import java.util.List;

public class Subset {
	static List<List<Integer>> res;
	public static void main(String[] args){
		int[] n={1,2,3};
		subset(n);
		for(List<Integer> list:res){
			System.out.print("{");
			for(int item:list){
				System.out.print(item+",");
			}
			System.out.println("}");
		}
		ksubset(n,2);
		for(List<Integer> list:res){
			System.out.print("k {");
			for(int item:list){
				System.out.print(item+",");
			}
			System.out.println("}");
		}
	}
	
	static List<List<Integer>> subset(int[] list){
		res = new ArrayList<List<Integer>>();
		helper(new ArrayList<Integer>(), 0, list);
		return res;
	}
	
	static void helper(List<Integer> cur, int index, int[] list){
		if(index==list.length){
			res.add(new ArrayList<Integer>(cur));
			return;
		}
			cur.add(list[index]);
			helper(cur, index+1, list);
			cur.remove(cur.size()-1);
			helper(cur,index+1,list);
	}
	
	static List<List<Integer>> ksubset(int[] list, int k ){
		res = new ArrayList<List<Integer>>();
		helperk(new ArrayList<Integer>(), 0, list,k);
		return res;
	}
	
	static void helperk(List<Integer> cur, int index, int[] list, int k){
		if(k==0){
			res.add(new ArrayList<Integer>(cur));
			return;
		}
		if(list.length-index<k || index==list.length) return;
		cur.add(list[index]);
		helperk(cur, index+1, list,k-1);
		cur.remove(cur.size()-1);
		helperk(cur,index+1,list,k);
	}
}
