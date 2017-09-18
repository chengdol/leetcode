// easy


class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty() || s.length() <= 1) { return true; }

        int l = 0;
        int r = s.length() - 1;

        while (l < r)
        {
            char lc = s.charAt(l++);
            char rc = s.charAt(r--);

            while (l < s.length() && !Character.isLetterOrDigit(lc)) { lc = s.charAt(l++); }
            while (r >= 0 && !Character.isLetterOrDigit(rc)) { rc = s.charAt(r--); }

            if (l >= s.length() || r < 0) { return true; }
            if (Character.toLowerCase(lc) != Character.toLowerCase(rc)) { return false; }

        }

        return true;
    }
}
