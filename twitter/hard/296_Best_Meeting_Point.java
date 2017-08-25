// hard

class Solution {
    public int minTotalDistance(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        List<Integer> rList = new ArrayList<>(row);
        List<Integer> cList = new ArrayList<>(col);

        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                if (grid[i][j] == 1)
                {
                    rList.add(i);
                    cList.add(j);
                }
            }
        }

        return getMin(rList) + getMin(cList);
    }

    // no idea
    private int getMin(List<Integer> lst)
    {
        int s = 0;
        int e = lst.size() - 1;
        int dist = 0;
        // must sort
        Collections.sort(lst);
        while (s < e)
        {
            dist += lst.get(e--) - lst.get(s++);
        }
        return dist;
    }
}
