// medium

// 这题很有意思
class RandomizedSet {

    Map<Integer, Integer> map;
    List<Integer> lst;
    Random random;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        lst = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) { return false; }

        // value is index of val in lst
        map.put(val, lst.size());
        lst.add(val);

        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) { return false; }

        int idx = map.get(val);
        // 不是最后一个，则需要swap
        if (idx < lst.size() - 1)
        {
            int t = lst.get(lst.size() - 1);
            lst.set(idx, t);
            // update map
            map.put(t, idx);
        }
        map.remove(val);
        lst.remove(lst.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return lst.get(random.nextInt(lst.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
