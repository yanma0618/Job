package PG;

import java.util.SortedSet;
import java.util.TreeSet;

public class N13_Contains_Duplicate_III {
	
	//O(nlog(k)).
	//sortedSet subset(E fromElement, E toElement): fromElement, inclusive, to toElement, exclusive.
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k<0 || t<0 ||nums==null || nums.length==0) return false;
        SortedSet<Long> set = new TreeSet<Long>();

        for(int i=0;i<nums.length;i++){
            long left = (long)nums[i]-t;
            long right= (long)nums[i]+t+1;
            if(!set.subSet(left,right).isEmpty()){
                return true;
            }
            set.add((long)nums[i]);
            if(i>=k){
                set.remove((long)nums[i-k] );
            }
        }
        return false;
    }
}
