package G;

import java.util.ArrayList;
import java.util.List;

public class DecodeEncode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> strs=new ArrayList<String>();
		strs.add("asfiji");
		strs.add("sdf");
		strs.add("a23r3#");
		strs.add("sfg");
		String ec=encode(strs);
		System.out.println("encode:"+ec);
		List<String> dc=decode(ec);
		for(String tmp:dc){
			System.out.print(tmp+" ");
		}
	}

	static List<String> decode(String input){
		List<String> res=new ArrayList<String>();
		int i=0;
		while(i<input.length()){
			int len=input.charAt(i)-'0';
			i+=2;
			res.add(input.substring(i,i+len));
			i=i+len;
		}
		return res;
	}
	
	static String encode(List<String> input){
		StringBuilder sb= new StringBuilder();
		for(String str:input){
			sb.append(str.length()+"#"+str);
		}
		return sb.toString();
	}
}
