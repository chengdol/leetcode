// medium


// yelp时做过一遍，又忘了
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k)
    {
        // buckets, idx is frequence
        List<Integer>[] buckets = (List<Integer>[]) new List[nums.length + 1];
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums)
        {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        // put at bucket
        for (int n : freq.keySet())
        {
            int f = freq.get(n);
            if (buckets[f] == null) { buckets[f] = new ArrayList<Integer>(); }
            buckets[f].add(n);
        }

        List<Integer> res = new ArrayList<>();
        int len = k;
        // from high to low freq
        for (int i = buckets.length - 1; i >= 0 && len > 0; i--)
        {
            if (buckets[i] != null)
            {
                res.addAll(buckets[i]);
                len -= buckets[i].size();
            }
        }

        return res.subList(0, k);
    }
}
