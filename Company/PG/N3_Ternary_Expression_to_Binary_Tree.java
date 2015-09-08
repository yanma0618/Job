package PG;

import java.util.Stack;

public class N3_Ternary_Expression_to_Binary_Tree {

	public static void main(String[] args) {
		N3_Ternary_Expression_to_Binary_Tree s= new N3_Ternary_Expression_to_Binary_Tree();
		 TreeNode res=s.convert_a("a?b:c?d?e:f:g");
		 res.print(res);
		 res.inorder(res);
		
	}
	
	
	public  static TreeNode convert_a(String ternary) {
        if (ternary==null || ternary.isEmpty()) return null;
        char[] chs = ternary.toCharArray();
        //每次只把root压栈
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur=new TreeNode(chs[0]);
        TreeNode root= cur; 
        for (int i=1; i<chs.length; i+=2) {
                if (chs[i]=='?') {
                        stack.push(cur);
                        TreeNode node = new TreeNode(chs[i+1]);
                        cur.left = node;
                        cur = node;
                }
                else if (chs[i]==':') {
                        cur = stack.pop();
                        TreeNode node = new TreeNode(chs[i+1]);
                        cur.right = node;
                        cur = node;
                        
                }
        }
        return root;
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
