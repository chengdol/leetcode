// medium


class Solution {
    public boolean exist(char[][] board, String word) {

        char[][] b = board;
        if (b == null || b.length == 0 || b[0].length == 0) { return false; }


        for (int i = 0; i < b.length; i++)
        {
            boolean[][] visited = new boolean[b.length][b[0].length];
            for (int j = 0; j < b[0].length; j++)
            {
                if (dfs(b, i, j, visited, word, 0)) { return true; }
            }
        }

        return false;
    }

    private boolean dfs(char[][] b, int i, int j, boolean[][] v, String w, int idx)
    {
        if (b[i][j] != w.charAt(idx)) { return false; }
        if (idx == w.length() - 1 && b[i][j] == w.charAt(idx)) { return true; }

        v[i][j] = true;

        boolean res = false;
        int[][] dir = {{-1, 0},{1, 0},{0, -1},{0, 1}};
        for (int k = 0; k < dir.length; k++)
        {
            int iNext = i + dir[k][0];
            int jNext = j + dir[k][1];

            if (iNext < 0 || iNext >= b.length || jNext < 0 || jNext >= b[0].length || v[iNext][jNext]) { continue; }
            res |= dfs(b, iNext, jNext, v, w, idx + 1);
            // 找到了不用再找，没这句就超时了
            if (res) { break; }
        }

        // restore
        v[i][j] = false;
        return res;
    }
}
