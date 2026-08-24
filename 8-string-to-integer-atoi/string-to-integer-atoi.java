class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;
        int startIndex = 0;
        int sign = 1;

        if(s.charAt(0) == '-'){
            sign = -1;
            startIndex = 1;
        }else if(s.charAt(0) == '+'){
            startIndex = 1;
        }

        long finalAns = solve(s, startIndex, 0, sign);
        return (int) finalAns;
    }

    public long solve(String s, int i, long res, int sign){
        if(i>s.length()-1 || !Character.isDigit(s.charAt(i))){
            return res * sign;
        }

        int digit = s.charAt(i) - '0';

        if(res > (Integer.MAX_VALUE - digit)/10){
            return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        res = res * 10 + digit;
        return solve(s, i+1, res, sign);
    }
}