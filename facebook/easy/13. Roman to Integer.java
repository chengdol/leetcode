// easy


class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        // init
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;
        int i = 0;
        char[] letr = s.toCharArray();
        while (i < letr.length)
        {
            // 到达最后一个char
            if (i == letr.length - 1)
            {
                sum += map.get(letr[i]);
                break;
            }

            if (map.get(letr[i]) >= map.get(letr[i + 1]))
            {
                sum += map.get(letr[i]);
                i++;
            }
            else
            {
                sum += map.get(letr[i + 1]) - map.get(letr[i]);
                i += 2;
            }

        }

        return sum;
    }
}
