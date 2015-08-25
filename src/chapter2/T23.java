package chapter2;

public class T23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n=new Node(1);
		n.appendtail(2); n.appendtail(7); n.appendtail(4); n.appendtail(5); n.appendtail(6);
	//	System.out.println(findNtolast(n,3));
	//	deletNode(n.next.next);
		Node m=new Node(1);
		m.appendtail(2); m.appendtail(3); m.appendtail(4); m.appendtail(5); m.appendtail(6);
		
		Node result=addListInOrder(n, m);
		while(result!=null){	
			System.out.print(result.data+"->");
			result=result.next;
		}
	}
	
	private static int findNtolast(Node list, int n){
		Node p1=list;
		Node p2=list;
		int i=n;
		while(i>0){
			p2=p2.next;
			i--;
		}
		while(p2.next!=null){
			p2=p2.next;
			p1=p1.next;
		}
		return (Integer) p1.data;
	}

	private static void deletNode(Node p){
		if(p==null || p.next==null) return;
		p.data=p.next.data;
		p.next=p.next.next;
	}
	
	private static Node<Integer> addList(Node<Integer> p, Node<Integer> q){
		Node sum=new Node(0);
		int carry=0;
		while(p!=null && q!=null){
			sum.appendtail((p.data+q.data+carry)%10);
			
			System.out.println(p.data+" "+q.data+" "+carry+" ");
			
			if(carry+p.data+q.data >=10) carry=1;
			
			else carry=0;
			
			p=p.next;
			q=q.next;
		}
		
		if(p!=null){
			if(carry==1){
				sum.appendtail(p.data+1);
				p=p.next;
			}
			while(p!=null){
				sum.appendtail(p.data);
				p=p.next;
			}
		}
		if(q!=null){
			if(carry==1){
				sum.appendtail(q.data+1);
				q=q.next;
			}
			while(q!=null){
				sum.appendtail(q.data);
				q=q.next;
			}
		}
		if(p==null&&q==null && carry==1){
			sum.appendtail(carry);
		}
		sum=sum.next;
		
		Node head=sum.next, current=sum;
		current.next=null;
		while(head!=null){
			Node tmp=head.next;
			head.next=current;
			current=head;
			head=tmp;
		}
		return current;
	}

	private static Node addListrecursive(Node<Integer> p, Node<Integer> q, int carry){
		if(p==null && q==null){
			if(carry==1){
				return new Node(1);
			}
			else return null;
		}
		int value = carry;
		if(p!=null) value+=p.data;
		if(q!=null) value+=q.data;
		Node after=addListrecursive(p==null ? null:p.next, q==null? null:q.next, value>=10 ? 1 :0 );
		Node result=new Node(value%10);
		result.next=after;
		return result;
		
	}

	private static Node addListInOrder(Node<Integer> p, Node<Integer> q){
		Node result=null;
		int carry=0;
		while(p!=null||q!=null){
			int value=carry;
			if(p!=null) {
				value+=p.data;
				p=p.next;
			}
			if(q!=null) {
				value+=q.data;
				q=q.next;
			}
			Node tmp=new Node(value % 10);
			tmp.next=result;
			result=tmp;
			carry= (value>=10) ? 1:0;
			
		}
		if(carry==1){
			Node tmp=new Node(1);
			tmp.next=result;
			result=tmp;
		}
		return result;
	}
}	
















