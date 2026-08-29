class Solution {
    // char[] op = {'+','-','*'};
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        solve(num, 0, target, 0, 0, res, "");
        return res; 
    }

    public void solve(String num, int index, int target, long total, long prev, List<String> res, String exp){
        if(index == num.length()){
            if(total == target){
                res.add(exp);
            }
            return;
        }

        for(int end=index;end<num.length();end++){
            String numStr = num.substring(index,end+1);

            if(numStr.length() > 1 && numStr.charAt(0) == '0'){
                break;
            }

            long currNum = Long.parseLong(numStr);

            if(index == 0){
                solve(num, end+1, target, currNum , currNum, res, numStr);
            }else{
                solve(num, end+1, target, total + currNum, currNum, res,
                 exp+"+" +numStr);

                solve(num, end+1, target, total - currNum, -currNum, res, 
                 exp+"-"+numStr);

                solve(num, end+1, target, (total - prev) + (prev * currNum),
                 prev * currNum, res, exp+"*"+numStr);
            }
                                                               
        }
    }
    }
