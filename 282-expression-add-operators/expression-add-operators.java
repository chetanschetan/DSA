class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        solve(num, target, 0, 0, 0, "", res);
        return res;
    }

    public void solve(String num, int target, int index, long total, long prev, String exp, List<String> res){
        if(index == num.length()){
            if(total == target){
                res.add(exp);
            }
            return;
        }

        for(int end=index;end<num.length();end++){
            String newStr = num.substring(index, end+1);
            long currNum = Long.parseLong(newStr);

            if(newStr.length() > 1 && newStr.charAt(0) == '0'){
                break;
            }

            if(index==0){
                solve(num, target, end+1, currNum, currNum, exp+newStr, res);
            }else{
                solve(num, target, end+1, total+currNum, currNum, exp+"+"+newStr, res);
                solve(num, target, end+1, total-currNum, -currNum, exp+"-"+newStr, res);
                solve(num, target, end+1, (total-prev) + (currNum * prev), currNum*prev, exp+"*"+newStr, res);
            }
        }
    }
}