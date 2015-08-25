package chapter2;


public class Node<T> {
		T data;
		Node next = null;
		public Node(T  d){
			data=d;
		}
		
		void appendtail(T d){
			Node n=this;
			Node end=new Node(d);
			while(n.next!=null) n=n.next; 
			n.next=end;
		}
}
