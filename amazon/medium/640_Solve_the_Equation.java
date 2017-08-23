// medium

class Solution {
    public String solveEquation(String equation)
    {
        int[] left = parseEquation(equation.split("=")[0]);
        int[] right = parseEquation(equation.split("=")[1]);

        // move x to left side
        left[0] -= right[0];
        // move constant value to right side
        right[1] -= left[1];

        if (left[0] == 0 && right[1] != 0) { return "No solution"; }
        else if (left[0] == 0 && right[1] == 0) { return "Infinite solutions"; }
        else { return "x=" + right[1] / left[0]; }

    }

    // int[0] is # of x, int[1] is constant value
    private int[] parseEquation(String equ)
    {
        int[] res = new int[2];
        // we need to keep the operator at head if exists
        // e.g: 4, +8x, -3, ....
        String[] parts = equ.split("(?=[+-])");
        for (String p : parts)
        {
            if (p.equals("x") || p.equals("+x")) { res[0]++; }
            else if (p.equals("-x")) { res[0]--; }
            else if (p.contains("x")) { res[0] += Integer.parseInt(p.substring(0, p.length() - 1)); }
            else { res[1] += Integer.parseInt(p); }
        }
        return res;
    }
}
