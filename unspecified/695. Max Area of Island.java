// easy

/*
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's 
(representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, 
the maximum area is 0.)
*/

// basic DFS problem
class Solution {
    public int maxAreaOfIsland(int[][] grid) 
    {
        int max = 0;
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if (grid[i][j] == 1 && !visited[i][j])
                {
                    max = Math.max(search(grid, i, j, visited), max);
                }
            }
        }
        
        return max;
    }
    
    private int search(int[][] g, int i, int j, boolean[][] v)
    {
        if (i < 0 || i >= g.length || j < 0 || j >= g[0].length || g[i][j] == 0 || v[i][j])
        {
            return 0;
        }
        
        v[i][j] = true;
        int up = search(g, i - 1, j, v);
        int down = search(g, i + 1, j, v);
        int left = search(g, i, j - 1, v);
        int right = search(g, i, j + 1, v);
        
        return 1 + up + down + left + right;
    }
}