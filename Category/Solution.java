import java.util.Random;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
//		System.out.println(s.isMatch("aa", "*"));
		System.out.println(s.isMatch("aa","a"));
		System.out.println(s.isMatch("aa","aa"));
		System.out.println(s.isMatch("aaa","aa"));
		System.out.println(s.isMatch("aa", "*"));
		System.out.println(s.isMatch("aa", "a*"));
		System.out.println(s.isMatch("ab", "?*"));
		System.out.println(s.isMatch("aab", "c*a*b"));

	}

	public boolean isMatch(String s, String p) {
		if (s == null || p == null)
			return false;
		return dfs(s, p, 0, 0);

	}

	public boolean dfs(String s, String p, int i, int j) {
		if (i >= s.length() && j >= p.length())
			return true;
		if (i >= s.length() || j >= p.length())
			return false;
		if (p.charAt(j) != '*') {
			if (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)) {
				return dfs(s, p, i + 1, j + 1);
			} else {
				return false;
			}
		} else {
			while (j < p.length() && p.charAt(j) == '*') {
				j++;
			}
			for (int k = i; k <= s.length(); k++) {
				if (dfs(s, p, k, j)) {
					return true;
				}
			}
		}
		return false;
	}
}
