package MultiThreading;

public class Count_TestThread {
	public static void main(String args[]) {

	      Count_PrintDemo PD = new Count_PrintDemo();

	      Count_ThreadDemo T1 = new Count_ThreadDemo( "Thread - 1 ", PD );
	      Count_ThreadDemo T2 = new Count_ThreadDemo( "Thread - 2 ", PD );

	      T1.start();
	      T2.start();

	      // wait for threads to end
	      try {
	         T1.join();
	         T2.join();
	      } catch( Exception e) {
	         System.out.println("Interrupted");
	      }
	   }
}
