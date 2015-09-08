package PG;

import java.util.Stack;

public class Basic_Calu {
	public static void main(String[] args){
		Basic_Calu s= new Basic_Calu();
		System.out.println(s.calculate("(1+(4+5+2)-3)+(6+8)"));
		
	}
	
	
	public int calculate(String s) {
        if(s==null||s.length()==0) return 0;
        Stack<Character> ops=new Stack<Character>();
        Stack<Integer> nums=new Stack<Integer>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c==' ') continue;
            if(c>='0' && c<='9'){
                int val=0;
                while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9'){
                    val = val*10+(int)(s.charAt(i)-'0');
                    i++;
                }
                nums.push(val);
                i--;
            }else if(c==')'){
                while(ops.peek()!='('){
                    nums.push( cal(nums,ops.pop()) );
                }
                ops.pop();    
            }else if(ops.isEmpty() || ops.peek()=='(' || c=='('){
                ops.push(c);
            
            }else{
                while( !ops.isEmpty() && rate(c) <= rate(ops.peek())){
                    
                    nums.push( cal(nums,ops.pop()) );
                }
                ops.push(c);
            }
            
        }
        while(!ops.isEmpty()){
            
            nums.push( cal(nums,ops.pop()) );
        }
        if(nums.isEmpty()) return 0;
        return nums.pop();
        
        
        
    }
    
    public int rate(char c){
        if(c=='+' || c=='-') return 1;
        if(c=='(') return 0;
        return 2;
    }
    
    public int cal(Stack<Integer> nums, char c){
    	int n2=nums.pop();
        int n1=nums.pop();
        if(c=='+') return n1+n2;
        if(c=='-') return n1-n2;
        if(c=='*') return n1*n2;
        return n1/n2;
    }
}
