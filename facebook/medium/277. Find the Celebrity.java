// medium



// only one celebrity or none
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {

        int candidate = 0;
        // first loop pick celebrity candidate
        for (int i = 1; i < n; i++)
        {
            // 因为只有一个celebrity或没有，根据rules,最后得到的一定是目标
            if (knows(candidate, i)) { candidate = i; }
            // also can be
            // if (!knows(i, candidate)) { candidate = i; }
        }
        // second loop
        for (int i = 0; i < n; i++)
        {
            if (i < candidate && (knows(candidate, i) || !knows(i, candidate))) { return -1; }
            // 前面已经检查过knows(candidate, i)了，这里可以只检查剩余的
            if (i > candidate && !knows(i, candidate)) { return -1; }
        }

        return candidate;
    }
}
