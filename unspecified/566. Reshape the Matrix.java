// easy

/*
In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.

You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.

The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.

If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
*/


class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) 
    {
        if (nums == null || nums.length == 0 || nums[0].length == 0)
        {
            return nums;
        }
        
        int width = nums[0].length;
        int height = nums.length;
        
        if (width * height != r * c) { return nums; }
        
        int[][] ret = new int[r][c];
        int cnt = 0;
        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++)
            {
                ret[i][j] = nums[cnt / width][cnt % width];
                cnt++;
            }
        }
        
        return ret;
    }
}