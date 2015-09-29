package LK;

import java.util.List;

public class NestedInteger_DepthSum {

	public static void main(String[] args) {
		//{{1,1},2,{1,1}}  = 1*2 + 1*2 + 2*1 + 1*2 + 1*2=10
	}

	public int depthSum (List<NestedInteger> input){
		return getSum(input, 1);
	}
	
	public int getSum(List<NestedInteger> input, int level){
		int sum=0;
		if(input==null || input.size()==0) return 0;
		for(NestedInteger item: input){
			if(item.isInteger()){
				sum += item.getInteger()*level;
			}else{
				sum += getSum(item.getList(),level+1);
			}
		}
		return sum;
	}
}
