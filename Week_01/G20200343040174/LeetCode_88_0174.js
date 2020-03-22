/**
 * Created by wangqingxia on 2020/3/15.
 */

/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {
    nums1.length = m;
    nums2.length = n;
    Object.assign(nums1,[...nums1,...nums2]);
    nums1.sort(function (a,b) {
        return a - b;
    });
};
var merge2 = function(nums1, m, nums2, n) {
    nums1.length = m;
    nums2.length = n;
    while (n--) {
        while (m >= 0) {
            if (m === 0 || nums2[n] > nums1[m - 1]) {
                nums1.splice(m, 0, nums2[n]);
                //nums1.pop();
                break
            }
            m--
        }
    }
};