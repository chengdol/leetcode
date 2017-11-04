// medium

class Solution {

    public boolean exist(char[][] board, String word)
    {
        if (board == null || board.length == 0 || board[0].length == 0) { return false; }
        if (word == null || word.isEmpty()) { return true; }

        int h = board.length;
        int w = board[0].length;
        boolean[][] visited = new boolean[h][w];

        for (int i = 0; i < h; i++)
        {
            for (int j = 0; j < w; j++)
            {
                if (find(board, word, i, j, 0, visited)) { return true; }
            }
        }

        return false;
    }

    private boolean find(char[][] b, String word, int i, int j, int idx, boolean[][] visited)
    {
        if (word.charAt(idx) != b[i][j]) { return false; }
        if (word.length() - 1 == idx) { return true; }


        visited[i][j] = true;
        int[][] dir = {{0, -1},{0, 1},{-1, 0},{1, 0}};

        boolean res = false;
        for (int k = 0; k < dir.length; k++)
        {
            int iNext = i + dir[k][0];
            int jNext = j + dir[k][1];

            if (iNext < 0 || iNext >= b.length || jNext < 0 || jNext >= b[0].length || visited[iNext][jNext]) { continue; }

            res |= find(b, word, iNext, jNext, idx + 1, visited);
            // 必须要这个，否侧超时！！
            if (res) { break; }
        }

        visited[i][j] = false;
        return res;
    }
}
