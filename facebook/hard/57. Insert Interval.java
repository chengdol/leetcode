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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        List<Interval> res = new ArrayList<>();
        // add all intervals before newInterval
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start)
        {
            res.add(intervals.get(i++));
        }
        // merge overlapping
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end)
        {
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }
        // add newInterval
        res.add(newInterval);
        // add rest
        while (i < intervals.size()) { res.add(intervals.get(i++)); }

        return res;
    }
}
