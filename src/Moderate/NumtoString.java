package Moderate;

public class NumtoString {
	String[] digits={"One", "Two","Three","Four","five","Six","seven","eight","nine"};
	String[] teens={"eleven","twelve", "thirteen", "fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
	String[] tens={"Ten", "Twenty", "Thirty","Forty", "Fifty","Sixty", "seventy", "eighty", "ninety"};
	String[] bigs={"", "Thousand", "million", "billion"};
	public String run(int num){
		if(num==0) return "Zero";
		if(num<0) return "Negative"+run(num*-1);
		int count=0;
		String res="";
		while(num>0){
			if(num % 1000!=0){
				res=numtostring100(num%1000)+bigs[count]+", "+res;
			}
			num/=1000;
			count++;
		}
		return res;
	}
	public String numtostring100(int num){
		String res="";
		if(num>=100){
			res+=digits[num/100-1]+" Hundred ";
			num=num%100;
		}
		if(num>=20||num==10){
			res+=tens[num/10-1]+" ";
			num%=10;
		}
		if(num>10 && num<=19){
			res+=teens[num-10-1]+" ";
			num=0;
		}
		if(num>0){
			res+=digits[num-1]+" ";
		}
		return res;
	}
}
