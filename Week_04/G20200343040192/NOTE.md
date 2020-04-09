### 学习笔记

**团灭股票买卖**

一个大佬的LeetCode解题思想集，分享给大家

根本思想就是状态机，穷举所有状态

https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/tuan-mie-gu-piao-wen-ti

**课后作业**
使用二分查找，寻找一个半有序数组[4, 5, 6, 7, 0, 1, 2]中间无序的地方
说明：同学们可以将自己的思路、代码写在第4周的学习总结中

1.先判断空，头尾无序
2.二分查找
3.中间无序的地方，其左右两边必然一个为单调递增，一个为单调递减
遍历半有序数组元素，然后对元素（n 下标）向前探（n-1）向后探（n+1）判断其单调性是否一致

```java
class Solution {

  public static int calculate(int[] array) {
    int left = 0;
    int right = array.length - 1;
    while (left < right) {
      int mid = left + ((right - left) >> 1);
      if (array[mid] > array[right]) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }
} 
```