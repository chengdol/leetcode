// eays

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n)
    {
        int cnt = 0;
        char[] tmp = new char[4];

        int i = 0;
        while (true)
        {
            int k = read4(tmp);
            int j = 0;
            if (cnt + k <= n)
            {
                while (j < k) { buf[i++] = tmp[j++]; }
                cnt += k;
                // read over
                if (k < 4) { return cnt; }
            }
            else
            {
                while (j < (n - cnt)) { buf[i++] = tmp[j++]; }
                break;
            }
        }

        return n;
    }
}
