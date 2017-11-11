// easy

/*
Given two strings A and B, find the minimum number of times A has to be repeated
such that B is a substring of it. If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring
of it; and B is not a substring of A repeated two times ("abcdabcd").

Note:
The length of A and B will be between 1 and 10000.
*/

class Solution {
    public int repeatedStringMatch(String A, String B)
    {
        if (A.isEmpty() && !B.isEmpty()) { return -1; }
        if (B.isEmpty()) { return 0; }

        int cnt = 0;
        // empty string
        StringBuilder tmp = new StringBuilder();
        while (tmp.length() < B.length())
        {
            tmp.append(A);
            cnt++;
        }

        if (tmp.toString().contains(B)) { return cnt; }
        // append one more time
        if (tmp.append(A).toString().contains(B)) { return ++cnt; }

        return -1;
    }
}
