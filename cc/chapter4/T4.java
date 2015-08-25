package chapter4;

import java.util.*;

public class T4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree r=new Tree();
		r.initial();
		r.bfs();
		System.out.println();
		ArrayList<ArrayList<Tree>> result=bfslist(r);
		for(ArrayList<Tree> list:result){
			for(Tree node:list){
				System.out.print(node.data+" ");
			}
			System.out.println();
		}
	}
	private static ArrayList<ArrayList<Tree>> bfslist(Tree r){
		ArrayList<Tree> list=new ArrayList<Tree>();
		ArrayList<ArrayList<Tree>> result=new ArrayList<ArrayList<Tree>>();
		list.add(r);
		result.add(list);
		int level=0;
		while(true){
			list=new ArrayList<Tree>();
			for(int i=0; i<result.get(level).size(); i++){
				Tree tmp=result.get(level).get(i);
				if(tmp.lchild!=null){
					list.add(tmp.lchild);
				}
				if(tmp.rchild!=null) list.add(tmp.rchild);
			}
			if(list.size()==0) break;
			else result.add(level+1,list);
			level++;	
		}
		return result;
		
		
	}

}
