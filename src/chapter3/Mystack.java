package chapter3;

public class Mystack<T> {
	private class Item{
		T value;
		Item next;
		public Item(T value){
			this.value=value;
		}
	}
	private Item top=null;
	
	public void push(T value){
		Item item=new Item(value);
		item.next=top;
		top=item;
	}
	
	public T peek(){
		return top.value;
	}
	
	public T pop(){
		T value=top.value;
		top=top.next;
		return value;
	}
	
	public boolean isEmpty(){
		return top==null;
	}
}
