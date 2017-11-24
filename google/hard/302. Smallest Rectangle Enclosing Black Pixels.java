// hard

/*
An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.

For example, given the following image:

[
  "0010",
  "0110",
  "0100"
]
and x = 0, y = 2,
Return 6.
*/
//比较简单的dfs，记录4个方向即可
class Solution {
    
    private int left = Integer.MAX_VALUE;
    private int right = Integer.MIN_VALUE;
    private int up = Integer.MAX_VALUE;
    private int down = Integer.MIN_VALUE;
    
    public int minArea(char[][] image, int x, int y) 
    {
        if (image == null || image.length == 0 || image[0].length == 0) { return 0; }
        
        boolean[][] visited = new boolean[image.length][image[0].length];
        dfs(image, x, y, visited);
        return (right - left + 1) * (down - up + 1);
    }
    
    private void dfs(char[][] image, int i, int j, boolean[][] visited)
    {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length)
        {
            return;
        }
        if (visited[i][j] || image[i][j] == '0')
        {
            return;
        }
        
        visited[i][j] = true;
        // update 4 directions
        left = Math.min(left, i);
        right = Math.max(right, i);
        up = Math.min(up, j);
        down = Math.max(down, j);
        
        // go 4 directions
        dfs(image, i - 1, j, visited);
        dfs(image, i + 1, j, visited);
        dfs(image, i, j - 1, visited);
        dfs(image, i, j + 1, visited);
    }
}