// eays

class Solution {
    public String addBinary(String a, String b) {

        StringBuilder res = new StringBuilder();

        int carry = 0;
        int pa = a.length() - 1;
        int pb = b.length() - 1;

        // 用 || 的思路很好，这样就没有rest需要处理了
        while (pa >= 0 || pb >= 0)
        {
            int sum = carry;
            if (pa >= 0) sum += a.charAt(pa--) - '0';
            if (pb >= 0) sum += b.charAt(pb--) - '0';

            res.append(sum % 2);
            carry = sum / 2;
        }
        // MSB
        if (carry == 1) { res.append(carry); }

        return res.reverse().toString();
    }
}
