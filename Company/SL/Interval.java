package SL;

import java.util.Scanner;

public class Interval {
	static void updateDown(boolean[] tree, int i, int s, int e) {
		if (s != e && tree[i]) tree[i * 2 + 1] = tree[i * 2 + 2] = true;
	}
	static void updateUp(boolean[] tree, int i, int s, int e) {
		if (s != e && tree[i * 2 + 1] && tree[i * 2 + 2]) tree[i] = true;
	}
	static void insert(boolean[] tree, int i, int s, int e, int ns, int ne) {
		updateDown(tree, i, s, e);
		if (s == ns && e == ne) {
			tree[i] = true;
			return ;
		} 
		int m = s + (e - s) / 2;
		if (m >= ne) insert(tree, i * 2 + 1, s, m, ns, ne);
		else if (m < ns) insert(tree, i * 2 + 2, m + 1, e, ns, ne);
		else {
			insert(tree, i * 2 + 1, s, m, ns, m);
			insert(tree, i * 2 + 2, m + 1, e, m + 1, ne);
		}
		updateUp(tree, i, s, e);
	}
	static boolean query(boolean[] tree, int i, int s, int e, int ns, int ne) {
		updateDown(tree, i, s, e);
		if (s == ns && e == ne) {
			return tree[i];
		} 
		int m = s + (e - s) / 2;
		if (m >= ne) return query(tree, i * 2 + 1, s, m, ns, ne);
		else if (m < ns) return query(tree, i * 2 + 2, m + 1, e, ns, ne);
		else return query(tree, i * 2 + 1, s, m, ns, m) && query(tree, i * 2 + 2, m + 1, e, m + 1, ne);
	}
	public static void main(String[] args) {
		// Assuming intervals are between 0 ~ 99
		boolean[] tree = new boolean[100 * 2];
		Scanner in = new Scanner(System.in);
		while (true) {
			int oper = in.nextInt();
			int s = in.nextInt();
			int e = in.nextInt();
			if (oper == 0) {
				// Insert
				insert(tree, 0, 0, 99, s, e);
			} else {
				// Query
				System.out.println(query(tree, 0, 0, 99, s, e));
			}
		}
	}
}
