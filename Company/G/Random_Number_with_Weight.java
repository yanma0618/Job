package G;
import java.util.Random;


public class Random_Number_with_Weight {
	public static void main(String[] args){
		double[] p=new double[3];
		p[0]=0.3;p[1]=0.3;p[2]=0.4;
		for(int i=0;i<10;i++) System.out.println(getRandom(p));
	}
	
	public static int getRandom(double[] pos){
		double start=0;
		Random random=new Random();
		DoubleInterval[] di=new DoubleInterval[pos.length];
		for(int i=0;i<pos.length;i++){
			di[i]=new DoubleInterval(start,start+pos[i]);
			start=start+pos[i];
		}
		start=random.nextDouble();
		int l=0,r=di.length-1;
		while(l<=r){
			int m=(l+r)/2;
			if(start>=di[m].left && start<di[m].right) return m;
			if(start>=di[m].right) l=m+1;
			else r=m-1;
		}
		return 0;
	}
}

class DoubleInterval{
	double left;
	double right;
	
	public DoubleInterval(){}
	
	public DoubleInterval(double left, double right){
		this.left=left;
		this.right=right;
	}
}