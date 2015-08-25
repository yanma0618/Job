package chapter2;

import java.util.HashMap;
import java.util.Hashtable;

public class T1 {
	public static void main(String[] args){
		Node n=new Node(1);
		n.appendtail(2); n.appendtail(2); n.appendtail(2); n.appendtail(2);
	//	rmdup(n);
		rm(n);
		while(n!=null){
			System.out.print(n.data);
			n=n.next;
		}
	}
	//remove duplicated item with an additional buffer
	static void rmdup(Node n){
		Hashtable h=new Hashtable();
		Node pre=null;
		while(n!=null){
			if(h.containsKey(n.data)) pre.next=n.next;
			else{
				h.put(n.data, true);
				pre=n;
			}
			n=n.next;
		}
	}
	
	static void rm(Node n){
		Node pre=n;
		Node current = pre.next;
		while(current!=null){
			Node runner=n;
			while(runner!=current){
				if(runner.data==current.data){
					pre.next=current.next;
					current=current.next;
					break;
				}
				runner=runner.next;
			}
			if(runner==current){
				pre=current;
				current=current.next;
			}
		}
	}
}
