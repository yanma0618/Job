package chapter1;

public class T3 {
	public static void main(String[] args){
		char[] ch="ababab".toCharArray();
		System.out.println(ch);
		System.out.println(removedup(ch));
	}
	
	private static String cutdup(char[] ch){
		String str=ch.toString();
		int len=ch.length;
		if(len<2) return str;
		int pos=1;
		for(int i=1;i<len;i++){
			int j;
			for(j=0;j<pos;j++){
				if(ch[j]==ch[i])
					break;
			}
			if(j==pos){
				ch[pos++]=ch[i];
			}
		}
		str=new String(ch);
		str=str.substring(0, pos);
		return str;
		
	}

	private static String removedup(char[] ch){
		String str=new String(ch);
		if(ch.length<2) return str;
		
		boolean[] hit=new boolean[256];
		for(int i=0;i<hit.length;i++) hit[i]=false;
			
		hit[ch[0]]=true;
		int pos=1;
		for(int i=1; i<ch.length;i++){
			if(!hit[ch[i]]){
				ch[pos++]=ch[i];	
				hit[ch[i]]=true;
			}
		}
		if(pos<ch.length) ch[pos]=0;
		str=new String(ch);
		str=str.substring(0,pos);
		return str;
	}
}
