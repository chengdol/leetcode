// easy


class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] items = str.split(" ");
        // length not math
        if (items.length != pattern.length()) { return false; }

        // build map to pair pattern and string
        Map<Character, String> CharMapString = new HashMap<>();
        Map<String, Character> StringMapChar = new HashMap<>();

        int idx = 0;
        for (char c : pattern.toCharArray())
        {
            if (CharMapString.containsKey(c))
            {
                if (!items[idx].equals(CharMapString.get(c))) { return false; }
            }
            else
            {
                if (StringMapChar.containsKey(items[idx])) { return false; }

                CharMapString.put(c, items[idx]);
                StringMapChar.put(items[idx], c);
            }
            idx++;
        }


        return true;

    }
}
