// medium



// no use hashtable
class Solution {
    public int[][] multiply(int[][] A, int[][] B) {

        // without hashtbale
        int aRow = A.length;
        int aCol = A[0].length;
        int bCol = B[0].length;

        int[][] res = new int[aRow][bCol];
        for (int i = 0; i < aRow; i++)
        {
            for (int j = 0; j < aCol; j++)
            {
                if (A[i][j] != 0)
                {
                    // 这里和矩阵乘法的计算顺序不一样，但效果一样
                    for (int k = 0; k < bCol; k++)
                    {
                        if (B[j][k] != 0)
                        {
                            res[i][k] += A[i][j] * B[j][k];
                        }
                    }
                }
            }
        }
        return res;
    }
}

// use hashtable, recommended
class Solution {
    public int[][] multiply(int[][] A, int[][] B) {

        // using hashtable
        int aRow = A.length;
        int aCol = A[0].length;
        int bCol = B[0].length;

        int[][] res = new int[aRow][bCol];
        // key 记录B中的行， value 记录该行中非0的元素 及其 列索引
        Map<Integer, Map<Integer, Integer>> mapB = new HashMap<>();
        for (int i = 0; i < aCol; i++)
        {
            mapB.put(i, new HashMap<>());
            for (int j = 0; j < bCol; j++)
            {
                if (B[i][j] != 0) { mapB.get(i).put(j, B[i][j]); }
            }
        }

        // 利用mapB进行计算，计算顺序和正常的不一样，但最后结果相同
        // 每次计算的是res[][]的一部分，最后叠加完才是最终结果
        for (int i = 0; i < aRow; i++)
        {
            for (int j = 0; j < aCol; j++)
            {
                if (A[i][j] != 0)
                {
                    // 找到B中对应的行
                    for (Integer k : mapB.get(j).keySet())
                    {
                        // B中对应的行中对应的列非0元素
                        res[i][k] += A[i][j] * mapB.get(j).get(k);
                    }
                }
            }
        }

        return res;
    }
}
