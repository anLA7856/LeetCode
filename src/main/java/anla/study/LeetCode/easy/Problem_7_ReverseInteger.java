package anla.study.LeetCode.easy;

/**
 * 解题思想： 旧： 开始是想着，把所有array倒转，然后在一个个加上去，乘以当前位数对应的10次幂，
 * 思路很简单，但是会遇到一个问题了，就是如何去判断数据溢出，想到了和前一次对比，因为没有溢出时，才能够
 * 从原来计算回到上一个值，但是我前一种种方法是先算幂，有点“以大加大”，所以也就是在取幂就溢出了，所以不好用当前值和上一次的对比。
 * 
 * 新： 这种方法思路，类似于从最后以为开始，让这一位数，一步一步“移到最高位”，是从小到大处理的，所以旧值是一定不会超出范围的，只能是新值超。
 * 
 * @author anla7856
 *
 */
public class Problem_7_ReverseInteger {
	public static void main(String[] args) {
		Problem_7_ReverseInteger p = new Problem_7_ReverseInteger();
		System.out.print(p.reverse(123));
	}

	public int reverse(int x) {
		int less = x % 10;
		int result = 0;
		while (x != 0) {
			int newResult = result * 10 + less;

			if (((newResult - less) / 10) != result) {
				return 0;
			}

			result = newResult;
			x /= 10;
			less = x % 10;
		}
		return result;
	}
}
