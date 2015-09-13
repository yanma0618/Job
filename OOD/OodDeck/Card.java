package OodDeck;

public abstract class Card {
	public final static int SPAKES=0;
	public final static int HEARTS=1;
	
	private Suit suit;
	private int card;
	
	public Card(int card, Suit suit){
		this.card=card;
		this.suit=suit;
	}
	
	public abstract int value();
	
	public Suit getSuit(){return suit;}
	public int getCard(){
		return card;
	}
}

