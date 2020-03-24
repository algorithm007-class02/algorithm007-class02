/*
189 旋转数组：
1. 暴力移动法
2. 三次翻转
3. 跳跃移动
*/

#if 1
/* 3. 跳跃移动
   时间复杂度：O(n)
   空间复杂度：O(1)
*/
void rotate(int* nums, int numsSize, int k){
    if (nums == NULL || k == 0)
        return ;

    int i, j;
    int pre, next;
    int count = 0;
    k = k % numsSize;

    for (i = 0; count < numsSize; i++)
    {
        j = i;
        pre = nums[j];
        do
        {
            j = (j + k) % numsSize;
            next = nums[j];
            nums[j] = pre;
            pre = next;

            count++;
        } while (i != j);
    }

    return ;
}
#endif

#if 0
/* 2. 三次翻转 
   时间复杂度：O(n)
   空间复杂度：O(1)
*/
void reverse(int *nums, int start, int end)
{
    while (start < end)
    {
        int tmp = nums[start];
        nums[start] = nums[end];
        nums[end] = tmp;

        start++; 
        end--;
    }

    return ;
}

void rotate(int* nums, int numsSize, int k){
    if (nums == NULL || k == 0)
        return ;

    k = k % numsSize;

    reverse(nums, 0, numsSize-k-1);
    reverse(nums, numsSize-k, numsSize-1);
    reverse(nums, 0, numsSize-1);
    
    return ;
}
#endif

#if 0
/* 1. 暴力移动 
   时间复杂度：O((n-k)*k)
   空间复杂度：O(1)
*/
void rotate(int* nums, int numsSize, int k){
    if (nums == NULL || k == 0)
        return ;

    int i, j, tmp;
    k = k % numsSize;

    for (i = k; i > 0; i--)
    {
        int n = k - i;
        for (j = numsSize-i; j > n; j--)
        {
            tmp = nums[j];
            nums[j] = nums[j-1];
            nums[j-1] = tmp;
        }
    }

    return ;
}
#endif
