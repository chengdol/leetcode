// easy

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n)
    {
        int i = m - 1;
        int j = n - 1;
        int idx= m + n - 1;

        // merge from tail to head
        while (i >= 0 && j >= 0)
        {
            if (nums1[i] >= nums2[j])
            {
                nums1[idx--] = nums1[i--];
            }
            else
            {
                nums1[idx--] = nums2[j--];
            }
        }
        // rest
        // 这里只需要填充nums2，因为若nums2先排完，nums1剩下的已经是排好的了
        while (j >= 0)
        {
            nums1[idx--] = nums2[j--];
        }
    }
}
