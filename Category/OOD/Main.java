package OOD;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Main {
	public static void main(String[] args) throws IOException{		
		
		
		BufferedReader br = new BufferedReader(new FileReader("/Users/mayan/Documents/workspace/careercup/src/OOD/text.txt"));
		HashSet<String> hs=new HashSet<String>();
		String in;
		while((in=br.readLine())!=null){
			hs.add(in);
		}
		for(String s:hs){
			System.out.println(s);
		}
	}
}
