package G;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class String_sort_alphabet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<String>();
		list.add("zxcdz");
		list.add("zxcas");
		list.add("acazas");
		list.add("caas");
		String_sort_alphabet s= new String_sort_alphabet();
		s.print(list);
		s.sort(list, "zxcasd");
		s.print(list);
		
	}
	
	public void print(List<String> list){
		for(String s:list){
			System.out.print(s+" ");
		}
		System.out.println();
	}
	
	public void sort(List<String> list, String alp){
		final HashMap<Character, Integer> map=new HashMap<Character, Integer>();
		for(int i=0;i<alp.length();i++){
			map.put(alp.charAt(i), i);
		}
		
		Collections.sort(list,new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				int  i=0;
				int j=0;
				while(i<o1.length() && j<o2.length()){
					if(map.get(o1.charAt(i))<map.get(o2.charAt(j))){
						return -1;
					}else if( map.get(o1.charAt(i))>map.get(o2.charAt(j)) ){
						return 1;
					}
					i++;
					j++;
				}
				if(i<o1.length()){
					return 1;
				}
				if(j<o2.length()){
					return -1;
				}
				return 0;
				
			}
			
		});
		
		
	}

}
