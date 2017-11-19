package anla.study.LeetCode.easy;
/**
 * 注意，不仅仅会要返回长度，还需要把原来数组改变成新数组
 * @author anla7856
 *
 */
public class Problem_27_RemoveElement {
	public static void main(String[] args) {
		int[] nums = {3,2,2,3};
		int val = 3;
		System.out.println(new Problem_27_RemoveElement().removeElement(nums, val));
	}

	public int removeElement(int[] nums, int val) {
		int lastLength = 0,oldLength = nums.length,k = 0;
		
		for(int i = 0;i < oldLength;i++){
			if(nums[i] == val){
				lastLength++;
			}
			
			if(nums[i] != val){
				nums[k] = nums[i];
				k++;
			}
		}
		return nums.length - lastLength;
	}
}
