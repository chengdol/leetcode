// This solution is so clever that I think so hard to understand it.
// height counts the number of successive '1's above (plus the current one). The value of left & right means the boundaries of the rectangle which contains the current point with a height of value height.

class Solution {
    public int maximalRectangle(char[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) { return 0; }
        int row = matrix.length;
        int col = matrix[0].length;
        char[][] m = matrix;

        // 3 array to record left , right, height of each cell in current row
        int[] left = new int[col];
        int[] right = new int[col];
        int [] height = new int[col];
        // init
        Arrays.fill(left, 0); // left value default is 0
        Arrays.fill(right, col); // right value default is column number, can't be col - 1
        Arrays.fill(height, 0); // height value default is 0

        // 对当前的cell，计算其最大高度能形成的矩形的面积，left,right就是这个cell
        // 的左右边界
        // 下一个row的数据会用到上一次的，依次迭代，每次外层循环计算以当前这行为底
        // 的最大矩形面积
        int res = 0;
        for (int i = 0; i < row; i++)
        {
            int curLeft = 0;
            int curRight = col;
            // calc current row cell's height, left boundary
            for (int j = 0; j < col; j++)
            {
                if (m[i][j] == '1')
                {
                    // update height, left boundary for current
                    height[j]++;
                    left[j] = Math.max(left[j], curLeft);
                }
                else
                {
                    height[j] = 0;
                    left[j] = 0;
                    curLeft = j + 1;
                }
            }
            // current row cell's right boundary
            for (int j = col - 1; j >= 0; j--)
            {
                if (m[i][j] == '1') { right[j] = Math.min(right[j], curRight); }
                else { right[j] = col; curRight = j; }
            }

            for (int j = 0; j < col; j++)
            {
                res = Math.max(res, (right[j] - left[j]) * height[j]);
            }
        }
        return res;
    }
}
