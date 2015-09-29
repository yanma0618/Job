package LK;

import java.util.ArrayList;
import java.util.List;

public class FlowerBed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Boolean> list=new ArrayList<Boolean>();
		list.add(true); list.add(false); list.add(false); list.add(false); 
		list.add(true); list.add(false); list.add(false); list.add(false);
		list.add(true);
		System.out.println(canPlaceFlowers(list,10));
	}

	public static boolean canPlaceFlowers(List<Boolean> flowerbed, int numberToPlace){
		int num=0;
		for(int i=0;i<flowerbed.size();i++){
			if(flowerbed.get(i)) continue;
			if((i==0 || (flowerbed.get(i-1)==false)) &&
					( (i==flowerbed.size()-1) || (flowerbed.get(i+1)==false) )  ){
				num++;
				flowerbed.set(i, true);
				System.out.println(i+" "+num);
				if(num==numberToPlace) return true;
			}
			System.out.println(i+" "+num);
		}
		return false;
	}
}
