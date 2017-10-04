// medium


class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {

        // 一共有nums.length个数，那么最高freq不会超过length!
        // 如何build list array, namely generic array!居然忘了
        List<Integer>[] buckets = (List<Integer>[]) new List[nums.length + 1];

        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums)
        {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        // 这里方法很巧妙，记录了频率对应的数字
        for (Integer n : freq.keySet())
        {
            int val = freq.get(n);
            if (buckets[val] == null)
            {
                buckets[val] = new ArrayList<>();
            }
            buckets[val].add(n);
        }


        int len = k;
        List<Integer> res = new ArrayList<>();
        // 这里题目描述有问题，前k个 most frequence, 若很多个数同一freq，如何选择呢？
        // test case没有包含进去这个
        for (int i = buckets.length - 1; i >= 0 && len > 0; i--)
        {
            if (buckets[i] != null)
            {
                res.addAll(buckets[i]);
                len -= buckets[i].size();
            }

        }
        // cut down to k length
        return res.subList(0, k);
    }
}
