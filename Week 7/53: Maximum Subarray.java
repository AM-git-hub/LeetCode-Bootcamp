class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = 0;

        for(int i:nums)
        {
            currSum = Math.max(0,currSum);
            currSum+=i;
            maxSum=Math.max(maxSum,currSum);
        }
        return maxSum;
    }
}