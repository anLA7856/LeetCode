package anla.study.LeetCode.easy;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 本想使用hashset来省事解决，但是中途遇到了一些小问题 
 * 1、用hash时记得重写hashcode和equals方法
 * 2、iterator来遍历hash类的变量 
 * 3、通过iterator遍历得到的值，其顺序和最开始放入顺序没有特定关系
 * 
 * @author anla7856
 *
 */
public class Problem_26_RemoveDuplicatesFromSortedArray_Test {
	public static void main(String[] args) {
		Problem_26_RemoveDuplicatesFromSortedArray_Test p = new Problem_26_RemoveDuplicatesFromSortedArray_Test();
		int[] nums = { 1, 1, 2 };
		System.out.println(p.removeDuplicates(nums));
		for (int i : nums) {
			System.out.println(i);
		}
	}

	public int removeDuplicates(int[] nums) {
		Set<MyInt> set = new HashSet<MyInt>();
		for (int i = 0; i < nums.length; i++) {
			set.add(new MyInt(nums[i]));
		}
		int j = 0;
		Iterator<MyInt> it = set.iterator();
		while (it.hasNext()) {
			nums[j] = it.next().val;
			j++;
		}
		return set.size();
	}

	private class MyInt {
		int val;

		public MyInt(int val) {
			this.val = val;
		}

		@Override
		public int hashCode() {
			return val;
		}

		@Override
		public boolean equals(Object obj) {
			MyInt myInt = (MyInt) obj;
			if (this.val == myInt.val) {
				return true;
			} else {
				return false;
			}
		}
	}
}
