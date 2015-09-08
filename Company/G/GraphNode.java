package G;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
	int val;
	List<GraphNode> neighbors;
	public GraphNode(int val){
		this.val=val;
		neighbors=new ArrayList<GraphNode>();
		
	}
}
