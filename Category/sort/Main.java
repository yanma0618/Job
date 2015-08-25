package sort;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args){
		SortAnagram sa=new SortAnagram();
		ArrayList<String> ori=new ArrayList<String>(Arrays.asList("aabbcc", "dds","ccbbaa","sdd"));
		ArrayList<String> res=sa.sortana(ori);
		for(String item:res){
			System.out.print(item+" ");
		}
	}
}
