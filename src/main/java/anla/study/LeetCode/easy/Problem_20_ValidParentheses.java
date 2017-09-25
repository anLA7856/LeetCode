package anla.study.LeetCode.easy;

/**
 * 1、利用数组模拟栈操作 2、注意利用ascii码来比较括号
 * 
 * @author anla7856
 *
 */
public class Problem_20_ValidParentheses {
	public static void main(String[] args) {
		Problem_20_ValidParentheses p = new Problem_20_ValidParentheses();
		System.out.println(p.isValid("{}{}{([{{])}"));
	}

	public boolean isValid(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		if (s.length() == 1) {
			return false;
		}
		char[] inputc = s.toCharArray();
		int top = 0;
		char[] stack = new char[inputc.length];
		stack[0] = inputc[0];
		for (int i = 1; i < inputc.length; i++) {
			if (top != -1 && compare(inputc[i], stack[top])) {
				top--;
			} else {
				top++;
				stack[top] = inputc[i];
			}
		}
		if (top == -1) {
			return true;
		} else {
			return false;
		}
	}

	private boolean compare(char p1, char p2) {
		if (Math.abs(p1 - p2) == 1 || Math.abs(p1 - p2) == 2) {
			return true;
		} else {
			return false;
		}
	}
}
