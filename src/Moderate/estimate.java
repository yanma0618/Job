package Moderate;

public class estimate {
	public int[] run(String solution, String guess){
		int[] res=new int[2];//0 hit, 1 pes
		int mark=0;
		for(int i=0; i<solution.length();i++){
			if(guess.charAt(i)!=solution.charAt(i))
				mark |= (1<<(solution.charAt(i)-'A'));
		}
			
		for(int i=0;i<guess.length();i++){
			if(guess.charAt(i)==solution.charAt(i))
				res[0]++;
			else{
				if( ((1<<(guess.charAt(i)-'A')) & mark) >=1)
					res[1]++;
			}
		}
		return res;
	}
}
