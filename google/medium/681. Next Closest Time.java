// medium

/*
Given a time represented in the format "HH:MM", form the next closest time by
reusing the current digits. There is no limit on how many times a digit can
be reused.

You may assume the given input string is always valid. For example, "01:34",
"12:09" are all valid. "1:34", "12:9" are all invalid.
*/

class Solution {
    public String nextClosestTime(String time)
    {
        int[] digits = new int[4];
        // init
        // 这里特别注意char 0 - '0' 才是0
        digits[0] = time.charAt(0) - '0';
        digits[1] = time.charAt(1) - '0';
        digits[2] = time.charAt(3) - '0';
        digits[3] = time.charAt(4) - '0';

        Set<String> set = new HashSet<>();
        // 4 level nested for loop
        // total 4*4*4*4 = 256 possibilities
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                for (int k = 0; k < 4; k++)
                {
                    for (int l = 0; l < 4; l++)
                    {
                        String tmp = "" + digits[i] + digits[j] + ":" + digits[k] + digits[l];

                        if (isValidTime(tmp))
                        {
                            // remove duplicates
                            set.add(tmp);
                        }
                    }
                }
            }
        }
        List<String> collection = new ArrayList<>(set);
        // sort items
        Collections.sort(collection);
        // find input index
        int idx = collection.indexOf(time);
        return idx == collection.size() - 1? collection.get(0) : collection.get(idx + 1);
    }

    private boolean isValidTime(String time)
    {
        // 这里注意比较的是char!
        if (time.charAt(0) > '2') { return false; }
        if (time.charAt(0) == '2' && time.charAt(1) > '3') { return false; }
        if (time.charAt(3) > '5') { return false; }

        return true;
    }
}
