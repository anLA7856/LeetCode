package anla.study.LeetCode.easy;

public class Problem_35_SearchInsertPosition {
	public static void main(String[] args) {
		int[] nums = {1,3,5,6};
		System.out.println(searchInsert(nums,7));
	}
	
	
    public static int searchInsert(int[] nums, int target) {
    	int index = -1;
        for(int i = 0;i < nums.length;i++){
        	if(target > nums[i]){
        		continue;
        	}
        	index = i;
        	break;
        }
        if(index == -1){
        	index = nums.length;
        }
		return index;
    }
}
