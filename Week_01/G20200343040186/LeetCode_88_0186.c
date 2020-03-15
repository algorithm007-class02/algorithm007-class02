/*
88 合并两个有序数组
*/

/*
从后往前合并，直接利用nums1空间进行
时间复杂度：O(n+m)
空间复杂度：O(1)
*/
void merge(int* nums1, int nums1Size, int m, int* nums2, int nums2Size, int n){
    if (nums1 == NULL || nums2 == NULL || nums1Size < (m + n))
        return ;

    int z = m + n - 1;
    m--;
    n--;

    while (m >= 0 && n >= 0)
        nums1[z--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];

    if (m < 0)
        for (; n >= 0; n--)
            nums1[z--] = nums2[n];

    return ;
}

#if 0
/*
从前往后合并，需要复制一份nums1内容
时间复杂度：O(n+m)
空间复杂度：O(m)
*/
void merge(int* nums1, int nums1Size, int m, int* nums2, int nums2Size, int n){
    if (nums1 == NULL || nums2 == NULL || nums1Size < (m + n))
        return ;
    
    int i, j, z;

    if (m == 0)
    {
        for (j = 0, z = 0; j < n; j++)        
            nums1[z++] = nums2[j];
        return ;
    }

    int tmpary[m];
    for (i = 0; i < m; i++)
        tmpary[i] = nums1[i];
    
    i = j = z = 0;

    while (i < m && j < n)
        nums1[z++] = tmpary[i] <= nums2[j] ? tmpary[i++] : nums2[j++];

    if (i >= m)
        for (; j < n; j++)        
            nums1[z++] = nums2[j];
    else
        for (; i < m; i++)        
            nums1[z++] = tmpary[i];

    return ;
}
#endif
