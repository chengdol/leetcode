// medium



/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {

        List<Interval> res =  new ArrayList<>();
        Queue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);
        // init
        for (Interval n : intervals) { pq.offer(n); }

        while (!pq.isEmpty())
        {
            Interval n = pq.poll();
            // merge
            while (!pq.isEmpty() && pq.peek().start <= n.end)
            {
                n.end = Math.max(pq.poll().end, n.end);
            }

            res.add(n);
        }

        return res;
    }
}
