class Solution {
    int[] rowDir = {-1,1,0,0};
    int[] colDir = {0,0,-1,1};

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean vis[][] = new boolean[row][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(solve(board, i, j, word, 0, vis)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean solve(char[][] board, int row, int col, String word, int index, boolean vis[][]){
        if(index == word.length()){
            return true;
        }
        if(board[row][col] != word.charAt(index)) return false;
        // to check if current character is last character of word
        if(index == word.length()-1){
            return true;
        }

        vis[row][col] = true;

        for(int i=0;i<4;i++){
            int newRow = row + rowDir[i];
            int newCol = col + colDir[i];

            if(newRow>=0 && newRow<board.length && newCol>=0 && newCol<board[0].length && vis[newRow][newCol] == false && index+1 < word.length()
            && board[newRow][newCol] == word.charAt(index+1)){
                if(solve(board, newRow, newCol, word, index+1, vis)){
                    return true;
                }
            }
        }
        vis[row][col] = false;
        return false;
    }
}