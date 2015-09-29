package G;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/*
 * 烙印小哥。 rearrange array，使得相邻两个字符是不一样的。
 */
public class Heap_String_Reaarange_Array {
	
	public String Solution(String s){
		PriorityQueue<Word> queue=new PriorityQueue<Word>(s.length(),new Comparator<Word>(){
			@Override
			public int compare(Word w1, Word w2){
				return w2.freq-w1.freq;
			}
		});
		
		HashMap<Character, Word> map=new HashMap<Character, Word>();
		for(int i=0;i<s.length();i++){
			char c= s.charAt(i);
			if(map.containsKey(c)){
				map.get(c).freq++;
			}else{
				Word w=new Word(c,1);
				map.put(c, w);
			}
		}
		for(Word w:map.values()){
			queue.add(w);
		}
		StringBuilder sb= new StringBuilder();
		while(queue.size()>1){
			Word w1=queue.poll();
			Word w2=queue.poll();
			if(sb.length()>0 && sb.charAt(sb.length()-1)==w1.c){
				sb.append(w2.c);
				sb.append(w1.c);
			}else{
				sb.append(w1.c);
				sb.append(w2.c);
			}
			w1.freq--;
			w2.freq--;
			if(w1.freq>0) queue.add(w1);
			if(w2.freq>0) queue.add(w2);
		}
		
		if(queue.size()>0) {
			Word w=queue.poll();
			if(w.freq>1) return "";
			sb.append(w.c);
			
		}
		
		
		return sb.toString();
		
	}
	
	public static void main(String[] args){
		Heap_String_Reaarange_Array s=new Heap_String_Reaarange_Array();
		System.out.print(s.Solution("ssssaaa"));
	}
	
}

class Word{
	char c;
	int freq;
	public Word(char c, int f){
		this.c=c;
		this.freq=f;
	}
}