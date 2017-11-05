// easy


// contest problem，我当时弄复杂了
class Solution {
    public int compress(char[] chars)
    {
        int lo = 0;
        int cnt = 0;
        for (int i = 0; i < chars.length; i++)
        {
            // 首先cnt + 1
            cnt++;
            // 这里处理了边界条件
            if (i == chars.length - 1 || chars[i] != chars[i + 1])
            {
                chars[lo++] = chars[i];
                // cnt = 1不管
                if (cnt != 1)
                {
                    String num = String.valueOf(cnt);
                    for (char n : num.toCharArray()) { chars[lo++] = n; }
                }
                cnt = 0;
            }
        }

        return lo;
    }
}
