package G;

import java.util.ArrayList;
import java.util.List;

public class MTreeNode {
	int val;
	List<MTreeNode> children;
	public MTreeNode(int val){
		this.val=val;
		children=new ArrayList<MTreeNode>();
	}
}
