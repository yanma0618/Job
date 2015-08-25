package OodDeck;

import java.util.ArrayList;
import java.util.Random;

public class Deck<T extends Card> {
	ArrayList<T> cards;
	int dealtIndex;
	public Deck(){
		cards= new ArrayList<T>();
		dealtIndex=0;
	}
	
	public void suffle(){
		Random random= new Random();
		int randomI;
		T tmp;
		for(int i=cards.size()-1;i>=1;i--){
			randomI=random.nextInt(i);
			tmp = cards.get(randomI);
			cards.set(randomI,cards.get(i));
			cards.set(i,tmp);
		}
	}
	
	public T dealCard(){
		if(dealtIndex==cards.size()){
			this.suffle();
			dealtIndex=0;
		}
		return cards.get(dealtIndex++);
	}
	
	public int remainCards(){
		return cards.size()-dealtIndex;
	}
	
}
