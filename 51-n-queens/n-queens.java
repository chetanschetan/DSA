class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        solve(board, 0, n, res);
        return res;
    }

    public void solve(char[][] board, int row, int n, List<List<String>> res){
        if(row == n){
            List<String> curr = new ArrayList<>();
            for(int i=0;i<n;i++){
                curr.add(new String(board[i]));
            }
            res.add(curr);
            return;
        }


        for(int col=0;col<n;col++){
            if(isSafe(board, row, col, n)){
                board[row][col] = 'Q';
                solve(board, row+1, n, res);
                board[row][col] = '.';
            }
        }
    }

    public boolean isSafe(char[][] board,int row,int col, int n){
        for(int i=row;i>=0;i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        for(int i=row,j=col; i>=0 && j>=0 ; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        for(int i=row,j=col; i>=0 && j<n ; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        } 
        return true;
    }
}