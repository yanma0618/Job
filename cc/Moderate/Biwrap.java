package Moderate;

public class Biwrap implements Comparable<Biwrap>{
	private int x;
	private char c;
	Biwrap(int x, char c){
		this.x=x;
		this.c=c;
	}
	int getx(){
		return x;
	}
	char getc(){
		return c;
	}
	
	@Override
	public int compareTo(Biwrap b) {
		// TODO Auto-generated method stub
		return x<b.getx()? -1: (x>b.getx()? 1 :0);
	}
	
	
}
