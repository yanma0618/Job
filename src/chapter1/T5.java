package chapter1;

public class T5 {
	 public static void main(String[] args){
		 char[] ch="abc  sdf ".toCharArray();
	
	//	 System.out.print(copy);
		 System.out.print(replace(ch));
	 }
	 
	 static String replace(char[] ch){
		 int count=0;
		 for(char tmp:ch){
			 if(tmp == ' ') count++;
		 }
		 int length=ch.length-1;
		 char[] copy=new char[ch.length+count*2];
		 copy[copy.length-1]='\0';
		 
		 System.arraycopy(ch, 0, copy, 0, ch.length);
		 System.out.println(copy.length);
		 int j=copy.length-1;
		 for(int i=ch.length-1; i>=0; i--){
			 if(copy[i] == ' '){
				// System.out.println(i);
				 copy[j--]='0';
				 copy[j--]='2';
				 copy[j--]='%';
			 }else{
				 copy[j--]=copy[i];
			 }
		 }
		 
		 
		 return new String(copy);
	 }
}
