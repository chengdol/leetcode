// hard

// You may assume that the points are distinct
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


// 主要是记住公式，如何通过2点找正方形的另外2点:
// 已知x1,y1  x2,y2
// x3 = x1 + (y2 - y1); y3 = y1 - (x2 - x1)
// x4 = x2 + (y2 - y1); y4 = y2 - (x2 - x1)
// 这只是一边的，还有一边，交换一下x1,y1 x2,y2的位置就可以了
class Solution {

    public static int squareNum(int[] x, int[] y)
    {
        Set<Integer> xSet = new HashSet<>();
        Set<Integer> ySet = new HashSet<>();

        // init
        for (int i = 0; i < x.length; i++)
        {
            xSet.add(x[i]);
            ySet.add(y[i]);
        }

        int squareCnt = 0;

        for (int i = 0; i < x.length; i++)
        {
            for (int j = i + 1; j < x.length; j++)
            {
                // check one side
                int x1 = x[i] + (y[j] - y[i]); int y1 = y[i] - (x[j] - x[i]);
                int x2 = x[j] + (y[j] - y[i]); int y2 = y[j] - (x[j] - x[i]);
                // check another side
                int x3 = x[j] + (y[i] - y[j]); int y3 = y[j] - (x[i] - x[j]);
                int x4 = x[i] + (y[i] - y[j]); int y4 = y[i] - (x[i] - x[j]);

                if (xSet.contains(x1) && xSet.contains(x2) && ySet.contains(y1) && ySet.contains(y2))
                {
                    squareCnt++;
                }

                if (xSet.contains(x3) && xSet.contains(x4) && ySet.contains(y3) && ySet.contains(y4))
                {
                    squareCnt++;
                }

//              System.out.println("x1= " + x1 + "; y1= " + y1);
//              System.out.println("x2= " + x2 + "; y2= " + y2);
//              System.out.println();
//              System.out.println("x3= " + x3 + "; y3= " + y3);
//              System.out.println("x4= " + x4 + "; y3= " + y4);
//              System.out.println("=========================");

            }
        }
        return squareCnt / 4;
    }

    public static void main(String[] args)
    {
        int[] x = {0 ,0 ,1 ,1};
        int[] y = {0, 1, 0, 1};
        int[] x1 = {0,0,1,1,2,2};
        int[] y1 = {0,1,0,1,0,1};
        System.out.println(squareNum(x, y));
    }
}
