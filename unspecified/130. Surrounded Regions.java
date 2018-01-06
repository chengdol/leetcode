// medium


/*
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

题目没说清楚，surround是指4个方向，不含对角线

*/


class Solution {
    public void solve(char[][] board) 
    {
        char[][] b = board;
        if (b == null || b.length == 0 || b[0].length == 0) { return; }
        int width = board[0].length;
        int height = board.length;
        
        // search 4 borders, convert all 'o' with its neighbor 'o' to 'T'
        for (int i = 0; i < width; i++)
        {
            if (b[0][i] == 'O')
            {
                convert(b, 0, i, 'T');
            }
            if (b[height - 1][i] == 'O')
            {
                convert(b, height - 1, i, 'T');
            }
        }
        
        for (int j = 0; j < height; j++)
        {
            if (b[j][0] == 'O')
            {
                convert(b, j, 0, 'T');
            }
            if (b[j][width - 1] == 'O')
            {
                convert(b, j, width - 1, 'T');
            }
        }
        // convert all rest 'O' to 'X'
        // convert 'T' to 'O'
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                if (b[i][j] == 'O')
                {
                    b[i][j] = 'X';
                }
                // put after above code snippet
                if (b[i][j] == 'T')
                {
                    b[i][j] = 'O';
                }
            }
        }
    }
    
    private void convert(char[][] b, int i, int j, char c)
    {
        int w = b[0].length;
        int h = b.length;
        
        if (i < 0 || i >= h || j < 0 || j >= w || b[i][j] != 'O') { return; }
        
        b[i][j] = c;
        // 4 directions
        convert(b, i - 1, j, c);
        convert(b, i + 1, j, c);
        convert(b, i, j - 1, c);
        convert(b, i, j + 1, c);
    }
}