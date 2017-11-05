// medium

class Solution {
    public int nextGreaterElement(int n)
    {
        char[] num = String.valueOf(n).toCharArray();

        // not possible?
        int i = num.length - 1;
        while (i > 0 && num[i] <= num[i - 1]) { i--; }
        // this means all digits in descending order, bigest number!
        if (i == 0) { return -1; }

        i -= 1;
        // from right, find the first digit greater than num[i];
        int j = num.length - 1;
        while (num[j] <= num[i]) { j--; }

        // swap num[i] and num[j]
        swap(num, i, j);
        // reverse right part partitioning at idx i;
        // 这部分已经是descending order了
        reverse(num, i + 1, num.length - 1);

        try
        {
            return Integer.valueOf(String.valueOf(num));
        }
        catch (Exception e)
        {
            return -1;
        }
    }

    private void swap(char[] num, int i, int j)
    {
        char tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    private void reverse(char[] num, int i, int j)
    {
        while (i < j)
        {
            swap(num, i++, j--);
        }
    }
}
