package PS;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class AlignRec {
	static Rectangle[] recs;
	public static void main(String[] args){
		
		Comparator<Rectangle> comp = new Comparator<Rectangle>(){
			public int compare(Rectangle o1, Rectangle o2) {
				
				return o2.getWidth()-o1.getWidth();
			}	
		};
		init();
		print();
		System.out.println();
		Arrays.sort(recs, comp);
		print();
	}
	
	static void init(){
		recs=new Rectangle[20];
		Random ran=new Random();
		for(int i=0;i<recs.length;i++){
			recs[i]=new Rectangle(ran.nextInt(20)+1, ran.nextInt(20)+1);
		}
	}
	
	static void print(){
		for(Rectangle r:recs){
			r.print();
		}
	}
	
	
}

class Rectangle{
	private int length;
	private int width;
	
	public Rectangle(){}
	public Rectangle(int l,int w){
		this.setLength(l);
		this.setWidth(w);
	}
	
	public void print(){
		System.out.println("w:"+getWidth() +", h:"+getLength());
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
}