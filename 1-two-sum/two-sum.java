class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;

        for(int i=0;i<n;i++){
            map.put(nums[i],i);
        }

        for(int i=0;i<n;i++){
            int index = i;
            int sum = target - nums[i];
            if(map.containsKey(sum)){
                index = map.get(sum);
            }
            if(index == i) continue;
            return new int[]{index,i};
        }
        return new int[]{};
    }
}