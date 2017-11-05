// medium

没思路

public class Solution {
    public int hIndex(int[] citations) {

        int[] c= citations;
        if (c == null || c.length == 0) { return 0; }

        int[] arr = new int[c.length + 1];

        // reassign
        // arr的index代表被引用的次数
        // arr[i]就是该引用次数下的文章数
        // 对于超过总文章数次数的引用，加在最后一项里面
        for (int i = 0; i < c.length; i++)
        {
            if (c[i] >= c.length) { arr[c.length]++; }
            else
            {
                arr[c[i]]++;
            }
        }

        int articleNum = 0;
        int res = 0;
        // 这里要想明白，articleNum，先叠加引用次数多的文章的个数
        // 当文章的个数 大于或等于 引用次数的时候，我们就可知
        // 至少有这么多文章，被引用了这么多次了
        for (int i = c.length; i >= 0; i--)
        {
            articleNum += arr[i];
            if (articleNum >= i) { res = i; break; }
        }

        return res;
    }
}
