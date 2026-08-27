class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums,0,res,result);
        return result;
    }

    public void solve(int[] nums, int index, List<Integer> res, List<List<Integer>> result){
        if(index == nums.length){
            result.add(new ArrayList<>(res));
            return;
        }
        res.add(nums[index]);
        solve(nums,index+1,res, result);
        res.remove(res.size()-1);

        int next = index+1;
        while(next < nums.length && nums[next] == nums[index]){
            next++;
        }

        solve(nums, next, res, result);
    }
}