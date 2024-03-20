class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int row=0;row<board.length;row++)
        {
            HashSet<Integer> set = new HashSet<Integer>();
            for(int col=0;col<board[row].length;col++)
            {
                if(board[row][col]>='1' && board[row][col]<='9')
                {
                    int curr = Character.getNumericValue(board[row][col]);
                    if(set.contains(curr))
                    {
                        return false;
                    }
                    else
                    {
                        set.add(curr);
                    }
                }
            }
        }
        for(int col=0;col<board[0].length;col++)
        {
            HashSet<Integer> set = new HashSet<Integer>();
            for(int row=0;row<board.length;row++)
            {
                if(board[row][col]>='1' && board[row][col]<='9')
                {
                    int curr = Character.getNumericValue(board[row][col]);
                    if(set.contains(curr))
                    {
                        return false;
                    }
                    else
                    {
                        set.add(curr);
                    }
                }
            }
        }
        for (int blockRow = 0; blockRow < 3; blockRow++) {
            for (int blockCol = 0; blockCol < 3; blockCol++) {
                HashSet<Integer> set = new HashSet<Integer>();
                for (int row = blockRow * 3; row < blockRow * 3 + 3; row++) {
                    for (int col = blockCol * 3; col < blockCol * 3 + 3; col++) {
                        if (board[row][col] >= '1' && board[row][col] <= '9') {
                            int curr = Character.getNumericValue(board[row][col]);
                            if (set.contains(curr)) {
                                return false;
                            } else {
                                set.add(curr);
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}