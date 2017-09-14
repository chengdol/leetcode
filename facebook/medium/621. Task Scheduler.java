// medium


public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        // record the freq for each character
        for (char c : tasks)
        {
            freq[c - 'A']++;
        }

        // 最高频率被排序到最后了，前面都是0，即freq[25]
        Arrays.sort(freq);

        // 下面找次高频率的索引
        int i = 25;
        while (i >= 0 && freq[i] == freq[25]) { i--; }

        // 这个公式怎么回事
        // freq[25] - 1，预留一个最高频率的char，最后加在末尾，我先保证完整的task chunk，就是下面的前2个ABXX|ABXX chunk
        // n + 1, 因为相同任务之间插入n个，这样计算: 比如下面的ABXX
        // 25 - i, 就是最高频率的char省下来的，加在末尾，比如下面的A
        // [A,A,A,B,B] 3
        // ABXX|ABXX|A
        int res = (freq[25] - 1) * (n + 1) + 25 - i;

        //有时候n太小了，task太多了，间隔不够塞，所以取最大值
        return Math.max(tasks.length, res);
    }
}
