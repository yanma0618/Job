package MultiThreading;

public class BoundedBuffer_Producer extends Thread{
	private BoundedBuffer_Buffer buffer;
	private String name;
	public BoundedBuffer_Producer(BoundedBuffer_Buffer buffer, String name){
		this.buffer=buffer;
		this.name=name;
	}
	
	public void run(){
		for(int i=0;i<16;i++){
			System.out.println(name+" add");
			buffer.add(i);
		}
	}
}
