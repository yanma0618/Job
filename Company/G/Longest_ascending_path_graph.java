package G;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Longest_ascending_path_graph {

	int res;
	HashMap<GraphNode, Integer> map;

	public int getLong(List<GraphNode> nodes) {
		map = new HashMap<GraphNode, Integer>();
		res = 0;
		for (GraphNode v : nodes) {
			dfs(v);
		}
		return res;
	}

	public int dfs(GraphNode v) {
		if (map.containsKey(v))
			return map.get(v);
		int ret = 1;

		for (GraphNode node : v.neighbors) {
			if (node.val > v.val) {
				ret = Math.max(ret, dfs(node)+1);
			}
		}

		res = Math.max(ret, res);
		map.put(v, ret);
		return ret;
	}
	
	
	public static void main(String[] args){
		
		GraphNode n1=new GraphNode(1);
		GraphNode n2=new GraphNode(2);
		GraphNode n3=new GraphNode(3);
		GraphNode n4=new GraphNode(4);
		GraphNode n5=new GraphNode(5);
		
		n1.neighbors.add(n2);
		n1.neighbors.add(n5);
		n1.neighbors.add(n4);
		
		n2.neighbors.add(n3);
		
		n3.neighbors.add(n4);
		
		n4.neighbors.add(n5);
		
		List<GraphNode> list=new ArrayList<GraphNode>();
		list.add(n1);list.add(n2);list.add(n3);list.add(n4);list.add(n5);
		
		Longest_ascending_path_graph s= new Longest_ascending_path_graph();
		System.out.println(s.getLong(list));
		
	}
}
