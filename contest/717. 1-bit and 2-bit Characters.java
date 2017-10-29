// easy


// 根据规律，如果要匹配，必须怎么走
class Solution {
    public boolean isOneBitCharacter(int[] bits)
    {
        // only zero or sceond last is 0
        if (bits.length == 1 || bits[bits.length - 2] == 0) { return true; }

        int i = 0;
        boolean res = false;
        while (i < bits.length)
        {
            if (bits[i] == 1)
            {
                i += 2;
                if (i >= bits.length) { break; }
            }
            else
            {
                if (i == bits.length - 1) { res = true; break; }
                i++;
            }
        }

        return res;
    }
}
