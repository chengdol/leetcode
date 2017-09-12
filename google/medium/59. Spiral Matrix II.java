// medium

// the same as lc54
class Solution {
    public int[][] generateMatrix(int n) {

        if (n < 0) { return null; }
        int[][] res = new int[n][n];

        // right down left up
        int[][] dir = {{0, 1},{1, 0},{0, -1},{-1, 0}};
        int[] range = {n, n - 1};
        // index of dir[][]
        int pos = 0;
        // start position
        int r = 0;
        int c = -1;

        int val = 1;
        while (range[pos%2] != 0)
        {
            for (int i = 0; i < range[pos%2]; i++)
            {
                r += dir[pos][0];
                c += dir[pos][1];

                res[r][c] = val++;
            }

            // update range
            range[pos%2]--;
            // update pos
            pos = (pos+1) % 4;
        }
        return res;
    }
}
