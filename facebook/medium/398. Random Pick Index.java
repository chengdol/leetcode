// medium

// not use too much extra space
// but use map is still acceptable
class Solution {

    // O(n) space
    Map<Integer, List<Integer>> map;

    public Solution(int[] nums) {
        map = new HashMap<>();

        for (int i = 0; i < nums.length; i++)
        {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
    }

    public int pick(int target) {

        List<Integer> candidates = map.get(target);
        return candidates.get((int)(Math.random() * candidates.size()));
    }
}

// O(1) extra memory but O(n) search
class Solution {

    private int[] nums;
    private Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    public int pick(int target) {

        int res = -1;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == target)
            {
                // 这里很关键！
                if (random.nextInt(++cnt) == 0)
                {
                    res = i;
                }
            }
        }

        return res;
    }
}
