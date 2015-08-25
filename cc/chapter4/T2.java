package chapter4;
import java.util.*;

import chapter4.Gnode.State;
public class T2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Gnode> g=new ArrayList<Gnode>();

		Gnode one=new Gnode(1); Gnode two=new Gnode(2); Gnode three=new Gnode(3);
		Gnode four=new Gnode(4); Gnode five=new Gnode(5);
		one.list.add(two); one.list.add(three);
		two.list.add(five);
		three.list.add(two); three.list.add(four);
		
		g.add(one); g.add(two); g.add(three);


		BFS(g);
		
	}
	private static void BFS(ArrayList<Gnode> g){
		Queue<Gnode> q=new LinkedList<Gnode>();
		Gnode u=g.get(0);
		
		q.add(u);
		while(!q.isEmpty()){
			u=q.poll();
			if(u.list.size()>0){
				for(Gnode v:u.list){
					if(v.state==State.unvisit){
						q.add(v);
						v.state=State.visiting;
					}
				}
			}
			System.out.print(u.data+" ");
			u.state=State.visited;
		}
	}
}
