// hard


class Solution {
    public List<String> addOperators(String num, int target)
    {
        List<String> res = new ArrayList<>();

        if (num == null || num.isEmpty()) { return res; }
        helper(num, "", 0, 0, 0, target, res);
        return res;
    }

    private void helper(String num, String path, int pos, long val, long mult, int target, List<String> res)
    {
        // base case
        if (pos == num.length())
        {
            // find a valid expression
            if (val == target)
            {
                res.add(path);
            }
            return;
        }

        for (int i = pos; i < num.length(); i++)
        {
            // prefix 0 invalid
            if (i != pos && num.charAt(pos) == '0') { break; }

            long operand = Long.parseLong(num.substring(pos, i + 1));

            // begin, on operator added
            if (pos == 0)
            {
                helper(num, path + operand, i + 1, operand, operand, target, res);
            }
            else
            {
                // +, -, *
                helper(num, path + "+" + operand, i + 1, val + operand, operand, target, res);
                helper(num, path + "-" + operand, i + 1, val - operand, -operand, target, res);
                // multiple precedence handle
                helper(num, path + "*" + operand, i + 1, val - mult + mult * operand, operand * mult, target, res);
            }

        }
    }
}
