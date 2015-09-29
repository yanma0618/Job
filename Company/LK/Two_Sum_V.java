package LK;

import java.util.HashMap;

public class Two_Sum_V {

	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	public boolean check(int target){
		for(int currentKey:map.keySet()){
			if (target - currentKey == currentKey && map.get(currentKey) > 1)
			    return true;

			if (map.containsKey(target - currentKey)) {
			    return true;
			}

		}		
		return false;
	}
}
