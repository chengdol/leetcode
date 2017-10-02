// hard


class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {


        List<Integer> res = new ArrayList<>();
        int[] uf = new int[m * n];
        // 这个map其实可以不要
        int[] map = new int[m * n];

        // init
        for (int i = 0; i < uf.length; i++)
        {
            uf[i] = i;
        }

        int numOfLand = 0;
        for (int i = 0; i < positions.length; i++)
        {
            int unionNum = 0;
            // 查看相邻的4个方向
            unionNum += formLand(uf, map, m, n, positions[i]);

            numOfLand++;
            // union 多少次，就减去多少
            numOfLand -= unionNum;

            res.add(numOfLand);
        }

        return res;
    }


    private int formLand(int[] uf, int[] map, int m, int n, int[] pos)
    {
        int cnt = 0;

        int[][] dir = {{-1, 0},{1, 0},{0, -1},{0, 1}};
        for (int k = 0; k < dir.length; k++)
        {
            int cur = pos[0] * n + pos[1];
            map[cur] = 1;

            int r = pos[0] + dir[k][0];
            int c = pos[1] + dir[k][1];
            // convert
            int neig = r * n + c;
            // skip invalid cell
            if (r < 0 || r >= m || c < 0 || c >= n || map[neig] == 0) { continue; }
            // 开始union 如果root不同的话
            cnt += union(uf, neig, cur);
        }

        return cnt;
    }

    private int union(int[] uf, int idx1, int idx2)
    {
        int p1 = findRoot(uf, idx1);
        int p2 = findRoot(uf, idx2);

        if (p1 == p2) { return 0; }
        // union
        uf[p1] = p2;
        return 1;
    }

    private int findRoot(int[] uf, int idx)
    {
        while (uf[idx] != idx)
        {
            // path compression
            uf[idx] = uf[uf[idx]];
            idx = uf[idx];
        }
        return idx;
    }
}
