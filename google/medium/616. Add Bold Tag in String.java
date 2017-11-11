// medium


/*
Given a string s and a list of strings dict, you need to add a closed pair of
bold tag <b> and </b> to wrap the substrings in s that exist in dict. If two
such substrings overlap, you need to wrap them together by only one pair of
closed bold tag. Also, if two substrings wrapped by bold tags are consecutive,
 you need to combine them.


 Input:
 s = "abcxyz123"
 dict = ["abc","123"]
 Output:
 "<b>abc</b>xyz<b>123</b>"


Input:
s = "aaabbcc"
dict = ["aaa","aab","bc"]
Output:
"<b>aaabbc</b>c"

*/
class Solution {
    public String addBoldTag(String s, String[] dict)
    {
        // bold[i] = true means s.charAt(i) should be bold
        boolean[] bold = new boolean[s.length()];

        int end = 0;
        for (int i = 0; i < s.length(); i++)
        {
            for (String word : dict)
            {
                if (s.startsWith(word, i))
                {
                    // extend end, wrap overlap words
                    end = Math.max(end, i + word.length());
                }
            }
            // update bold
            bold[i] = end > i;
        }

        StringBuilder res = new StringBuilder();
        // build final string with bold if necessary
        for (int i = 0; i < s.length(); i++)
        {
            if (!bold[i]) { res.append(s.charAt(i)); }
            else
            {
                int j = i;
                // 找另一端点
                while (j < s.length() && bold[j]) { j++; }
                res.append("<b>").append(s.substring(i, j)).append("</b>");
                i = --j;
            }
        }

        return res.toString();
    }
}
