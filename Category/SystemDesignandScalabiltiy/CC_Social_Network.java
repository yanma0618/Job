package SystemDesignandScalabiltiy;

import java.util.ArrayList;
import java.util.UUID;

public class CC_Social_Network {
	
}

class Server{
	ArrayList<Machine> machines =new ArrayList<Machine>();
}

class Machine{
	ArrayList<Person> persons = new ArrayList<Person>();
	int muid;
}

class Person{
	int puid;
	int muid;
	ArrayList<Integer> friends;
	Server server = new Server();
	public Machine lookUpMachineById(int muid){
		for(Machine m:server.machines){
			if(m.muid==(muid)){
				return m;
			}
		}
		return null;
	}
	
	public int hash(int id){
		return 0;
	}
	
	public int getMachineId(int pid){
		return hash(pid);
	}
	
	public Person lookUpPersonById(int pid, int muid){
		Machine m = lookUpMachineById(muid);
		for(Person p:m.persons){
			if(p.puid==(pid)){
				return p;
			}
		}
		return null;
	}
}
