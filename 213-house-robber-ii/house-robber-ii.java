class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int[] memo1 = new int[n];
        int[] memo2 = new int[n];


        Arrays.fill(memo1, -1);
        Arrays.fill(memo2, -1);
        return Math.max(solve(nums,0,n-2, memo1), solve(nums, 1, n-1, memo2));
    }

    public int solve(int[] nums, int start, int end, int[] memo){
        if(end == start) return nums[start];
        if(end == start+1) return Math.max(nums[start], nums[end]);
        if(memo[end] != -1){
            return memo[end];
        }

        int include = solve(nums, start, end-1, memo);
        int exclude = solve(nums, start, end-2, memo) + nums[end];

        memo[end] = Math.max(include, exclude);
        return memo[end];
    }
}