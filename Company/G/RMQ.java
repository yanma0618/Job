package G;

public class RMQ {
	public static void main(String[] args){
    int[] list={0,1,2,5,4,0,1,6,3};
    System.out.println(min(list,2,4));
  }
  
  static int getLog(int x) {
    int ret = -1;
    while (x > 0) {
      ret++;
      x >>= 1;
    }
    return ret;
  }
  
  static int min(int[] list, int start, int end){
    int n = list.length;
    int h = getLog(n);
    int[][] helper=new int[n][h + 1];
    for (int i = 0; i < n; i++) helper[i][1] = list[i];
    for (int j = 2; j <= h; j++) 
      for (int i = 0; i < n; i++) {
        if (i + (1<<j) <= n) {
          helper[i][j] = Math.min(helper[i][j - 1], helper[i + (1 <<(j - 1))][j - 1]);
        }
      }
    
    int l = getLog(end - start + 1);
    return Math.min(helper[start][l], helper[end - l + 1][l]);
    
  }
}
