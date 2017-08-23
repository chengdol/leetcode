// median
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {

        // int[] {starttime, action, endtime}, 对于action, 0 represents start, 1 represents end
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[n];

        for (String log : logs)
        {
            String[] logSeg = log.split(":");
            int[] info = new int[3];

            // id
            info[0] = Integer.parseInt(logSeg[0]);
            // action
            info[1] = logSeg[1].compareTo("start") == 0? 0 : 1;
            // timestamp, end + 1，相当于下一秒的very beginning
            info[2] = info[1] == 1? Integer.parseInt(logSeg[2]) + 1 : Integer.parseInt(logSeg[2]);

            // 若是end 标记
            if (info[1] == 1)
            {
                int[] popInfo = stack.pop();
                int acc = 0;
                // length < 3说明这时中间某一函数的生命周期时间，需要叠加起来减掉
                while (popInfo.length < 3)
                {
                    acc += popInfo[1];
                    popInfo = stack.pop();
                }
                // 找到对应的start time了
                int diff = info[2] - popInfo[2];
                res[info[0]] += diff - acc;
                // 再把当前函数当前生命周期的时间压入Stack
                stack.push(new int[]{info[0], diff});
            }
            else
            {
                stack.push(info);
            }
        }
        return res;
    }
}
