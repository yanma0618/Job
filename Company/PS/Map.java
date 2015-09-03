package PS;

import java.util.HashMap;

public class Map {

	DoubleLinkedNode head;
	DoubleLinkedNode tail;
	HashMap<Integer, DoubleLinkedNode> map;
	
	public Map(){
		clear();
	}
	
	public void add(int key,int val){
		DoubleLinkedNode node=new DoubleLinkedNode(key, val);
		node.next=head.next;
		head.next.pre=node;
		head.next=node;
		node.pre=head;
		map.put(key, node);
	}
	
	public void delet(int key){
		DoubleLinkedNode node=map.get(key);
		node.pre.next=node.next;
		node.next.pre=node.pre;
		node=null;
		map.remove(key);
	}
	
	public int lookup(int key){
		if(map.containsKey(key)){
			return map.get(key).val;
		}else{
			return -1;
		}
	}
	
	public boolean isEmpty(){
		return head.next==tail;
	}
	
	public void clear(){
		head=new DoubleLinkedNode(0, 0);
		tail=new DoubleLinkedNode(0, 0);
		head.next=tail;
		tail.pre=head;
		map=new HashMap<Integer,DoubleLinkedNode>();
	}
	
	public void iterate(){
		DoubleLinkedNode p = head.next;
		while(p!=null){
			System.out.println(p.key+" "+p.val);
			p=p.next;
		}
	}
}

class DoubleLinkedNode{
	int key;
	int val;
	DoubleLinkedNode next;
	DoubleLinkedNode pre;
	public DoubleLinkedNode(int key, int val){
		this.key=key;
		this.val=val;
		next=null;
		pre=null;
	}
}