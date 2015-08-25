import java.util.Random;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
	public static void main(String[] args) {
		Random r = new Random();
		int i = 0;
		while (i <= 10) {
			System.out.println(r.nextInt(3));
			i++;
		}
	}

}