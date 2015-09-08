package G;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class Sort_By_number_before {
	
	public static void main(String[] args){
		Sort_By_number_before s=  new Sort_By_number_before();
		List<People> list = new ArrayList<People>();
		list.add(new People(1,1));
		list.add(new People(5,0));
		list.add(new People(2,2));
		list.add(new People(3,1));
		list.add(new People(4,0));
		s.print(list);
		People[] res=s.sort(list);
		s.print(res);
	}
	
	public void print(List<People> list){
		for(People p:list){
			System.out.println(p.height+" "+p.number);
		}
		System.out.println();
	}
	
	public void print(People[] list){
		for(People p:list){
			System.out.println(p.height+" "+p.number);
		}
		System.out.println();
	}
	
	public int[] shuffle(int n){
		int[] ret=new int[n];
		for(int i=1;i<=n;i++){
			ret[i-1]=i;
		}
		int index=n;
		Random r= new Random();
		while(n>0){
			int tmp = r.nextInt(n);
			int t=ret[tmp];
			ret[tmp]=ret[n-1];
			ret[n-1]=t;
			n--;
		}
		return ret;
	}
	
	public People[] sort(List<People> list){
		PriorityQueue<People> queue=new PriorityQueue<People>(list.size(), new Comparator<People>(){
			public int compare(People p1, People p2){
				return p1.height-p2.height;
			}
		});
		People[] ret= new People[list.size()];
		for(People p:list){
			queue.add(p);
		}
		while(!queue.isEmpty()){
			People top=queue.poll();
			ret [ getEmptyIndex(top.number+1, ret)]=top;
		}
		return ret;
		
	}
	
	//return nth empty slot
	public int getEmptyIndex(int k, People[] list){
		int n=0;
		for(int i=0;i<list.length;i++){
			if(list[i]==null){
				n++;
				if(n==k){
					return i;
				}
			}
		}
		return -1;
	}
	
	
}

class People{
	int height;
	int number;
	
	public People(int height, int number){
		this.height=height;
		this.number=number;
	}
}
