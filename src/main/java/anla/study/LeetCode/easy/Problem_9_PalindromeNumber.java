package anla.study.LeetCode.easy;

public class Problem_9_PalindromeNumber {

	public static void main(String[] args) {
		Problem_9_PalindromeNumber p = new Problem_9_PalindromeNumber();
		System.out.print(p.isPalindrome(66661));
	}

	public boolean isPalindrome(int x) {
		String strX = x+"";
		char[] strArray = strX.toCharArray();
		for(int i = 0;i < strArray.length/2;i++){
			if(strArray[i] != strArray[strArray.length-1-i]){
				return false;
			}
		}
		return true;
	}

}
