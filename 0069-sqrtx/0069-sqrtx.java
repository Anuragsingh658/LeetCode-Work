class Solution {
    public int mySqrt(int x) {
        int start = 0, end = x;
        while (start < end) {
            int mid = (start + end + 1) >>> 1;
            if (mid > x / mid) {
                end = mid - 1;
            } else {
                start = mid;
            }
        }
        return start;
    }
}