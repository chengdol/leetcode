// hard


// 这题有类似的模板
class Solution {
    public String minWindow(String s, String t)
    {
        // 当时这里错了,我当时用的char[] freq，但char是2个字节 0~65535不能是负数！！
        int[] freq = new int[256];
        // init
        for (char c : t.toCharArray()) { freq[c]++; }

        // two pointers
        // begin <= end
        int begin = 0;
        int end = 0;
        int cnt = t.length();

        // valid substring length
        int len = Integer.MAX_VALUE;
        // start index of valid string
        int head = 0;

        while (end < s.length())
        {
            // end 在if 之后已经指向了下一个，所以长度就是end - begin
            // 注意，不管是否条件满足，都进行了++/--操作
            if (freq[s.charAt(end++)]-- > 0) { cnt--; }

            // find a valid substring
            while (cnt == 0)
            {
                // update len and head
                if (end - begin < len)
                {
                    len = end - begin;
                    head = begin;
                }
                // move begin pointer
                // 因为当前找到的不一定是最短的, left pointer还没有处理
                if (freq[s.charAt(begin++)]++ == 0) { cnt++; }
            }
        }
        return len == Integer.MAX_VALUE? "" : s.substring(head, head + len);
    }
}
