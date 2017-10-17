// medium

// 方法很巧妙
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4)
    {
        // all 6 sides
        List<Integer> sides = Arrays.asList(sideLen(p1, p2), sideLen(p1, p3), sideLen(p1, p4)
                                           , sideLen(p2, p3), sideLen(p4, p3), sideLen(p2, p4));
        // if sqare, 4 sides equal and 2 sides are longest (diagnoal)
        Set<Integer> set = new HashSet<>(sides);

        // no 0 length side and remain 2 sides
        return set.size() == 2 && !set.contains(0);
    }

    private int sideLen(int[] a, int[] b)
    {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
}
