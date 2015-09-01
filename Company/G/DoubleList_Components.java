package G;

import java.util.HashSet;



public class DoubleList_Components {
	public static void main(String[] args){
		DoubleLinkNode[] list=build();
		System.out.println(count(list));
	}
	
	static int count(DoubleLinkNode[] list){
		int num=0;
		HashSet<DoubleLinkNode> set = new HashSet<DoubleLinkNode>();
		for(DoubleLinkNode node:list){
			set.add(node);
		}
		for(DoubleLinkNode node:list){
			if(!set.contains(node)) continue;
			DoubleLinkNode tmp=node.pre;
			while(tmp!=null && set.contains(tmp)){
				set.remove(tmp);
				tmp=tmp.pre;
			}
			tmp=node.next;
			while(tmp!=null && set.contains(tmp)){
				set.remove(tmp);
				tmp=tmp.next;
			}
			num++;
		}
		return num;
	}
	
	static DoubleLinkNode[] build(){
		DoubleLinkNode a= new DoubleLinkNode('a');
		DoubleLinkNode b= new DoubleLinkNode('b');
		DoubleLinkNode c= new DoubleLinkNode('c');
		DoubleLinkNode d= new DoubleLinkNode('d');
		DoubleLinkNode e= new DoubleLinkNode('e');
		a.next=b;b.pre=a;
		b.next=c;c.pre=b;
		c.next=d;d.pre=c;
		d.next=e;e.pre=d;
		DoubleLinkNode[] list=new DoubleLinkNode[3];
		list[0]=a; list[1]=c; list[2]=e; 
		return list;
	}
}

class DoubleLinkNode{
	char c;
	DoubleLinkNode next;
	DoubleLinkNode pre;
	public DoubleLinkNode(char c){
		this.c=c;
		pre=null;
		next=null;
	}
	
}


