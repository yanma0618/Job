package MultiThreading;

public class Count_ThreadDemo extends Thread{
	private Thread t;
	private String threadName;
	Count_PrintDemo PD;
	
	public Count_ThreadDemo(String name, Count_PrintDemo pd) {
		this.threadName=name;
		this.PD=pd;
	}
	
	public void run(){
		synchronized (PD) {
			PD.printCount();
		}
		
		System.out.println("Thread "+threadName+" exiting.");
	}
	
	public void start(){
		System.out.println("Starting "+ threadName);
		if(t==null){
			t=new Thread(this,threadName);
			t.start();
		}
	}
}
