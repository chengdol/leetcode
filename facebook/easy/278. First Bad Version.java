// easy


/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {

        int l = 1;
        int r = n;
        int mid = l + (r - l ) / 2;

        // 每次只需一次API call
        while (l < r)
        {
            if (isBadVersion(mid))
            {
                // 这里没想到
                r = mid;
            }
            else
            {
                l = mid + 1;
            }

            mid = l + (r - l) / 2;
        }

        return mid;
    }
}
