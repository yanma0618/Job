package PG;

public class N1_Strstr {
	public static void main(String[] args){
		System.out.println(strStr("111asdf12", "12"));
	}
	
	static int strStr(String haystack, String needle){
		if(needle==null || needle.length()==0) return 0;
		if(haystack.length()<needle.length()){
			return -1;
		}
		 
		for(int i=0;i<=haystack.length()-needle.length();i++){
			if( haystack.substring(i,i+needle.length()).equals(needle)){
				return i;
			}
		}
		return -1;
	}
}