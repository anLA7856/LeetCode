package anla.study.LeetCode.easy;

/**
 * 找出，子串在母串中第一次出现位置。
 * 思路清点。
 * KMP
 * 注意：最后区分
 * if(haystack.length() == needle.length()){
 *	   return 0;
 * }else{
 *	   return i-j;
 * }
 * @author anla7856
 *
 */
public class Problem_28_ImplementstrStr {
	public static void main(String[] args) {
		String haystack = "mississippi", needle = "mississippi";
		System.out.println(new Problem_28_ImplementstrStr().strStr(haystack,
				needle));
	}

	public int strStr(String haystack, String needle) {
		char[] parentChar = haystack.toCharArray(), sonChar = needle.toCharArray();
		if (haystack.length() < needle.length()) {
			return -1;
		}
		if (needle.length() == 0) {
			return 0;
		}
		//双重
		for (int i = 0; i < parentChar.length; i++) {
			for (int j = 0; j < sonChar.length; j++) {
				//相等的时候
				if(parentChar[i] == sonChar[j]){
					//比到最后一个。
					if (j == sonChar.length - 1) {
						if(haystack.length() == needle.length()){
							return 0;
						}else{
							return i-j;
						}
					}
					i++;
					//加了1,所以能够用长度来判断。
					if(i == parentChar.length){
						return -1;
					}
					continue;
				}
				//不相等的时候
				if (parentChar[i] != sonChar[j]) {
					i = i - j;
					break;
				}
			}
		}
		return -1;
	}
}
