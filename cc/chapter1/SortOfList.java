package chapter1;

public class SortOfList {
	public static void main(String[] args){
		point p=new point(2, null);
		
		point q=new point(3, null);
	}
	
	
	static class point{
		int data;
		point next;
		
		point(int data, point next){
			this.data=data;
			this.next=next;
		} 
	}
			
}
