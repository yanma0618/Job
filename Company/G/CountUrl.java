package G;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CountUrl {
	
	public static void main(String[] args){
		System.out.println(countNumber("1234"));
	}

	static public int countNumber(String url) {
		int number = 0;
		HashSet<String> set = new HashSet<String>();
		Queue<String> queue = new LinkedList<String>();
		queue.add(url);
		set.add(url);
		while (!queue.isEmpty()) {
			String root = queue.poll();
			System.out.println(root);
			number++;
			for (String child : fetchPageAndExtractUrls(root)) {
				if (!set.contains(child)) {
					set.add(child);
					queue.add(child);
				}
			}
		}
		return number;
	}

	static public List<String> fetchPageAndExtractUrls(String url) {
		List<String> res = new ArrayList<String>();
		if (url.length() > 5)
			return res;
		res.add(url + "a");
		res.add(url + "b");
		return res;
	}
}
