// easy

class Solution {
    public int[][] imageSmoother(int[][] M) {

        if (M == null || M.length == 0 || M[0].length == 0) { return M; }

        int row = M.length;
        int col = M[0].length;

        // offset of srounding cell
        int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int[][] res = new int[row][col];

        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                double sum = 0.0;
                int cnt = 0;

                for (int k = 0; k < dir.length; k++)
                {
                    int r = i + dir[k][0];
                    int c = j + dir[k][1];

                    if (r < 0 || r >= row || c < 0 || c >= col) { continue; }

                    cnt++;
                    sum += M[r][c];
                }

                res[i][j] = (int)(Math.floor(sum / cnt));
            }
        }

        return res;
    }
}
