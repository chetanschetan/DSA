class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        solve(n, 0, "", result);
        return result;
    }

    public void solve(int n, int openCount, String res, List<String> result){
        if(res.length() == n*2){
            result.add(res);
            return;
        }

        if(openCount < n){
            solve(n, openCount+1, res+"(", result);
        }

        if(res.length() - openCount < n && openCount > res.length() - openCount){
            solve(n, openCount, res+")", result);
        }

    }
}