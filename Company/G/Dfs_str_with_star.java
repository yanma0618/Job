package G;

public class Dfs_str_with_star {
	public static void main(String[] args) {
		print("c**", 0, "");
	}

	static void print(String str, int index, String cur) {
		if (index == str.length()) {
			System.out.println(cur);
			return;
		}

		char c = str.charAt(index);
		if (c == '*') {
			print(str, index + 1, cur + "j");
			print(str, index + 1, cur + "i");
		} else {
			print(str, index + 1, cur + String.valueOf(c));
		}

	}

}
