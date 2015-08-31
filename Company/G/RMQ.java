package G;

public class RMQ {
	public static void main(String[] args){
    int[] list={9,1,2,5,4,6,3};
    System.out.println(log(7));
    System.out.println(min(list,0,6));
    System.out.println(max(list,5,6));
  }
  
  static int log(int x){
	  int ret=-1;
	  while(x>0){
		  ret++;
		  x=x>>1;
	  }
	  return ret;
  }
  
  static int min(int[] num, int start, int end){
	  int len=log(num.length);
	  int[][] min = new int[num.length][len+1];
	  for(int i=0;i<num.length;i++){
		  min[i][0]=num[i];
	  }
	  
	  for(int j=1;j<=len;j++){
		  for(int i=0;i<num.length;i++){
			  if(i+(1<<j)-1<num.length){
				  min[i][j]=Math.min(min[i][j-1],min[i+(1<<(j-1))][j-1]);
			  }
		  }
	  }
	  int k=log(end-start+1);
	  return Math.min(min[start][k],min[end-(1<<k)+1][k]);
  }
  
  static int max(int[] num, int start, int end){
	  int len = log(num.length);
	  System.out.println("len"+len);
	  int[][] max=new int[num.length][len+1];
	  for(int i=0;i<num.length;i++){
		  max[i][0]=num[i];
	  }
	  for(int j=1;j<=len;j++){
		  for(int i=0;i<num.length;i++)
			  if(i+(1<<j)-1<num.length)
				  max[i][j]=Math.max(max[i][j-1], max[i+(1<<(j-1))][j-1]);
	  }
	  
	  int k = log(end-start+1);
	  return Math.max(max[start][k], max[end-(1<<k)+1][k]);
  }
}
