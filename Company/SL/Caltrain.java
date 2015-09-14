package SL;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Caltrain {

}


class CentralServer{
	HashMap<String, User> users;
	HashMap<String, Charge> map= new HashMap<String, Charge>();
	public void charge(Charge c){
		//charge c.user_info with c.amout;
	};
	
	public void handle(Message m){
		Charge c=null;
		if(map.containsKey(m.uid)){
			c=map.get(m.uid);
			c.update(m);
			if(c.isComplete()){
				charge(c);
				map.remove(m.uid);
			}
		}else{
			c=new Charge();
			c.update(m);
		}
		
	}
	
	{
		Thread thread= new Thread(){
			public void run(){
				try {
					Thread.sleep(10*1000);
					for(Charge c:map.values()){
						if(c.isExpiared()){
							charge(c);
						}
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		thread.start();
	}
	
}

class Station{
	int station_id;
	CentralServer server=new CentralServer();
	Queue<Message> queue=new LinkedList<Message>();
	
	
	public void getOn(String uid){
		Message m = new Message(uid, station_id, System.currentTimeMillis(), true);
		process(m);
	}
	
	public void process(Message m){
		if(connect()){
			server.handle(m);
		}else{
			queue.add(m);
		}
	}
	
	public void getOff(String uid){
		Message m = new Message(uid, station_id, System.currentTimeMillis(), false);
		process(m);
	}
	

	
	public void recover(){
		while(!queue.isEmpty()){
			server.handle(queue.poll());
		}
	}
	
	public boolean connect(){
		//return network condition
		return false;
	}
}

class User {
	String uid;
	int balance;
	//....
}

class Message{
	String uid;
	int sid;
	long time;
	boolean isOn;
	
	public Message(String uid, int sid, long time, boolean isOn){
		this.uid=uid;
		this.sid=sid;
		this.time=time;
		this.isOn=isOn;
	}
}

class Charge{
	User user;
	int on_sid;
	long on_time;
	int off_sid;
	long off_time;
	
	public void update(Message m){
		
	}
	
	public boolean isComplete(){
		return false;
	}
	
	public boolean isExpiared(){
		return false;
	}
}

