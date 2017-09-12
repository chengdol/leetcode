// medium

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) { return res; }

        int height = matrix.length;
        int width = matrix[0].length;

        // right, down, left, up
        // 改这个顺序就可以变成逆时针遍历了
        int[][] dir = {{0, 1},{1, 0},{0, -1},{-1, 0}};
        // 水平 和 垂直 方向的走位范围
        int[] range = {width, height - 1};
        int pos = 0; // index of dir[][], also used to local range entry
        // start position
        int r = 0;
        int c = -1;

        // 水平 和 垂直 方向交替变幻
        while (range[pos % 2] != 0)
        {
            for (int i = 0; i < range[pos % 2]; i++)
            {
                r += dir[pos][0];
                c += dir[pos][1];

                res.add(matrix[r][c]);
            }

            // update range value
            range[pos % 2]--;
            // update direction
            pos = (pos + 1) % 4;
        }

        return res;
    }
}
