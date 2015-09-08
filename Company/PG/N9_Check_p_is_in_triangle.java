package PG;

public class N9_Check_p_is_in_triangle {
	
	public static void main(String[] args){
		N9_Check_p_is_in_triangle s= new N9_Check_p_is_in_triangle();
		System.out.println( s.check(0, 0, -4, 0, 4, 0, 0, 4));
	}
	
	//cross product represent area of shape 
	//area of triangle is abs(x1*y2-x2*y1)/2
	
	public boolean check(int x, int y, int x1, int y1, int x2, int y2, int x3, int y3){
		int a12= area(x,y,x1,y1,x2,y2);
		int a13= area(x,y,x1,y1,x3,y3);
		int a23= area(x,y,x2,y2,x3,y3);
		int a=area(x2,y2,x1,y1,x3,y3);
		return a12+a13+a23<=a;
	}
	
	public int area(int x, int y, int x1, int y1, int x2, int y2){
		return Math.abs( (x1-x)*(y2-y)-(x2-x)*(y1-y) )/2;
	}
}
