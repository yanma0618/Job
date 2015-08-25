package OodDeck;

import java.util.ArrayList;

public class Hand<T extends Card> {
	
	ArrayList<T> cards;
	public Hand(){
		cards=new ArrayList<T>();
	}
	
	public void clear(){
		cards=new ArrayList<T>();
	}
	
	public int score(){
		int res=0;
		for(T card:cards){
			res+=card.value();
		}
		return res;
	}
	public void addCard(T c){
		cards.add(c);
	}
	public T getCard(int position){
		T tmp = cards.get(position);
		cards.remove(position);
		return tmp;
	}
	public void removeCard(int position){
		cards.remove(position);
	}
	
	public void sortBySuit(){
		
	}
	
	public void sortByvalue(){
		
	}
}
