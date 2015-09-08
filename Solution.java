public class Solution {
    public int calculate(String s) {
        if(s==null||s.length()==0) return 0;
        Stack<Character> ops=new Stack<Character>();
        Stack<Integer> nums=new Stack<Integer>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            
            if(c>='0' && c<='9'){
                int val=0;
                while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9'){
                    val = val*10+(int)(s.charAt(i)-'0');
                    i++;
                }
                nums.push(val);
                i--;
            }
            else if(ops.isEmpty() || ops.peek()=='(' ||c=='('){
                ops.push(c);
            }else if(c==')'){
                while(ops.peek()!='('){
                    int n2=nums.pop();
                    int n1=nums.pop();
                    nums.push( cal(n1,n2,ops.pop() );
                }
                ops.pop();
            }else{
                while( !ops.isEmpty() && rate(c) <= rate(ops.peek())){
                    int n2=nums.pop();
                    int n1=nums.pop();
                    nums.push( cal(n1,n2,ops.pop() );
                }
                ops.push(c);
            }
            
        }
        
        
        
    }
    
    public int rate(char c){
        if(c=='+' || c=='-') return 1;
        return 2;
    }
    
    public int cal(int n1, int n2, char c){
        if(c=='+') return n1+n2;
        if(c=='-') return n1-n2;
        if(c=='*') return n1*n2;
        return n1/n2;
    }
}