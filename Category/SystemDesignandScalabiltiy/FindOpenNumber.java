package SystemDesignandScalabiltiy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FindOpenNumber {
	
	public static void main(String[] args){
		FindOpenNumber s= new FindOpenNumber();
		try {
			s.findOpenNumber();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public void findOpenNumber() throws FileNotFoundException{
		byte[] bitfield=new byte[Integer.MAX_VALUE/8];
		Scanner in = new Scanner(new File("input.txt"));
		while(in.hasNext()){
			int n = in.nextInt();
			bitfield[n/8] |= 1<<((n)%8);
		}
		
		for(int i=0;i<bitfield.length;i++){
			for(int j=0;j<8;j++){
				if((bitfield[i] & (1<<j))==0){
					System.out.println((i*8+j));
					return;
				}
			}
		}
	}
	
	
}
