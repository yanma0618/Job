package chapter1;

import java.lang.reflect.Array;
import java.util.Arrays;

public class T4 {
	public static void main(String[] args){
		char[] str1= "abcdb".toCharArray();
		char[] str2= "cdabb".toCharArray();
		if(anagrams(str1, str2)) System.out.println("true");
		else System.out.println("false");
	}
	
	private static boolean anagrams(char[] str1, char[] str2){
		int[] hit=new int[256];
		for (int i=0; i<hit.length; i++) hit[i]=0;
		for(char ch:str1){
			hit[ch]++;
		}
		for(char ch:str2){
			hit[ch]--;
			if(hit[ch]<0) return false;
		}
	/*	for(int i=0; i<hit.length; i++) 
			if(hit[i]!=0) return false;*/
		
		return true;
	}
	
	private static boolean sortanagrams(char[] str1, char[] str2){
		String s=new String(str1);
		String q=new String(str2);
		return sort(s).equals( sort(q) );
	}
	private static boolean sortanagrams1(char[] str1, char[] str2){
		
		Arrays.sort(str1);
		Arrays.sort(str2);
		System.out.print(new String(str1)+" "+new String(str2));
		return new String(str1).equals(new String(str2));
	}

	private static String sort(String s) {
		// TODO Auto-generated method stub
		char[] ch=s.toCharArray();
		Arrays.sort(ch);
		return new String(ch);
	}
}
