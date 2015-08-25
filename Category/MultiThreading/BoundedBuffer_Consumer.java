package MultiThreading;

public class BoundedBuffer_Consumer extends Thread{
	private BoundedBuffer_Buffer buffer;

	public BoundedBuffer_Consumer(BoundedBuffer_Buffer buffer){
		this.buffer=buffer;
	}
	
	public void run(){
		for(int i=0;i<24;i++){
			buffer.remove();
		}
	}
}
