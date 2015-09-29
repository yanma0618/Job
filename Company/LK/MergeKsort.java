package LK;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKsort {
	
	
	public Iterable<Integer> mergeKSortedIterators(Iterator<Integer>[] iters){
		PriorityQueue<Iterator<Integer>> minHeap = new PriorityQueue<Iterator<Integer>>(iters.length, new Comparator<Iterator<Integer>>(){

			@Override
			public int compare(Iterator<Integer> o1, Iterator<Integer> o2) {
				
				return o1.next()-o2.next();
			}
			
		});
        List<Integer> result = new ArrayList<Integer>();
        for(Iterator<Integer> iter : iters){
            if(iter.hasNext()){
                minHeap.add(iter);
            } 
        }
        while(!minHeap.isEmpty()){
            Iterator<Integer> curr = minHeap.poll();
            result.add(curr.next());
            if(curr.hasNext()){
                minHeap.add(curr);
            }
        }
        return result;
    }
}
