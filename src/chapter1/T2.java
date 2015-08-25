package chapter1;

public class T2 {
	public static void main(String[] args){
		String str="abcdef"+'\0';
		System.out.println(str.charAt(6));
		System.out.println(reverse(str).charAt(0));
		System.out.println(reverse(str));	
	}
	private static String reverse(String s){
		char[] ch=s.toCharArray();
		int l=s.length()-1;
		for(int i=0;i<=l/2;i++){
			char c;
			c=ch[i];
			ch[i]=ch[l-i];
			ch[l-i]=c;
		}
		return new String(ch);
	}
}
