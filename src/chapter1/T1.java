package chapter1;


class T1 {
	public static void main(String[] args){
		String str="abcdef";
		if(isUnique1(str)) System.out.print("true");
		else System.out.print("false");
	}
	private static boolean isUnique(String s){
		boolean[] judge=new boolean[256];
		
		for(int i=0;i<s.length(); i++){
			int val=s.charAt(i);
			if(judge[val]) return false;
			judge[val]=true;
		}
		return true;
	}
	private static boolean isUnique1(String s){
		int checker = 0;
		for(int i=0;i<s.length();i++){
			int val=s.charAt(i)-'a';
			if((checker & (1<< val)) > 0 ) {
				return false;
			}
			checker |= (1 << val);		
			//System.out.println(i+" "+checker);
		}
		return true;
	}
	
	
}
