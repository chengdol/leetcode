// medium


// union find or DFS can solve it

class Solution {
    public int findCircleNum(int[][] M)
    {
        // square matrix
        int[] uf = new int[M.length];
        // init
        for (int i = 0; i < uf.length; i++)
        {
            uf[i] = i;
        }

        int cnt = uf.length;
        for (int i = 0; i < M.length; i++)
        {
            // skip i == j and j < i part sicne symmetic
            for (int j = i + 1; j < M.length; j++)
            {
                if (M[i][j] == 1)
                {
                    int rootI = findRoot(uf, i);
                    int rootJ = findRoot(uf, j);

                    // union
                    if (rootI != rootJ)
                    {
                        cnt--;
                        uf[rootI] = rootJ;
                    }

                }
            }
        }

        return cnt;
    }

    private int findRoot(int[] uf, int i)
    {
        while (i != uf[i])
        {
            // path compression
            uf[i] = uf[uf[i]];
            i = uf[i];
        }
        return i;
    }
}
