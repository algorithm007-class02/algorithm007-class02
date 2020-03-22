/*
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:
输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
*/

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* plusOne(int* digits, int digitsSize, int* returnSize){
    if(NULL == digits || 0 == digitsSize)
    {
        *returnSize = 0;
        return NULL;
    }

    for(int i = digitsSize - 1; i >= 0; i--)
    {
		/*不需要加进位变量，能继续往下执行就表示有进位了*/
        if(10 != (digits[i] + 1))
        {
            digits[i]++;
            *returnSize = digitsSize;
            return digits;
        }
        else
        {
            digits[i] = 0;
        }
    }

    int *returndigits = (int *)malloc((digitsSize + 1) * sizeof(int));
    if(NULL == returndigits)
    {
        *returnSize = 0;
        return NULL;
    }
    memset(returndigits, 0, (digitsSize + 1)*sizeof(int));

    returndigits[0] = 1;
    *returnSize = digitsSize + 1;

    return returndigits;
}