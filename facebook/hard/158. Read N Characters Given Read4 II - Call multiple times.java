// hard

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {

    private char[] tmpBuf = new char[4];
    private int tmpBufSize = 0;
    private int tmpBufPtr = 0;
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {

        int ptr = 0;
        while (ptr < n)
        {
            if (tmpBufPtr == 0)
            {
                tmpBufSize = read4(tmpBuf);
            }

            while (ptr < n && tmpBufPtr < tmpBufSize) { buf[ptr++] = tmpBuf[tmpBufPtr++]; }

            // clean
            if (tmpBufSize == tmpBufPtr) { tmpBufPtr = 0; }

            if (tmpBufSize < 4) { break; }
        }


        return ptr;
    }
}
