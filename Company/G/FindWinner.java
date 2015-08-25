package G;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindWinner {
	public static void main(String[] args){
		ArrayList<LogEntry> logs=init();
		System.out.println(findWin(2,logs));
		List<String> res = findKwin(4,logs,2);
		for(String s:res){
			System.out.print(s+" ,");
		}
	}
	
	static ArrayList<LogEntry> init(){
		ArrayList<LogEntry> logs=new ArrayList<LogEntry>();
		logs.add(new LogEntry("C1", 1));
		logs.add(new LogEntry("C2", 1));
		logs.add(new LogEntry("C1", 2));
		logs.add(new LogEntry("C3", 2));
		logs.add(new LogEntry("C3", 2));
		logs.add(new LogEntry("C3", 3));
		logs.add(new LogEntry("C2", 3));
		logs.add(new LogEntry("C2", 4));
		logs.add(new LogEntry("C3", 4));
		return logs;
	}
	
	static List<String> findKwin(int time, ArrayList<LogEntry> logs, int k){
		HashMap<String , Integer> map = new HashMap<String, Integer>();
		buildHash(time,logs,map);
		Vote[] votes=new Vote[map.size()];
		int i=0;
		for(String c:map.keySet()){
			votes[i++]=new Vote(c,map.get(c));
		}
		selectk(votes,votes.length-k,0,votes.length-1);
		List<String> res = new ArrayList<String>();
		for( i=votes.length-1;i>=votes.length-k;i--){
			res.add(votes[i].can);
		}
		return res;
		
	}
	
	static void selectk(Vote[] votes, int k, int left, int right){
		int m=partition(votes, left,right);
		if(m==k) return;
		if(m<k) selectk(votes,k,m+1,right);
		else selectk(votes,k,left,m-1);
	}
	
	static int partition(Vote[] votes, int left, int right){
		Vote pivot=votes[right];
		int index=left;
		for(int i=left;i<right;i++){
			if(votes[i].compareTo(pivot)>=0) continue;
			swap(votes,i,index);
			index++;
		}
		swap(votes,index,right);
		return index;
		
	}
	
	static void swap(Vote[] votes, int i, int index){
		Vote tmp=votes[i];
		votes[i]=votes[index];
		votes[index]=tmp;
	}
	
	static void buildHash(int time, ArrayList<LogEntry> logs, HashMap<String , Integer> map){
		for(LogEntry le:logs){
			if(le.time>time) continue;
			if(map.containsKey(le.candidate)){
				map.put(le.candidate,map.get(le.candidate)+1);
			}else{
				map.put(le.candidate,1);
			}
		}
	}
	
	static String findWin(int time, ArrayList<LogEntry> logs){
		HashMap<String , Integer> map = new HashMap<String, Integer>();
		buildHash(time,logs,map);
		int max=0;
		String name="";
		for(String c:map.keySet()){
			if(map.get(c)>max){
				max=map.get(c);
				name=c;
			}
		}
		return name;
	}
}

class Vote{
	String can;
	int vote;
	public Vote(String c, int vote){
		this.can=c;
		this.vote=vote;
	}
	
	public int compareTo( Vote v2){
		return this.vote-v2.vote;
	}
}

class LogEntry{
	String candidate;
	int time;
	
	public LogEntry(String c, int time){
		this.candidate=c;
		this.time=time;
	}
}