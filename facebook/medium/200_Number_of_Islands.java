// medium

I use union find method.
test cases:
["11110","11010","11000","00000"]
[]
["0","0","0","0","0","0"]
["00000"]


// 使用的是union find，全部water union在一起，island各自union在一起，最后的结果就是cnt - 1(减去water的部分)
// 比如[1,1,0,0,1,0,1,1] cnt finally = 4, islands = 4 - 1 = 3
// 遇到 island 只查看右边 和 下边一个
public class Solution {
    public int numIslands(char[][] grid)
    {
        if (grid == null || grid.length == 0) { return 0; }

        int row = grid.length;
        int col = grid[0].length;

        // last extra cell is for water union
        int[] uf = new int[row * col + 1];
        // number of components at beginning, for each union, we minus one in count
        int count = row * col + 1;
        // union find的初始化
        for (int i = 0; i < uf.length; i++) { uf[i] = i; }

        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                // if water, connect it to last cell in uf[]
                if (grid[i][j] == '0') { union(uf, i, j, row, 0, col); count--; }
                else
                {
                    // for each island, only check its down and right side if available
                    // check down side
                    if (i < row - 1 && grid[i + 1][j] != '0')
                    {
                        if (root(uf, i, j, col) != root(uf, i + 1, j, col))
                        {
                            union(uf, i, j, i + 1, j, col);
                            count--;
                        }
                    }
                    // check right side
                    if (j < col - 1 && grid[i][j + 1] != '0')
                    {
                         if (root(uf, i, j, col) != root(uf, i, j + 1, col))
                        {
                            union(uf, i, j, i, j + 1, col);
                            count--;
                        }
                    }
                }
            }
        }
        // exclude water part
        return count - 1;
    }

    // return root
    private int root(int[] uf, int i, int j, int col)
    {
        int id = i * col + j;
        while (uf[id] != id)
        {
            // compress path
            uf[id] = uf[uf[id]];
            id = uf[id];
        }
        return id;
    }

    // union these two
    // 这里我没有用weighted balance
    private void union(int[] uf, int i1, int j1, int i2, int j2, int col)
    {
        int r1 = root(uf, i1, j1, col);
        int r2 = root(uf, i2, j2, col);
        uf[r1] = r2;
    }
}


// ===============================================================
// discussion 中的方法，更容易理解
class Solution {
    public int numIslands(char[][] grid) {

        // 这个方法改变了input的值
        if (grid == null || grid.length == 0 || grid[0].length == 0) { return 0; }

        int cnt = 0;
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if (grid[i][j] == '1')
                {
                    dfs(grid, i, j);
                    cnt++;
                }
            }
        }

        return cnt;

    }

    private void dfs(char[][] g, int i, int j)
    {
        if (i < 0 || j < 0 || i >= g.length || j >= g[0].length || g[i][j] == '0') { return; }
        // visited mark
        g[i][j] = '0';
        // 4 directions
        dfs(g, i + 1, j);
        dfs(g, i - 1, j);
        dfs(g, i, j - 1);
        dfs(g, i, j + 1);
    }
}
