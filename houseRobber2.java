class Solution {
    
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int yes = 0;
        int no = 0;
        for(int i = 1; i < nums.length; i++) {    
            int tmp = no;
            no = Math.max(yes, no);
            yes = tmp + nums[i];
        }
        int max1 = Math.max(yes, no);
        yes = 0;
        no = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            int tmp = no;
            no = Math.max(yes, no);
            yes = tmp + nums[i];
        }
        int max2 = Math.max(yes, no);
        
        return Math.max(max2, max1);
        
    }
}
