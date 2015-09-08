package G;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SysConvert {

	public static void main(String[] args) {
		System.out.println(convert(10,2));
	}

	public static List<Integer> convert(int n, int base){
		List<Integer > ret =new ArrayList<Integer>();
		while(n>0){
			ret.add (n%base);
			n /= base;
		}
		Collections.reverse(ret);
		return ret;
	}
}
