package G;

public class Permutation {
	public static void main(String[] args){
		dfs("abc",0);
	}
	
	static void dfs(String s, int index){
		if(index==s.length()){
			System.out.println(s);
			return;
		}
		for(int i=index;i<s.length();i++){
			s=swap(s,index,i);
			dfs(s,index+1);
			s=swap(s,index,i);
		}
	}
	
	static String swap(String s, int i, int j){
		char[] ch=s.toCharArray();
		char tmp = ch[i];
		ch[i]=ch[j];
		ch[j]=tmp;
		return new String(ch);
	}
}
