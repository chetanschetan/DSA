class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> res=  new ArrayList<>();
        solve(candidates, 0, 0, res, result, target);

        return result;
    }

    public void solve(int[] nums, int index, int currSum, List<Integer> res, List<List<Integer>> result,int target){
        if(currSum > target) return;
        if(index == nums.length && currSum < target) return;
        if(index == nums.length && currSum == target){
            result.add(new ArrayList<>(res));
            return;
        }
        res.add(nums[index]);
        solve(nums,index,currSum+nums[index],res,result,target);
        res.remove(res.size() - 1);
        solve(nums,index+1,currSum,res,result,target);
    }
}