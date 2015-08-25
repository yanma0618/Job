package Java;

import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularArray<String> ca=new CircularArray<String>(4);
		/*Class c=ca.getClass();
		Method[] m=c.getDeclaredMethods();
		for(Method item:m){
			System.out.println(item.toString());
		}*/
		ca.set("A", 0);
		ca.set("B", 1);
		ca.set("C",2);
		ca.set("D", 3);
		ca.rotate(1);
		System.out.println(ca.get(1));
		for(String s:ca){
			System.out.print(s);
		}
	}

}
