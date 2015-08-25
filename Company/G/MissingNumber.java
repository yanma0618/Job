package G;
import java.util.ArrayList;
import java.util.List;


public class MissingNumber {
	public static void main(String[] args){
		int[] number={0, 1, 2,50 , 52, 75};
		List<String> res = fun(number);
		for(String s:res){
			System.out.println(s+",");
		}
	}
	static List<String> fun(int[] number){
		int mis=0;
		int i=0;
		List<String> res=new ArrayList<String>();
		
		while(i<number.length){
			if(number[i]==mis){
				i++;
				mis++;
			}else{
				int tmp=mis;
				while(mis!=number[i]){
					mis++;
				}
				if(tmp==mis-1) res.add(""+tmp);
				else res.add(String.valueOf(tmp)+"-"+String.valueOf(mis-1));
			}
		}
		if(mis<99) res.add(mis+"-99");
		else if(mis==99) res.add("99");
		return res;
	}
}
