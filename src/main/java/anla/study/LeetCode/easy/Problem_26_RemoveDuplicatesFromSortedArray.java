package anla.study.LeetCode.easy;

/**
 * 注意一个重要的点，sorted，也就是排序好的。。 
 * 参考最优解去写的，通过两个指针i，j，一个往后面找，一个负责赋值，
 * 因为是排序好的，所以不会出现找到之前的数字
 * 
 * @author anla7856
 *
 */
public class Problem_26_RemoveDuplicatesFromSortedArray {
	public static void main(String[] args) {
		Problem_26_RemoveDuplicatesFromSortedArray p = new Problem_26_RemoveDuplicatesFromSortedArray();
		int[] nums = { -3, -1, 0, 0, 0, 3, 3 };
		System.out.println(p.removeDuplicates(nums));

	}

	public int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != nums[j]) {
				nums[++j] = nums[i];
			}
		}
		return ++j;
	}

}
