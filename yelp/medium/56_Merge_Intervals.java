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
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {

        if (intervals == null || intervals.size() <= 1) { return intervals; }

        List<Interval> res = new ArrayList<>();

        // list using Collections.sort() !
        // sort by start
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        // clever !
        for (Interval item : intervals)
        {
            if (item.start > end)
            {
                res.add(new Interval(start, end));
                start = item.start;
                end = item.end;
            }
            else
            {
                if (item.end >= end) { end = item.end; }
            }
        }
        // last one
        res.add(new Interval(start, end));

        return res;
    }
}
