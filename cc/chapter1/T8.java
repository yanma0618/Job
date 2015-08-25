package chapter1;



public class T8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "waterbottle";
	
		String b="erbottlewat";
		if(rotatestring(a,b))
			System.out.print("true");
		else System.out.print("false");
	}
	
	static boolean rotatestring (String a, String b){
		
		String c=a+a;
		if(a.length() == b.length() && c.contains(b)) 
			return true;
		return false;
	}

}
