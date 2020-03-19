/*
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:

必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。

*/
void moveZeroes(int* nums, int numsSize){
    int ulNotZeroIndex = 0;
    int ulIndex = 0; 

    for(ulIndex = 0; ulIndex < numsSize; ulIndex++)
    {
        if(0 != nums[ulIndex])
        {
            nums[ulNotZeroIndex] = nums[ulIndex];

            if(ulNotZeroIndex != ulIndex)
            {
                nums[ulIndex] = 0;
            }

            ulNotZeroIndex++;
        }
    }

    return;
}