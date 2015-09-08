package OOD;

import java.util.ArrayList;


public class Hand<T extends Card> {
	private ArrayList<T> cards=new ArrayList<T>();
	public Hand(){}
	public int score(){
		int score=0;
		for(T c:cards){
			score+=c.card();
		}
		return score;
	}
	public ArrayList<T> getcards(){
		return cards;
	}
	public void addcard(T c){
		cards.add(c);
	}
}
