package OOD;

import java.util.ArrayList;
import java.util.Random;

public class Deck<T extends Card> {
	private ArrayList<T> cards;
	private int dealtIndex=0;
	@SuppressWarnings("unchecked")
	public Deck(){
		cards=new ArrayList<T>();
		
	}
	public void add(T t) {
		cards.add(t);
	}
	public T getcurrentcard(){
		if(dealtIndex==cards.size()){
			this.shuffle();
			dealtIndex=0;
		}
		return cards.get(dealtIndex++);
	}
	
	public void shuffle(){
		Random randinx=new Random();
		int newI;
		T tmp;
		for(int i=cards.size()-1; i>=1; i--){
			newI=randinx.nextInt(i);
			tmp=cards.get(i);
			cards.set(i, cards.get(newI));
			cards.set(newI, tmp);
		}
	}
	public int remainingCards(){
		return cards.size()-dealtIndex;
	}
}
