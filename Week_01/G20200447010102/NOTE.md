学习笔记
第一周总结
    算法的运用在与代码的精简与运算的速率，在运算速率的计算中，包括时间复杂度和空间复杂度。
    已知的算法优化方法有
        1. 用空间换时间 （ 现有硬件设备的升级换代速度遵从摩尔定律，且现有分布式情况下，服务器出现大部分功能过剩的情况，所以在一般状态下，采用空间换时间的优化策略）
        2. 升维度，已跳表为例，当一维数组的查询在当前状态下无法优化，可以考虑升一维数组为多维数组，利用非一维数组为多维数组的reference来提高查找的相应数组的时间
    
    本周主要学习了数组、链表、跳表的基本实现
        数组为一块连续的内存，链表为一块非连续内存，依靠指针链接；
        链表的尾元素指向空，然而环形链表的尾元素指向头元素；
            数组的优势主要为：查找 时间复杂度为O(1)
            链表的优势主要为：增、删 时间复杂度为O(1)
        跳表则是利用升维的思想通过给链表在高维度增加索引，从而优化了链表的查询时间，这样也带来了新的注意事项，在跳表的增删中，需要对跳表高纬度的索引同样进行更改，从而达到跳表的最优解。需要在工程的实际操作中注意。跳表的实现为REDIS。

    本周练习中的解题技巧
        1. 单指针发
        2. 双指针法
        3. 双指针左右下标
        4. 夹逼法 （必须为有序数组）
        5. 快慢指针法
        6. map存储/查找法

    5遍刷题发进度 （完成）：
        https://leetcode-cn.com/problems/two-sum/
        https://leetcode-cn.com/problems/move-zeroes/
        https://leetcode-cn.com/problems/plus-one/
    未完成
        https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
        https://leetcode-cn.com/problems/rotate-array/
        https://leetcode-cn.com/problems/merge-two-sorted-lists/
        https://leetcode-cn.com/problems/merge-sorted-array/
    未开始
        https://leetcode.com/problems/reverse-linked-list/
        https://leetcode.com/problems/swap-nodes-in-pairs
        https://leetcode.com/problems/linked-list-cycle
        https://leetcode.com/problems/linked-list-cycle-ii
        https://leetcode.com/problems/reverse-nodes-in-k-group/