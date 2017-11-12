// medium

/*
Given a 01 matrix M, find the longest line of consecutive one in the matrix.
 The line could be horizontal, vertical, diagonal or anti-diagonal.

 Input:
 [[0,1,1,0],
  [0,1,1,0],
  [0,0,0,1]]
 Output: 3
*/

// 非DP
 class Solution {

     // 4 directions
     private final int[][] dir = {{1, 0},{0, 1},{1, 1},{-1, 1}};

     public int longestLine(int[][] M)
     {
         if (M == null) { return 0; }
         // result
         int res = 0;
         for (int i = 0; i < M.length; i++)
         {
             for (int j = 0; j < M[0].length; j++)
             {
                 // meet 1, start explore
                 if (M[i][j] == 1)
                 {
                     // 这种方法就会重复走一条path很多遍
                     res = Math.max(res, explorePath(M, i, j));
                 }
             }
         }
         return res;
     }


     private int explorePath(int[][] M, int i, int j)
     {
         int curRes = 1;
         int len = 1;

         for (int k = 0; k < dir.length; k++)
         {
             int iNext = i + dir[k][0];
             int jNext = j + dir[k][1];
             while (isValid(M, iNext, jNext) && M[iNext][jNext] == 1)
             {
                 len++;
                 iNext = iNext + dir[k][0];
                 jNext = jNext + dir[k][1];
             }
             curRes = Math.max(curRes, len);
             len = 1;
         }

         return curRes;
     }

     private boolean isValid(int[][] M, int i, int j)
     {
         if (i < 0 || i >= M.length || j < 0 || j >= M[0].length) { return false; }
         return true;
     }
 }
