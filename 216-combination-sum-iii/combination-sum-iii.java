class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        solve(1, k, n, 0, res, result);
        return result;
    }

    public void solve(int index, int k, int n, int currSum, List<Integer> res, List<List<Integer>> result){
        if(currSum > n) return;
        if(index == 10 && currSum < n) return;
        if(index == 10 ){
            if(currSum == n && res.size() == k){
                result.add(new ArrayList<>(res));
            }
            return;
        }
        res.add(index);
        solve(index+1, k, n, currSum + index, res, result);
        res.remove(res.size()-1);
        solve(index+1, k, n, currSum, res, result);
    }
}