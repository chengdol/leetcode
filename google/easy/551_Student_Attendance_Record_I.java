// easy

// if-else
class Solution {
    public boolean checkRecord(String s) {

        int A = 0, L = 0;
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (c == 'A') { A++; }

            // smart if-else snippet
            if (c == 'L') { L++; }
            // clean L to 0
            else { L = 0; }

            if (A > 1 || L > 2) { return false; }
        }
        return true;
    }
}

// regex
class Solution {
    public boolean checkRecord(String s) {

        return !s.matches(".*A.*A.*|.*LLL.*");
    }
}
