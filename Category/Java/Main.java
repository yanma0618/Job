package Java;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) {
		
	}
	
	static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue=new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
			public int compare(ListNode o1, ListNode o2) {
				return o1.val-o2.val;
			}
        });
        
        for(int i=0;i<lists.length;i++){
        	queue.add(lists[i]);
        }
        ListNode pre = new ListNode(0);
        ListNode p = pre;
        while(!queue.isEmpty()){
        	ListNode tmp=queue.poll();
        	p.next=tmp;
        	p=p.next;
        	if(tmp.next!=null){
        		queue.add(tmp.next);
        	}
        }
        return pre.next;
	}

	
	static void rotate(int[] nums, int k) {
        if(nums==null || nums.length==0 ||k==0) return;
        k=k % nums.length;
        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int pos=(i+k) % (nums.length);
            res[pos]=nums[i];
        }
        nums=res;
        return;
        
    }
}
