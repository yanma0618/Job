package PG;

public class N3_Ternary_Expression_to_Binary_Tree {

	public static void main(String[] args) {
		N3_Ternary_Expression_to_Binary_Tree s= new N3_Ternary_Expression_to_Binary_Tree();
		 TreeNode res=s.convert("a?b:c?d?e:f:g");
		 res.print(res);
		 res.inorder(res);
		
	}
	
	public TreeNode convert(String input){
		return help(input,0).node;
	}

	public Wapper help(String input, int index){
		TreeNode ret= new TreeNode(input.charAt(index));
		if(index==input.length()-1){
			return new Wapper(ret,index+1);
		}
		index++;
		char c = input.charAt(index);
		if(c=='?'){
			index++;
			Wapper left=help(input,index);
			ret.left=left.node;
			Wapper right=help(input, left.index);
			ret.right=right.node;
			return new Wapper(ret,right.index);
		}
		return new Wapper(ret,index+1);
	}
}

class Wapper{
	TreeNode node;
	int index;
	public Wapper(TreeNode node, int i){
		this.node=node;
		this.index=i;
	}
}
