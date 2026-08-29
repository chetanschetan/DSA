class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        solve(num, target, 0, 0, 0, res, "");
        return res;
    }
    
    public void solve(String num, int target, int index, long total, long prev, List<String> res, String exp){
        if(index == num.length()){
            if(total == target){
                res.add(exp);
            }
            return;
        }

        for(int end=index;end<num.length();end++){
            String newStr = num.substring(index, end+1);

            if(newStr.length()>1 && newStr.charAt(0) == '0'){
                break;
            }

            long currNum = Long.parseLong(newStr);

            if(index == 0){
                solve(num, target, end+1, currNum, currNum, res, exp+newStr);
            }else{
                solve(num, target, end+1, total + currNum, currNum, res, exp+"+"+newStr);
                solve(num, target, end+1, total - currNum, -currNum, res, exp+"-"+newStr);
                solve(num, target, end+1, (total - prev) + (currNum * prev), prev*currNum, res, exp+"*"+newStr);
            }
        }
    }
}