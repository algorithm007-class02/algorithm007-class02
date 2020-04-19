#include <stdio.h>
int removeDuplicates(int *nums, int numsSize) {
  if (numsSize == 0)
    return 0;
  int i = 0;
  for (int j = 1; j < numsSize; j++) {
    if (nums[j] != nums[i]) {
      i++;
      nums[i] = nums[j];
    }
  }
  return i + 1;
}

int main() {
  int a[5] = {1, 1, 1, 5, 5};
  int ret = removeDuplicates(a, 5);
  printf("%d\n", ret);
  for (int i = 0; i < ret; i++)
    printf("%d,", a[i]);
}