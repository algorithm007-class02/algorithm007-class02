学习笔记
贪心算法
将问题分成子问题，子问题最优解能达到总问题的最优解

贪心算法和动态规划不同在于每个子问题都作出选择，不能回退

二分查找代码模版
int left = 0,
int right = len(array) - 1 ;
while(left <= right) {
  mid = (left + right) / 2 
  if (array[mid] == target) {
    # find the target!! 
    break or return result 
  } else if (array[mid] < target) {
    left = mid + 1;
  } else {
    ight = mid - 1;
  }
}
