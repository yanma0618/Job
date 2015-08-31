package G;

import java.util.ArrayList;
import java.util.List;
import HARD.maxHeapComparator;

public class Longest_ascending_tree_path {
	static int max;
	static List<Integer> res;
	public static void main(String[] args){
		max=0;
		res = new ArrayList<Integer>();
		MTreeNode root=new MTreeNode(1);
		MTreeNode c1=new MTreeNode(2);
		c1.children.add(new MTreeNode(5));
		c1.children.get(0).children.add(new MTreeNode(3));
		root.children.add(c1);
		MTreeNode c2=new MTreeNode(4);
		c2.children.add(new MTreeNode(3));
		root.children.add(c2);
		
		MTreeNode c3=new MTreeNode(6);
		c3.children.add(new MTreeNode(7));
		c3.children.get(0).children.add(new MTreeNode(8));
		root.children.add(c3);
		path(root,new ArrayList<Integer>());
		for(int n:res){
			System.out.print(n+" ");
		}
	}
	
	static void path(MTreeNode root, List<Integer> cur){
		cur.add(root.val);
		if(max<cur.size()){
			max=cur.size();
			res=new ArrayList<Integer>(cur);
		}
		if(root.children.size()>0){
			for(MTreeNode node:root.children){
				if(node!=null && root.val<node.val){
					path(node,cur);
					cur.remove(cur.size()-1);
				}
			}
		}
	}
}
