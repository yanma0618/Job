package bit;

public class Binary {
	public Binary(){}
	
	public String printBinary(String n){
		int intpart=Integer.parseInt(n.substring(0,n.indexOf(".")));
		double decpart=Double.parseDouble(n.substring(n.indexOf(".")));
		String intres="";
		while(intpart>0){
			int r=intpart%2;
			intres = r+intres;
			intpart/=2;
		}
		StringBuffer decres=new StringBuffer();
		while(decpart>0){
			double r=decpart*2;
			if(r>=1){
				decres.append(1);
				decpart=r-1;
			}else{
				decres.append(0);
				decpart=r;
			}
		}
		return intres+"."+decres.toString();
	}
}
