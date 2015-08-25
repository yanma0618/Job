package MultiThreading;

public class BondedBuffer_TestThread {
	public static void main(String args[]) {

	      BoundedBuffer_Buffer buffer = new BoundedBuffer_Buffer();
	      BoundedBuffer_Producer producer = new BoundedBuffer_Producer(buffer,"p1");
	      BoundedBuffer_Producer producer2 = new BoundedBuffer_Producer(buffer,"p2");
	      BoundedBuffer_Consumer consumer = new BoundedBuffer_Consumer(buffer);
	      
	      producer.start();
	      producer2.start();
	      consumer.start();
	   }
}
