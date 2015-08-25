package scalabiltiy;

import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		checkDup cd=new checkDup();
		int[] arr={1,4,3,6,4,7,8,9,2,1,2,};
		cd.check(arr);
		Class c=cd.getClass();
		Method mp[]=c.getDeclaredMethods();
		for(int i=0;i<mp.length;i++){
			System.out.println(mp[i].toString());
		}
	}

}
