package G;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import OOD.Card;
import OOD.Suit;

public class Texas {
	 public static void main(String[] args){
		 Texas t=new Texas();
		 t.addCard(new Card(1,Suit.club));
		 t.addCard(new Card(1,Suit.club));
		 t.addCard(new Card(8,Suit.diamond));
		 t.addCard(new Card(8,Suit.club));
		 t.addCard(new Card(8,Suit.club));
		 System.out.println(t.score());
	 }
	
	 List<Card> cards;
	 
	 public Texas(){
		 cards =  new ArrayList<Card>();
	 }
	 
	 public void addCard(Card c){
		 cards.add(c);
	 }
	 
	 public int score(){
		 sort();
		 if(isFlush() && isStraight()) return 8;
		 int[] r=repeatNum();
		 
		 if(r[0]==4) return 7;
		 if(r[0]==3 && r[1]==2) return 6;
		 
		 if(isFlush()) return 5;
		 if(isStraight()) return 4;
		 
		 if(r[0]==3) return 3;
		 
		 if(r[0]==2) return 2;
		 
		 
		 
		 return 1;
	 }
	 
	 
	 
	 public boolean isFinish(){
		 return cards.size()==5;
	 }
	 
	 private void sort(){
		 Collections.sort(cards, new Comparator<Card>(){

				@Override
				public int compare(Card o1, Card o2) {
					if(o1.card()==o2.card()){
						return o1.suit().getValue()-o2.suit().getValue();
					}
					return o1.card()-o2.card();
				}
				 
		 });
	 }
	 
	 private boolean isFlush(){		 
		 for(int i=1;i<5;i++){
			 if(cards.get(0).suit()!=cards.get(i).suit()){
				 return false;
			 }
		 }
		 return true;
	 }
	 
	 private boolean isStraight(){
		 
		 for(int i=0;i<cards.size()-1;i++){
			 if((cards.get(i).card()+1)!=cards.get(i+1).card()) return false;
		 }
		 return true;
	 }
	 
	 private int[] repeatNum(){
		 
		 int[] ret=new int[2];
		 int cur=cards.get(0).card();
		 int count=1;
		 int i=1;
		 while(i<5){
			 if(cards.get(i).card() == cur){
				 count++;
			 }else{
				 if(count>ret[0]){
					 ret[1]=ret[0];
					 ret[0]=count;
				 }else if(count>ret[1]){
					 ret[1]=count;
				 }
				 count=1;
				 cur=cards.get(i).card();
			 }
			 i++;

		 }
		 if(count>ret[0]){
			 ret[1]=ret[0];
			 ret[0]=count;
		 }else if(count>ret[1]){
			 ret[1]=count;
		 }
		 return ret;
	 }
	 
	 
}
