package anla.study.LeetCode.easy;

public class Problem_14_LongestCommonPrefix {
	public static void main(String[] args) {
		Problem_14_LongestCommonPrefix p = new Problem_14_LongestCommonPrefix();
		String[] s = { "aa", "ab" };
		System.out.println(p.longestCommonPrefix(s));
	}

	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0 || strs == null) {
			return "";
		}
		int shortestIndex = 0;
		for (int i = 0; i < strs.length; i++) {
			if (strs[shortestIndex].length() > strs[i].length()) {
				shortestIndex = i;
			}
		}
		if (strs[shortestIndex].length() == 0) {
			return "";
		}
		char[] shortestChars = strs[shortestIndex].toCharArray();
		for (int i = 0; i < shortestChars.length; i++) {
			for (int j = 0; j < strs.length; j++) {
				if (strs[j].charAt(i) != shortestChars[i]) {
					// 注意这里要有个判断
					if (i == 0) {
						return "";
					}
					// 注意不是到i-1
					return strs[shortestIndex].substring(0, i);
				}
			}
		}

		return strs[shortestIndex];
	}
}
