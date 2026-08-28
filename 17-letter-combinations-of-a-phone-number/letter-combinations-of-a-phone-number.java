class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        solve(digits, 0, "", result, map);
        return result;
    }

    public void solve(String digits, int index, String res, List<String> result, Map<Character, String> map){
        if(index == digits.length()){
            result.add(res);
            return;
        }

        String letters = map.get(digits.charAt(index));

        for(int i=0;i<letters.length();i++){
            solve(digits, index+1, res + letters.charAt(i), result, map);
        }
    }
}