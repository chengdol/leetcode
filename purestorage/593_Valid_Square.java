// medium

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

        // inputs are all integers
        // if suqare 4 edges and 2 diagonal must be the same length, and diagonal > edge length
        long[] lens = {squareLen(p1, p2), squareLen(p2, p3), squareLen(p3, p4), squareLen(p4, p1), squareLen(p1, p3), squareLen(p2, p4)};

        // check
        // find diagonal and normal edge square length
        long diag = lens[0];
        long edge = lens[0];
        for (long len : lens)
        {
            if (len > diag) { diag = len; }
            if (len < edge) { edge = len; }
        }

        if (diag <= edge) { return false; }

        int cntDiag = 0;
        int cntEdge = 0;
        for (long len : lens)
        {
            if (len == diag) { cntDiag++; }
            else if (len == edge) { cntEdge++; }
        }

        if (cntDiag != 2 || cntEdge != 4) { return false; }

        return true;
    }

    private long squareLen(int[] a, int[] b)
    {
        return (long)(Math.pow(a[1] - b[1], 2) + Math.pow(a[0] - b[0], 2));
    }
}
