import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
	
	public static void main(String[] args){
		Solution s= new Solution();
		String[] words={"aa","aa","aa"};
		System.out.print(s.findSubstring("aaaaaaaa", words));
	}
	
    public List<Integer> findSubstring(String s, String[] words) {
    	List<Integer> res = new ArrayList<Integer>();
        HashMap<String, Integer> map = new HashMap<String,Integer>();
        for(String w: words){
        	if(map.containsKey(w)){
        		map.put(w,map.get(w)+1);
        	}else{
        		map.put(w,1);
        	}
        }

        int start=0;
        int len=words[0].length();
        int i=0;
        HashMap<String,Integer> copy=new HashMap<String,Integer>(map);
        int totallen=len*words.length;
        while(start+totallen<=s.length() && i+len<=s.length()){
        	String w=s.substring(i,i+len);
        	if(copy.containsKey(w)){
        		copy.put(w,copy.get(w)-1);
        		if(copy.get(w)==0){
        			copy.remove(w);	
        		}
        		i+=len;
        		if(i-start==totallen){
        			res.add(start);
        			start++;
            		i=start;
            		copy=new HashMap<String,Integer>(map);
        		}
        	}else{
        		start++;
        		i=start;
        		copy=new HashMap<String,Integer>(map);
        	}

        }
        return res;
    }
}