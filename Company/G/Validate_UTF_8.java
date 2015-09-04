package G;

public class Validate_UTF_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte[] b= {(byte) 0b00000000}; 
		System.out.println(validate(b));
		System.out.println(validate_a(b));
	}
	
	static boolean validate(byte[] bytes){
		int expectedLen=0;
		if(bytes.length==0 || bytes.length>8) return false;
		else if ((bytes[0] & 0b10000000) == 0b00000000) expectedLen = 1;
	    else if ((bytes[0] & 0b11100000) == 0b11000000) expectedLen = 2;
	    else if ((bytes[0] & 0b11110000) == 0b11100000) expectedLen = 3;
	    else if ((bytes[0] & 0b11111000) == 0b11110000) expectedLen = 4;
	    else if ((bytes[0] & 0b11111100) == 0b11111000) expectedLen = 5;
	    else if ((bytes[0] & 0b11111110) == 0b11111100) expectedLen = 6;
	    else if ((bytes[0] & 0b11111110) == 0b11111100) expectedLen = 7;
	    else if ((bytes[0] & 0b11111110) == 0b11111100) expectedLen = 8;
	    else    return false;
		if(bytes.length!=expectedLen) return false;
		
		for(int i=1;i<expectedLen;i++){
			if((bytes[i] & 0b11000000 )!= 0b10000000) {
				return false;
			}
		}
		
		return true;
	}
	static boolean validate_a(byte[] bytes){
		if(bytes.length<1 || bytes.length>8) return false;
		int expectedLen=getLen(bytes[0]);
		if(expectedLen==1) return false;
		if(expectedLen==0) expectedLen=1;
		if(expectedLen!=bytes.length) return false;
		for(int i=1;i<expectedLen;i++){
			if((bytes[i] & 0b11000000 )!= 0b10000000) {
				return false;
			}
		}
		return true;
	}
	
	static int getLen(byte b){
		int count=0;
		while( (b & 0b10000000 ) == 0b10000000 ){
			count++;
			b<<=1;
		}
		return count;
	}

}
