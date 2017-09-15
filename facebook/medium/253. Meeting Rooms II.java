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
    public int minMeetingRooms(Interval[] intervals) {

        if (intervals == null || intervals.length == 0) { return 0; }

        int[] start = new int[intervals.length];
        int[] end = new int[start.length];
        // init
        for (int i = 0; i < intervals.length; i++)
        {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        // sort
        Arrays.sort(start);
        Arrays.sort(end);

        int cnt = 0;
        int endptr = 0;
        for (int i = 0; i < start.length; i++)
        {
            // 说明有meeting 需要rooms
            if (start[i] < end[endptr]) { cnt++; }
            // 说明可以使用old room
            else { endptr++; }
        }


        return cnt;
    }
}

// 还可以用PQ实现，想法和我类似，更好理解一些
