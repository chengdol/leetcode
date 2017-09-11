// medium

// easy to do with dfs
class Solution {
    public int nextGreaterElement(int n) {

        char[] digits = String.valueOf(n).toCharArray();

        // find the number that smaller then its next one
        int s = digits.length - 2;
        while (s >= 0 && digits[s] >= digits[s + 1]) { s--; }

        // descend-order, e.g: 54321, no result
        if (s < 0) { return -1; }

        // find the smallest number larger then digits[s] in right side partition by digits[s]
        int t = digits.length - 1;
        while (digits[t] <= digits[s]) { t--; }

        // swap s and t
        swap(digits, s, t);
        // reverse right side
        reverse(digits, s + 1);

        try
        {
            return Integer.parseInt(String.valueOf(digits));
        }
        catch(NumberFormatException e)
        {
            // placeholder
        }
        return -1;
    }

    private void swap(char[] arr, int i, int j)
    {
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

    private void reverse(char[] arr, int s)
    {
        int e = arr.length - 1;
        while (s < e)
        {
            swap(arr, s++, e--);
        }
    }
}
