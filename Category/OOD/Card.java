package OOD;

import java.util.Comparator;

public  class Card{
	private int card;
	private Suit suit;
	
	public Card(int c, Suit s){
		card=c;
		suit=s;
	}
	
	public int card(){
		return card;
	}
	
	
	public Suit suit(){
		return suit;
	}
	
}
