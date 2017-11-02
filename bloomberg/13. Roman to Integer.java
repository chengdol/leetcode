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
        char[] items = s.toCharArray();
        while (i < items.length - 1)
        {
            int val1 = map.get(items[i]);
            int val2 = map.get(items[i + 1]);

            if (val1 >= val2)
            {
                sum += val1;
                i++;
            }
            else
            {
                sum += val2 - val1;
                i += 2;
            }
        }
        if (i == items.length - 1) { sum += map.get(items[i]); }


        return sum;
    }
}
