class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates, 0, target, 0, res,result);
        return result;
    }

    public void solve(int[] nums, int index, int target, int currSum, List<Integer> res, List<List<Integer>> result){
        if(currSum > target) return;
        if(index == nums.length && currSum < target) return;
        if(index == nums.length && currSum == target){
            result.add(new ArrayList<>(res));
            return;
        }

        res.add(nums[index]);
        solve(nums, index+1, target, currSum+nums[index], res, result);
        res.remove(res.size() - 1);
        int next = index+1;
        while(next<nums.length && nums[next] == nums[index]){
            next++;
        }
        solve(nums, next, target, currSum, res, result);
    }
}