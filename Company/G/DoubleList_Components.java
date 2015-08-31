package G;



public class DoubleList_Components {
	public static void main(String[] args){
		DoubleLinkNode[] list=build();
		System.out.println(count(list));
	}
	
	static int count(DoubleLinkNode[] list){
		if(list==null|| list.length==0) return 0;
		DoubleLinkNode head=null;
		DoubleLinkNode tail=null;
		int num=0;
		int i=0;
		while(i<list.length){
			DoubleLinkNode tmp = list[i];
			if(head!=null && head.pre==tmp){
				tmp.next=head;
				head.pre=tmp;
				head=tmp;
			}else if(tail!=null&&tail.next==tmp){
				tail.next=tmp;
				tmp.pre=tail;
				tail=tmp;
			}else{
				head=tmp;
				tail=tmp;
				num++;
			}
			i++;
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
		DoubleLinkNode[] list=new DoubleLinkNode[4];
		list[0]=a; list[1]=d; list[2]=e; list[3]=b;
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


