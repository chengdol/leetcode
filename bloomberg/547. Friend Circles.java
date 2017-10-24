// medium


// union find or DFS can solve it

class Solution {
    public int findCircleNum(int[][] M)
    {
        if (M == null || M.length == 0 || M[0].length == 0) { return 0; }
        // I use union find
        int num = M.length;
        int[] uf = new int[num];
        // init
        for (int i = 0; i < uf.length; i++) { uf[i] = i; }

        for (int i = 0; i < M.length; i++)
        {
            for (int j = 0; j < M[0].length; j++)
            {
                if (i != j && M[i][j] == 1)
                {
                    int pi = findRoot(uf, i);
                    int pj = findRoot(uf, j);

                    if (pi != pj)
                    {
                        num--;
                        // union
                        uf[pi] = pj;
                    }
                }
            }
        }

        return num;
    }

    private int findRoot(int[] uf, int i)
    {
        while (uf[i] != i)
        {
            // path compression
            uf[i] = uf[uf[i]];
            i = uf[i];
        }
        return i;
    }
}
