/**
66 加一
时间复杂度：O（n）
空间复杂度：O（1）
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* plusOne(int* digits, int digitsSize, int* returnSize){
    if (digits == NULL)
        return NULL;

    for (int i = digitsSize-1; i >= 0; i--)
    {
        if (digits[i] != 9)
        {
            digits[i]++;
            *returnSize = digitsSize;
            return digits;
        }

        digits[i] = 0;
    }

    int *retary = NULL;
    *returnSize = digitsSize + 1;

    retary = (int *)malloc(*returnSize * sizeof(int));
    if (retary != NULL)
    {
        memset(retary, 0, *returnSize * sizeof(int));
        retary[0] = 1;
    }

    return retary;
}
