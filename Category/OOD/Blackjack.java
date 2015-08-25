package OOD;

public class Blackjack extends Card{
	public Blackjack(int c, Suit s){
		super(c,s);
	}
	
	public int value(){
		int r=card();
		if(r==1) return 11;
		if(r<10) return r;
		else return 10;
	}
	
	boolean isAce(){
		return card()==1;
	}
	
}
