package Graph;
import java.util.ArrayList;
import java.util.Arrays;

class Edge{
	int v;
	int w;
	public Edge(int v, int w){
		this.v=v;
		this.w=w;
	}
}

public class Graph {
	ArrayList<ArrayList<Edge>> graph=new ArrayList<ArrayList<Edge>>();
	
	public void build(){
		graph.add(0,new ArrayList<Edge>(Arrays.asList(new Edge(0,0)))   );
		ArrayList<Edge> neibors=new ArrayList<Edge>();
		neibors.add(new Edge(2,2));
		neibors.add(new Edge(4,1));
		graph.add(1,neibors);
		neibors=new ArrayList<Edge>();
		neibors.add(new Edge(5,10));
		neibors.add(new Edge(4,3));
		graph.add(2,neibors);
		neibors=new ArrayList<Edge>();
		neibors.add(new Edge(1,4));
		neibors.add(new Edge(6,5));
		graph.add(3,neibors);
		neibors=new ArrayList<Edge>();
		neibors.add(new Edge(3,2));
		neibors.add(new Edge(6,8));
		neibors.add(new Edge(7,4));
		neibors.add(new Edge(5,2));
		graph.add(4,neibors);
		neibors=new ArrayList<Edge>();
		neibors.add(new Edge(5,2));
		neibors.add(new Edge(3,2));
		graph.add(5,neibors);
		neibors=new ArrayList<Edge>();
		graph.add(6,neibors);
		neibors=new ArrayList<Edge>();
		neibors.add(new Edge(6,1));
		graph.add(7,neibors);
	
	}
	
	public void shortestPath(){
		int[] dis=new int[8];
		for(int i=1;i<=7;i++){
			if(i==2) continue;
			dis[i] = Integer.MAX_VALUE;
		}
		boolean[] mark=new boolean[8];
		for(int i=1;i<=7;i++){
			int min=Integer.MAX_VALUE;
			int v=0;
			for(int j=1;j<=7;j++){
				if(mark[j]) continue;
				if(dis[j]<min) {
					min=dis[j];
					v=j;
				}
			}
			mark[v]=true;
			ArrayList<Edge> neibors=graph.get(v);
			for(Edge edge:neibors){
				if(dis[edge.v]>dis[v]+edge.w)
					dis[edge.v]=dis[v]+edge.w;
			}
		}
		for(int i=1;i<=7;i++){
			System.out.println(i + " :"+dis[i]);
		}
	}
}
