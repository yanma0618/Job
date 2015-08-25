package OOD;

public abstract class Card {
	private int card;
	private Suit suit;
	
	public Card(int c, Suit s){
		card=c;
		suit=s;
	}
	
	public int card(){
		return card;
	}
	
	public abstract int value();
	
	public Suit suit(){
		return suit;
	}
	
}
