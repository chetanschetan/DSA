class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return solve(nums, n-1, memo);
    }

    public int solve(int[] nums, int i, int[] memo){
        if(i == 0) return nums[0];
        if(i == 1) return Math.max(nums[1],nums[0]);

        if(memo[i] != -1){
            return memo[i];
        }

        int include = solve(nums, i-1, memo);
        int exclude = solve(nums, i-2, memo) + nums[i];

        memo[i] = Math.max(include, exclude);

        return memo[i];
    }
}