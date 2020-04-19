class Solution {
    /**
     * 贪心算法
     *
     * @param children
     * @param cookies
     * @return
     */
    public int findContentChildren(int[] children, int[] cookies) {
        Arrays.sort(children);
        Arrays.sort(cookies);
        int childPoint = 0;
        int cookiePoint = 0;
        while (childPoint < children.length && cookiePoint < cookies.length) {
            if (children[childPoint] <= cookies[cookiePoint]) {
                childPoint++;
            }
            cookiePoint++;
        }
        return childPoint;
    }
}