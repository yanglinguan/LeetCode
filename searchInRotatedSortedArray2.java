public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length == 0) return false;
        int start = 0;
        int end = nums.length - 1;
        
        while(start < end - 1) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) return true;
            if(nums[mid] > nums[start]) {
                if(nums[mid] > target && target >= nums[start]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else if (nums[mid] < nums[start]) {
                if(nums[mid] < target && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else {
                start++;
            }
        }
        return nums[start]== target || nums[end] == target? true : false;
    }
}
