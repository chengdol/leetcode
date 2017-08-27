// easy

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {

        Map<String, Integer> map = new HashMap<>();

        // map string and index
        for (int i = 0; i < list1.length; i++)
        {
            map.put(list1[i], i);
        }

        int minSum = Integer.MAX_VALUE;
        List<String> res = new ArrayList<>();

        for (int i = 0; i < list2.length; i++)
        {
            // find common interest
            if (map.containsKey(list2[i]))
            {
                int curSum = map.get(list2[i]) + i;
                // update result list
                if (minSum > curSum)
                {
                    minSum = curSum;
                    // here also can new ArrayList<>();

                    res.clear();
                    res.add(list2[i]);
                }
                // append new one
                else if (minSum == curSum)
                {
                    res.add(list2[i]);
                }
            }
        }

        // list to array
        return res.toArray(new String[0]);

    }
}
