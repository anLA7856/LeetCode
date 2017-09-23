package anla.study.LeetCode.easy;

public class Problem_1_TwoSum {
	public static void main(String[] args) {
		Problem_1_TwoSum p = new Problem_1_TwoSum();
		int[] temp = { 2, 7, 11, 15 };
		int[] result = p.twoSum(temp, 9);
		System.out.println(result[0] + " " + result[1]);

	}

	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];

		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}
		return result;
	}
}
